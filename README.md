# Java Product Service

## Consideraciones iniciales 馃
- Este en este proyecto se ha construido una aplicaci贸n con Spring Booy y Java 11 que da soluci贸n a la prueba t茅cnica propuesta [en este repositorio][link1].
- La propuesta de soluci贸n se ha llevado a cabo planteando una arquitectura hexagonal. 
- Para la comunicaci贸n con el servicio expuesto en el puerto 3001 se ha utilizado [Spring Cloud OpenFeing][link2]. Al realizar las peticiones a este servicio se ha observado que existian retardos al obtener la respuesta, dependiendo del producto que se consulta, por lo que se ha decidido utilizar un TimeOut para que la experiencia de usuario no se vea afectada.

## Ejecutar la aplicaci贸n 馃馃徎鈥嶐煉?
Todas las acciones se realizar谩n con Maven.
- Complilar y ejecutar los test
```shell
mvn clean install
``` 
- Ejecutar la aplicaci贸n
```shell
mvn spring-boot:run
``` 

[link1]: https://github.com/dalogax/backendDevTest
[link2]: https://cloud.spring.io/spring-cloud-openfeign/reference/html/