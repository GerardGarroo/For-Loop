Práctica 1: 
¡Hola! En esta primera práctica hemos sentado las bases de nuestro proyecto. El objetivo principal ha sido configurar un entorno de trabajo sólido y colaborativo para que todo el equipo trabaje sobre la misma base.

¿Qué hemos hecho?
Consenso técnico: Nos hemos puesto de acuerdo para usar Java 17 y Spring Boot. Así evitamos que a uno le funcione y al otro no por culpa de las versiones.

Proyecto Base: Hemos generado el esqueleto de la aplicación usando Spring Initializr con el gestor de dependencias Maven.

Control de Versiones: Hemos organizado el repositorio de GitHub por carpetas (Producto 1, Producto 2, etc.) para que todo el semestre esté ordenado en un mismo sitio.

(Hello World): Hemos creado nuestro primer controlador (HolaController.java). Si entras en la app, verás un mensaje de bienvenida que confirma que el servidor de aplicaciones está vivo y escuchando.

Contenedor con Docker: Como pide el Producto hemos creado un Dockerfile. Este archivo permite que cualquier persona del equipo (o el profesor) ejecute la aplicación exactamente igual, sin tener que configurar nada en su sistema.

Cómo probarlo rápido
Si tienes Docker abierto, solo tienes que situarte en la carpeta del proyecto y lanzar:

docker build -t forloopapp .
docker run -p 8080:8080 forloopapp
Y listo, en http://localhost:8080 verás el resultado.

Equipo de trabajo:

Gerard Garro Parera

Ferran Brigido Calpe Romero