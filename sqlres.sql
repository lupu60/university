CREATE TABLE "summer_tire2" ("id" SERIAL NOT NULL,"brand" TEXT NOT NULL,"size" TEXT NOT NULL,"profile" TEXT NOT NULL,"speed_rating" TEXT NOT NULL,"quantity" integer NOT NULL,"price" integer NOT NULL,CONSTRAINT summer_tire_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);



CREATE TABLE "winter_tire" ("id" SERIAL NOT NULL,"brand" TEXT NOT NULL,"size" TEXT NOT NULL,"profile" TEXT NOT NULL,"speed_rating" TEXT NOT NULL,"quantity" integer NOT NULL,"price" integer NOT NULL,CONSTRAINT winter_tire_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);



CREATE TABLE "agricultural_tire" ("id" SERIAL NOT NULL,"brand" TEXT NOT NULL,"size" TEXT NOT NULL,"profile" TEXT NOT NULL,"speed_rating" TEXT NOT NULL,"quantity" integer NOT NULL,"price" integer NOT NULL,CONSTRAINT agricultural_tire_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);



CREATE TABLE "customers" ("id" SERIAL NOT NULL,"name" TEXT NOT NULL,"phone_no" varchar(55) NOT NULL,CONSTRAINT customers_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);



CREATE TABLE "orders" ("id" SERIAL NOT NULL,"customer_id" integer NOT NULL,CONSTRAINT orders_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);



CREATE TABLE "order_items" ("id" serial NOT NULL,"order_id" integer NOT NULL,"winter_id" integer NOT NULL,"agricultural_id" integer NOT NULL,"summer_id" integer NOT NULL,CONSTRAINT order_items_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);





ALTER TABLE "orders" ADD CONSTRAINT "orders_fk0" FOREIGN KEY (customer_id) REFERENCES customers(id);

ALTER TABLE "order_items" ADD CONSTRAINT "order_items_fk0" FOREIGN KEY (order_id) REFERENCES orders(id);
ALTER TABLE "order_items" ADD CONSTRAINT "order_items_fk1" FOREIGN KEY (winter_id) REFERENCES winter_tire(id);
ALTER TABLE "order_items" ADD CONSTRAINT "order_items_fk2" FOREIGN KEY (agricultural_id) REFERENCES agricultural_tire(id);
ALTER TABLE "order_items" ADD CONSTRAINT "order_items_fk3" FOREIGN KEY (summer_id) REFERENCES summer_tire(id);

INSERT INTO order_items (order_id,winter_id,agricultural_id,summer_id) values (4,1,1,1);

ALTER TABLE `orders` DROP FOREIGN KEY `orders_fk0`;

ALTER TABLE `order_items` DROP FOREIGN KEY `order_items_fk0`;

ALTER TABLE `order_items` DROP FOREIGN KEY `order_items_fk1`;

ALTER TABLE `order_items` DROP FOREIGN KEY `order_items_fk2`;

ALTER TABLE `order_items` DROP FOREIGN KEY `order_items_fk3`;

DROP TABLE IF EXISTS `summer_tire2`;

DROP TABLE IF EXISTS `winter_tire`;

DROP TABLE IF EXISTS `agricultural_tire`;

DROP TABLE IF EXISTS `customers`;

DROP TABLE IF EXISTS `orders`;

DROP TABLE IF EXISTS `order_items`;


CREATE TABLE summer_tire (id SERIAL, brand text,size text,profile text,speed_rating text,quantity int, price int);

INSERT INTO summer_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('DEBICA','145/80R13','PASSIO','75T',2,125 );
INSERT INTO summer_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('KORMORAN','155/65R13','155/65R13','75T',2,128 );
INSERT INTO summer_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('TIGAR','225/70R15C','WINTER','q',2,420 );







CREATE TABLE winter_tire (id SERIAL, brand text,size text,profile text,speed_rating text,quantity int, price int);

INSERT INTO winter_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('DEBICA', '155/65R13', 'FRIGO 2', '73T', 13, 180);
INSERT INTO winter_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('MAXXIS', '265/65R17', 'AT-771', '112T', 4, 800);
INSERT INTO winter_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('ROCKSTONE', '235/65R16C', 'S-110 8PR  M+S', '115/113R', 8, 450 );
INSERT INTO winter_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('GOODYEAR','235/45R17','GW3','94H',32, 740);




INSERT INTO agricultural_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('PETLAS ','10---16.5','IND  15','q',32, 1000);
INSERT INTO agricultural_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values ('ALLIANCE ','11,2---28','IND  15','q',2, 1160);


CREATE TABLE "customers" ("id" SERIAL NOT NULL,"name" TEXT NOT NULL,"phoneNo" varchar(55) NOT NULL,"phone_no" varchar(55) NOT NULL,CONSTRAINT customers_pk PRIMARY KEY ("id")) WITH (OIDS=FALSE);


INSERT INTO customers (name,phone_no) values ('vasile','074456466');


INSERT INTO orders (customer_id) values (1);
customer_id