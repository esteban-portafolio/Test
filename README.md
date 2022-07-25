# Test

Prueba de Experis para desarrollo Backend

Requerimiento:

• Crear una aplicación con Spring Boot (https://start.spring.io/) que use Maven y Java 8. 
• Puede usar cualquier base de datos relacional, incluso H2. 
• Utilizar JPA para la persistencia y creación de las tablas en BD. 
• El proyecto debe tener al menos 2 entidades, relacionadas entre sí, con cardinalidad 1 a muchos. 
• Las entidades deben contar con al menos los siguientes tipos de datos (pueden estar repartidos entre las entidades): o Fecha (con formato dd-mm-yyyy) o Texto (largo 255 caracteres). o Entero. o Decimal. o Booleano. 
• PK autoincremental.
• Construir servicios REST para el CRUD de la entidad principal.
 
FAVOR DE USAR POSTMAN PARA LAS PRUEBAS

Primer Commit - La aplicacion completada en su totalidad pero __ sin las Relaciones OnetoMany __, las cuales debo generar las pruebas pertinentes.

Segundo Commit - Se agregan las relaciones dentro del Proyecto @OneToMany , al principio con errores al traer los datos, por un tema de dependecia entre ellos. Pero ya se pudo corregir modificando
					gran parte del codigo para poder establecer y mapear de forma correcta los datos.

Tercer Commit - Se agrega la exepcion de que si el Departamento esta 'False' o deshabilitado, no se pueda agregar un Empleado.

Cuarto Commit - Se agregan las colecciones de POSTMAN que se ocuparon para realizar las pruebas correspondientes:

		* Departamento.postman_collection
		* Empleado.postman_collection
