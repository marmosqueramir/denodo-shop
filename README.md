# Documencatión

Se han cambiado las columnas fecha y hora, unificándolas. Esto es debido a que daban 
problemas a la hora de hacer los filtrados por hora y fecha  a la vez. 
De esta forma se simplifica. Después si queremos mostrarlo por separado pordría hacerse.

## Arrancar el proyecto

Debemos tener instalado Docker. Por ejemplo Docker Desktop: *https://docs.docker.com/desktop/*

### Configuración de la Base de Datos PostgreSQL
A continuación primero debemos crear una base de datos postgreSQL.
Para ello se ha creado un ***docker-compose.yaml***. Este archivo
se encuentra en */denodo-shop/docker/postgreSQL*. Para arrancarlo seguiremos
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
![paso1.png](docker%2FpostgreSQL%2Fimages%2Fpaso1.png)
![paso2.png](docker%2FpostgreSQL%2Fimages%2Fpaso2.png)
![paso3.png](docker%2FpostgreSQL%2Fimages%2Fpaso3.png)
- password: postgres

Y lo salvamos.  

Ahora vamos a crear la base de datos. Sigue las siguientes instrucciones:
![paso4.png](docker%2FpostgreSQL%2Fimages%2Fpaso4.png)
![paso5.png](docker%2FpostgreSQL%2Fimages%2Fpaso5.png)

Salvamos y ya tenemos la base de datos configurada.

### Arrancar la aplicación

