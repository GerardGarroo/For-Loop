Producto 2 — Primer MVC

    ¿Qué hemos construido?
En este producto hemos desarrollado la capa de datos y las primeras vistas de
la aplicación **¡AlquilaTusVehiculos!**. Partiendo de la base del Producto 1,
hemos implementado el modelo de datos completo, la persistencia con Spring Data
JPA y el CRUD de vehículos con sus vistas en Thymeleaf.

    Decisiones técnicas
- **Base de datos:** H2 (embebida, no requiere instalación)
- **ORM:** Spring Data JPA con Hibernate
- **Motor de plantillas:** Thymeleaf
- **Versión Spring Boot:** 4.0.2

    Entidades implementadas
- **Vehículo** — con CRUD completo
- **Cliente** — listado
- **Sede** — listado
- **Alquiler** — listado con estadísticas

    Cómo ejecutarlo
-Con Docker
```bash
docker build -t forloopapp .
docker run -p 8080:8080 forloopapp
```
-Sin Docker
```bash
./mvnw spring-boot:run
```
La app estará disponible en `http://localhost:8080`

    Consola H2
Para inspeccionar la base de datos entra en `http://localhost:8080/h2-console`
con los siguientes datos:
- **JDBC URL:** `jdbc:h2:mem:alquiladb`
- **User:** `sa`
- **Password:** *(vacío)*

    Equipo
- Gerard Garro Parera
- Ferran Brigido Calpe Romero