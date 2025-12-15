# Lista de Tareas - API Cervezas Spring Boot

## Fase 1: Configuración Base
- [x] 1. Configurar la base de datos MySQL
  - Configurar `application.properties` con conexión a MySQL
  - Verificar conexión con la base de datos
  - Cargar scripts SQL iniciales (beers.sql, breweries.sql, categories.sql, styles.sql)

- [x] 2. Crear las entidades JPA (Beer, Brewery, Category, Style)
  - Crear entidad `Beer` con sus atributos y anotaciones JPA
  - Crear entidad `Brewery` con sus atributos y anotaciones JPA
  - Crear entidad `Category` con sus atributos y anotaciones JPA
  - Crear entidad `Style` con sus atributos y anotaciones JPA
  - Definir relaciones entre entidades

- [x] 3. Crear los repositorios JPA para cada entidad
  - Crear `BeerRepository` (extends JpaRepository)
  - Crear `BreweryRepository` (extends JpaRepository)
  - Crear `CategoryRepository` (extends JpaRepository)
  - Crear `StyleRepository` (extends JpaRepository)

## Fase 2: CRUD Completo de Beer
- [ ] 4. Implementar el servicio para Beer (lógica de negocio)
  - Crear interfaz `BeerService`
  - Crear implementación `BeerServiceImpl`
  - Implementar métodos de negocio (findAll, findById, save, update, delete)

- [ ] 5. GET /beers - Listar todas las cervezas
  - Crear `BeerController`
  - Implementar endpoint GET `/beers`
  - Retornar lista completa de cervezas

- [ ] 6. GET /beer/{id} - Obtener una cerveza por ID
  - Implementar endpoint GET `/beer/{id}`
  - Manejar caso de cerveza no encontrada (404)

- [ ] 7. POST /beer - Crear una nueva cerveza
  - Implementar endpoint POST `/beer`
  - Validar datos de entrada
  - Retornar cerveza creada con código 201

- [ ] 8. PUT /beer/{id} - Actualizar una cerveza completa
  - Implementar endpoint PUT `/beer/{id}`
  - Actualizar todos los campos de la cerveza
  - Manejar caso de cerveza no encontrada

- [ ] 9. PATCH /beer/{id} - Actualizar parcialmente una cerveza
  - Implementar endpoint PATCH `/beer/{id}`
  - Actualizar solo los campos proporcionados
  - Mantener valores existentes en campos no especificados

- [ ] 10. DELETE /beer/{id} - Eliminar una cerveza
  - Implementar endpoint DELETE `/beer/{id}`
  - Eliminar cerveza de la base de datos
  - Retornar código 204 (No Content)

## Fase 3: Endpoints de Solo Lectura

### Brewery
- [ ] 11. Implementar servicio y controlador para Brewery - GET /breweries
  - Crear `BreweryService` e implementación
  - Crear `BreweryController`
  - Implementar endpoint GET `/breweries`

- [ ] 12. Implementar servicio y controlador para Brewery - GET /brewerie/{id}
  - Implementar endpoint GET `/brewerie/{id}`
  - Manejar caso de cervecera no encontrada

### Category
- [ ] 13. Implementar servicio y controlador para Category - GET /categories
  - Crear `CategoryService` e implementación
  - Crear `CategoryController`
  - Implementar endpoint GET `/categories`

- [ ] 14. Implementar servicio y controlador para Category - GET /categorie/{id}
  - Implementar endpoint GET `/categorie/{id}`
  - Manejar caso de categoría no encontrada

### Style
- [ ] 15. Implementar servicio y controlador para Style - GET /styles
  - Crear `StyleService` e implementación
  - Crear `StyleController`
  - Implementar endpoint GET `/styles`

- [ ] 16. Implementar servicio y controlador para Style - GET /style/{id}
  - Implementar endpoint GET `/style/{id}`
  - Manejar caso de estilo no encontrado

## Fase 4: Pruebas y Documentación
- [ ] 17. Probar todos los endpoints con Postman/Insomnia/curl
  - Probar todos los endpoints de Beer (CRUD completo)
  - Probar todos los endpoints de Brewery
  - Probar todos los endpoints de Category
  - Probar todos los endpoints de Style
  - Verificar códigos de estado HTTP correctos
  - Verificar manejo de errores

- [ ] 18. Guardar las peticiones de prueba en fichero de resultados
  - Exportar colección de Postman/Insomnia
  - Documentar ejemplos de respuestas
  - Guardar ejemplos de curl

- [ ] 19. Crear documento de uso de la API con ejemplos de consultas
  - Documentar cada endpoint
  - Incluir ejemplos de peticiones
  - Incluir ejemplos de respuestas
  - Documentar códigos de error

## Fase 5: Mejoras Opcionales (Ir más lejos)
- [ ] 20. Implementar paginación para endpoints con muchos datos
  - Implementar paginación en GET /beers
  - Implementar método HEAD para metadata
  - Añadir parámetros de paginación (page, size, sort)

- [ ] 21. Integrar Swagger/OpenAPI para documentación
  - Añadir dependencia de Swagger/SpringDoc
  - Configurar Swagger UI
  - Añadir anotaciones de documentación a los endpoints

- [ ] 22. Implementar subida de imágenes de cervezas
  - Añadir endpoint para subir imágenes
  - Configurar almacenamiento de imágenes
  - Asociar imágenes con cervezas

---

## Notas
- Marcar con `[x]` las tareas completadas
- Añadir comentarios o notas según sea necesario
- Actualizar este archivo conforme avances en el proyecto
