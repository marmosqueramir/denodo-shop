# Documentación

Se han cambiado las columnas fecha y hora, unificándolas. Esto es debido a que daban 
problemas a la hora de hacer los filtrados por hora y fecha  a la vez. 
De esta forma se simplifica. Después si queremos mostrarlo por separado pordría hacerse.

## Arrancar el proyecto

Debemos tener instalado Docker. Por ejemplo Docker Desktop: *https://docs.docker.com/desktop/*

### Configuración de la Base de Datos PostgreSQL
A continuación primero debemos crear una base de datos postgreSQL.
Para ello se ha creado un ***docker-compose.yaml***. Este archivo
se encuentra en */denodo-shop/documentation/docker/postgreSQL*. Para arrancarlo seguiremos
los siguientes comandos:

```docker-compose up -d```

Con la opción *-d* hacemos que se ejecute en segundo plano. Par ano bloquear la terminal.
Cuando tenemos el contenedor Docker corriendo tendremos dos servicios:

- pgAdmin4: para la gestión de la base de datos. Así no tenemos que descargar ningún cliente. 
- PostgreSQL: una base de datos relacional postgreSQL.

Vamos a crear un servidor para poder crear nuestra base de datos. Para esto accedemos
a pgAdmin4. En nuestro navegador accedemos a ```localhost:5050/browser/``` y nos loggeamos:
- User/Password: admin@example.com/admin

Ahora vamos a crear el servidor siguiendo los pasos de las siguientes imágenes.
![paso1.png](documentation%2Fimages%2Fpaso1.png)
![paso2.png](documentation%2Fimages%2Fpaso2.png)
![paso3.png](documentation%2Fimages%2Fpaso3.png)
- password: postgres

Y lo salvamos.  

Ahora vamos a crear la base de datos. Sigue las siguientes instrucciones:
![paso4.png](documentation%2Fimages%2Fpaso4.png)
![paso5.png](documentation%2Fimages%2Fpaso5.png)

Salvamos y ya tenemos la base de datos configurada.

### Arrancar la aplicación
Tener instalado Maven y el JDK17.  

Descarga la aplicación de github y lanza los siguientes comandos.
```mvn clean install```
```mvnw spring-boot:run```
Si tienes el IDE IntelliJ. Puedes no tener seteado en tus variables de entorno
el JDK17. Y así es más sencillo. Simplemente después de hacer el install,
creas una confguración.
![runApp.png](documentation%2Fimages%2FrunApp.png)

Una vez arranca la aplicación puedes probarla con Postman. O acceder a la url:
http://localhost:8080/swagger-ui/index.html y probarla.  
También se ha añadido la colección de postman con dos peticiones, una para probar correctamente la petición
y otra para comprobar que se lanzaba correctamente la excepción. [SHOP_COLLECTION.postman_collection.json](documentation%2Fpostman-collections%2FSHOP_COLLECTION.postman_collection.json)

### Notas
Respecto al diseño, se podría haber hecho de otras formas. Pero teniendo en cuenta que eran sencillo
se ha optado por dividir en controller servicio y el modelo. Podríamos haber hecho un módulo
para cada entidad por ejemplo. Para separar completamente una entidad de otra.
