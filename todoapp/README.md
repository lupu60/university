# todoapp
# TODO LIST

	
1 Run for the first time on a new local pc:

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


Populate category table

```sql
INSERT INTO `category`(`name`) VALUES ("shopping");
INSERT INTO `category`(`name`) VALUES ("work");
INSERT INTO `category`(`name`) VALUES ("hobby");
```

pop priority table
```sql
INSERT INTO `priority`(`name`) VALUES ("high");
INSERT INTO `priority`(`name`) VALUES ("medium");
INSERT INTO `priority`(`name`) VALUES ("low");
```
pop status table
```sql
INSERT INTO `status`(`name`) VALUES ("in_progress");
INSERT INTO `status`(`name`) VALUES ("done");
```

REST DOC

* Create user: make a POST to [srv]/createUser
```json
{
  "firstName": null,
  "lastName": null,
  "username": null,
  "password": null,
  "email": null
}
```
* Login : make a POST  to [srv]/login
```json
{
    "username":"user",
    "password":"pass"
}
```

* get cat
add header auth with the login token