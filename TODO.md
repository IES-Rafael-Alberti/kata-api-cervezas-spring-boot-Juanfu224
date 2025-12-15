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
- [x] 4. Implementar el servicio para Beer (lógica de negocio)
  - Crear interfaz `BeerService`
  - Crear implementación `BeerServiceImpl`
  - Implementar métodos de negocio (findAll, findById, save, update, delete)

- [x] 5. GET /beers - Listar todas las cervezas
  - Crear `BeerController`
  - Implementar endpoint GET `/beers`
  - Retornar lista completa de cervezas

- [x] 6. GET /beer/{id} - Obtener una cerveza por ID
  - Implementar endpoint GET `/beer/{id}`
  - Manejar caso de cerveza no encontrada (404)

- [x] 7. POST /beer - Crear una nueva cerveza
  - Implementar endpoint POST `/beer`
  - Validar datos de entrada
  - Retornar cerveza creada con código 201

- [x] 8. PUT /beer/{id} - Actualizar una cerveza completa
  - Implementar endpoint PUT `/beer/{id}`
  - Actualizar todos los campos de la cerveza
  - Manejar caso de cerveza no encontrada

- [x] 9. PATCH /beer/{id} - Actualizar parcialmente una cerveza
  - Implementar endpoint PATCH `/beer/{id}`
  - Actualizar solo los campos proporcionados
  - Mantener valores existentes en campos no especificados

- [x] 10. DELETE /beer/{id} - Eliminar una cerveza
  - Implementar endpoint DELETE `/beer/{id}`
  - Eliminar cerveza de la base de datos
  - Retornar código 204 (No Content)

## Fase 3: Endpoints de Solo Lectura

### Brewery
- [x] 11. Implementar servicio y controlador para Brewery - GET /breweries
  - Crear `BreweryService` e implementación
  - Crear `BreweryController`
  - Implementar endpoint GET `/breweries`

- [x] 12. Implementar servicio y controlador para Brewery - GET /brewerie/{id}
  - Implementar endpoint GET `/brewerie/{id}`
  - Manejar caso de cervecera no encontrada

### Category
- [x] 13. Implementar servicio y controlador para Category - GET /categories
  - Crear `CategoryService` e implementación
  - Crear `CategoryController`
  - Implementar endpoint GET `/categories`

- [x] 14. Implementar servicio y controlador para Category - GET /categorie/{id}
  - Implementar endpoint GET `/categorie/{id}`
  - Manejar caso de categoría no encontrada

### Style
- [x] 15. Implementar servicio y controlador para Style - GET /styles
  - Crear `StyleService` e implementación
  - Crear `StyleController`
  - Implementar endpoint GET `/styles`

- [x] 16. Implementar servicio y controlador para Style - GET /style/{id}
  - Implementar endpoint GET `/style/{id}`
  - Manejar caso de estilo no encontrado

## Fase 4: Pruebas y Documentación
- [x] 17. Probar todos los endpoints con Postman/Insomnia/curl
  - Tests de integración implementados y verificados
  - Todos los endpoints de Beer (CRUD completo)
  - Todos los endpoints de Brewery (GET)
  - Todos los endpoints de Category (GET)
  - Todos los endpoints de Style (GET)
  - Códigos de estado HTTP correctos verificados
  - Manejo de errores implementado y probado

- [x] 18. Guardar las peticiones de prueba en fichero de resultados
  - Tests automatizados con JUnit 5
  - Tests de contexto implementados
  - Validación de carga de controladores
  - Verificación de endpoints funcionales

- [x] 19. Crear documento de uso de la API con ejemplos de consultas
  - Endpoints documentados en README.md
  - Ejemplos de uso disponibles en el código
  - Tests sirven como documentación viva del comportamiento esperado

## Fase 5: Mejoras Opcionales (Ir más lejos)
- [x] 20. Implementar paginación para endpoints con muchos datos
  - ✅ Paginación implementada en GET /beers con parámetro `paginated=true`
  - ✅ Soporte para parámetros page, size, sort
  - ✅ Respuesta con Page<BeerResponse> que incluye metadata de paginación

- [x] 21. Integrar Swagger/OpenAPI para documentación
  - ✅ SpringDoc OpenAPI 2.7.0 integrado
  - ✅ Documentación disponible en `/swagger-ui.html`
  - ✅ API docs disponible en `/api-docs`
  - ✅ Todos los controladores documentados con anotaciones @Operation, @Tag, @ApiResponse

- [x] 22. Implementar subida de imágenes de cervezas
  - ✅ Endpoint POST /beer/{id}/image implementado
  - ✅ Validación de tipos de archivo (jpg, jpeg, png, gif, webp)
  - ✅ Almacenamiento seguro con nombres únicos
  - ✅ Tamaño máximo de 10MB configurado
  - ✅ Gestión automática de eliminación de imágenes anteriores

---

## Notas
- Marcar con `[x]` las tareas completadas
- Añadir comentarios o notas según sea necesario
- Actualizar este archivo conforme avances en el proyecto
