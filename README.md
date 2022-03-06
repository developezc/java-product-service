# java-product-service

## Consideraciones iniciales 🤔
- Este en este proyecto se ha construido una aplicación con Spring Booy y Java 11 que da solución a la prueba técnica propuesta [en este repositorio][link1].
- La propuesta de solución se ha llevado a cabo planteando una arquitectura hexagonal. 
- Para la comunicación con el servicio expuesto en el puerto 3001 se ha utilizado [Spring Cloud OpenFeing][link2]. Al realizar las peticiones a este servicio se ha observado que existian retardos al obtener la respuesta, dependiendo del producto que se consulta, por lo que se ha decidido utilizar un TimeOut para que la experiencia de usuario no se vea afectada.

## Ejecutar la aplicación 🧑🏻‍💻
Todas las acciones se realizarán con Maven.
- Complilar y ejecutar los test
```shell
mvn clean install
``` 
- Ejecutar la aplicación
```shell
mvn spring-boot:run
``` 

[link1]: https://github.com/dalogax/backendDevTest
[link2]: https://cloud.spring.io/spring-cloud-openfeign/reference/html/