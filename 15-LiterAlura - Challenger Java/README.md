# LiterAlura - Catálogo de Libros y Autores
Este proyecto Java se centra en la construcción de un catálogo de libros y autores utilizando diversas tecnologías y herramientas, como [Spring Boot](https://spring.io/projects/spring-framework), [PostgreSQL](https://www.postgresql.org/), y la API [Gutendex](https://gutendex.com/).

#


### Configuración del Entorno de Desarrollo
#### Asegúrate de tener instalados los siguientes programas y versiones:

* Java JDK 17 o superior
* Maven 4 o superior
* Spring Boot 3.2.3
* Postgres 16 o superior
* IDE IntelliJ IDEA (opcional)

#

>[!NOTE] 
>Configuración del Proyecto Spring
>Configuración del proyecto en Spring Initializr con las dependencias necesarias.
>Integración con la API Gutendex para consultar información sobre libros.

#


>[!NOTE]  
>Construyendo el Cliente para Solicitudes HTTP
>Uso de HttpClient para realizar solicitudes a la API de libros.
>Configuración y personalización de HttpRequest para adaptar las consultas.
>Gestión de respuestas HTTP utilizando la interfaz HttpResponse.

#


>[!NOTE]  
>Análisis de Respuestas JSON con Jackson
>Manipulación eficiente de datos JSON utilizando la biblioteca Jackson.
>Mapeo de datos JSON a objetos Java para facilitar su manipulación.

#

>[!NOTE]  
>Interacción con el Usuario
>Implementación de CommandLineRunner para interactuar con el usuario.
>Utilización de la clase Scanner para capturar la entrada del usuario.
>Exhibición de información solicitada y manejo de errores.

#

>[!NOTE]  
>Construcción de la Base de Datos
>Utilización de PostgreSQL como base de datos.
>Creación de clases de entidad/modelo y repositorios para libros y autores.
>Mantenimiento de la relación entre libros y autores en la base de datos.

#

>[!NOTE]  
>Exhibición de Estadísticas
>Utilización de Streams de Java y derived queries para exhibir estadísticas sobre los libros en la base de datos.

#

>[!NOTE]  
>Consulta de Autores Vivos por Año
>Implementación de derived queries para listar autores vivos en un año específico.

---


