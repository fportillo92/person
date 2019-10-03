# API REST Service for CRUD Persons Using Spring-Boot

<a href="http://www.repostatus.org/#active"><img src="http://www.repostatus.org/badges/latest/active.svg" alt="Project Status: Active – The project has reached a stable, usable state and is being actively developed." /></a>

+ API REST que te permite realizar operaciones sobre personas, creada en Spring-boot usando JPA.

<p align="center">
<b><a href="#requisitos">Requisitos</a></b>
|
<b><a href="#LevantarEntornoLocal">Levantar entorno local</a></b>
</p>


## Requisitos

* Java - 1.8.x
* JDK - 1.8.x
* MySQL - 5.x.x
* Maven

## Levantar entorno local

**1. Clonar repositorio en una carpeta local.**

```bash
git clone https://github.com/fportillo92/person.git
```

**2. Correr el script sql que se encuentra en la carpeta scripts: person/scripts/database-project.sql**

**4. Correr la app usando Maven**

```bash
mvn package
java -jar target/person-0.0.1-SNAPSHOT.jar
```
 o 
 
```bash
mvn spring-boot:run
```

+ La app se levanta en <http://localhost:8080>.
+ Para ver la documentacion Swagger: <http://localhost:8080/swagger-ui.html#/>



### Aclaracion: Se puede levantar ejemplos de invocacion a la api desde postman importando el archivo que esta en person/postman/invocaciones.json
