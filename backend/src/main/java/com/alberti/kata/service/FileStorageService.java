package com.alberti.kata.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    
    String storeFile(MultipartFile file, Integer beerId);
    
    void deleteFile(String filename);
}
