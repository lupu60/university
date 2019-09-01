# TODO LIST

	
Run for the first time on a new local pc:

* Run MAVEN CLEAN 
* Run MAVEN INSTALL
* SetUp MySQL server(prefer XAMPP) and create an empty "mitb" database
* Go in the application.properties:
 ```bash

##################
#Tomcat Configuration
##################
server.port = 8090

##############3
#Db Configuration
################
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.database=MYSQL
spring.jpa.hibernate.ddl-auto=update
##spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost/mitb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database=mysql 
```
comment the line
```bash
spring.jpa.hibernate.ddl-auto=update
```
and decomment the line 
```bash
##spring.jpa.hibernate.ddl-auto=create
```

And the app will create the database schema. Then return to the initial format.
