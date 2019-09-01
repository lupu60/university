# Express , sequelizejs and mongoose

## install deps

```sh
npm install -g  sequelize-cli
npm install
```

## setup databases

```sh
docker network create --driver bridge devnetwork

docker network inspect devnetwork

docker run --name devmongo -p 27017:27017 --network=devnetwork -d mongo

docker run --name dvpostgres -p 32768:5432 --network=devnetwork -d postgres

docker exec -it dvpostgres psql --username postgres -c \ "CREATE DATABASE devdb OWNER postgres;"

docker exec -it dvpostgres psql --username postgres -c \ "GRANT ALL PRIVILEGES ON DATABASE devdb TO postgres;"

```

## run the backend

```sh
nodemon
npm run start:dev
```

after you setup the connection info for the database in src/config/config.js run

```sh
sequelize db:migrate
```

this will create the tables in your database.

for generatic models

```sh
sequelize model:create --name user --attributes username:string,password:string
```
