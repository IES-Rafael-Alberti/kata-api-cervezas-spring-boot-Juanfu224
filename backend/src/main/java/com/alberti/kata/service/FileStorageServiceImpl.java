package com.alberti.kata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path uploadDir;

    public FileStorageServiceImpl(@Value("${file.upload-dir}") String uploadDir) {
        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
        initializeDirectory();
    }

    private void initializeDirectory() {
        try {
            Files.createDirectories(uploadDir);
            log.info("Directorio de almacenamiento creado: {}", uploadDir);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el directorio de almacenamiento", e);
        }
    }

    @Override
    public String storeFile(MultipartFile file, Integer beerId) {
        validateFile(file);
        
        String originalFilename = Objects.requireNonNull(file.getOriginalFilename());
        String extension = getFileExtension(originalFilename);
        String filename = "beer_" + beerId + "_" + UUID.randomUUID() + extension;
        
        try {
            Path targetLocation = uploadDir.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            log.info("Archivo guardado: {}", filename);
            return filename;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo: " + filename, e);
        }
    }

    @Override
    public void deleteFile(String filename) {
        if (filename == null || filename.isBlank()) {
            return;
        }
        
        try {
            Path filePath = uploadDir.resolve(filename).normalize();
            Files.deleteIfExists(filePath);
            log.info("Archivo eliminado: {}", filename);
        } catch (IOException e) {
            log.error("Error al eliminar el archivo: {}", filename, e);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío");
        }

        String filename = file.getOriginalFilename();
        if (filename == null || filename.contains("..")) {
            throw new IllegalArgumentException("Nombre de archivo inválido: " + filename);
        }

        String extension = getFileExtension(filename).toLowerCase();
        if (!extension.matches("\\.(jpg|jpeg|png|gif|webp)")) {
            throw new IllegalArgumentException("Solo se permiten archivos de imagen (jpg, jpeg, png, gif, webp)");
        }
    }

    private String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        return lastDot > 0 ? filename.substring(lastDot) : "";
    }
}
