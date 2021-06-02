create database stockV;
use stock;
CREATE TABLE category (
  id BIGINT NOT NULL,
  name VARCHAR(25)   NOT NULL,
   constraint pkCategory PRIMARY KEY (id)
  );  
  CREATE TABLE product (
  id BIGINT NOT NULL,
  create_date DATETIME not null,
  description LONGTEXT NULL DEFAULT NULL,
  name VARCHAR(25) NOT NULL,
  price DOUBLE NOT NULL check (price >=0),
  quantity_stock INT NOT NULL check(quantity_stock >=0),
  update_date DATETIME NULL DEFAULT NULL,
  category_id BIGINT NOT NULL,
  PRIMARY KEY (`id`), 
  CONSTRAINT fkProductCategory FOREIGN KEY (`category_id`) REFERENCES category (id) on  delete cascade on update cascade
    );
    
    
    
    CREATE TABLE  supplier (
  id BIGINT NOT NULL,
  address VARCHAR(50) NULL DEFAULT NULL,
  create_date DATETIME NULL DEFAULT NULL,
  email VARCHAR(50) NULL DEFAULT NULL,
  firstname VARCHAR(25) not null,
  lastname VARCHAR(25) not null,
  phone VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (id) );
  
  CREATE TABLE  customer (
  id BIGINT NOT NULL,
  address VARCHAR(50) NULL DEFAULT NULL,
  city VARCHAR(50) NULL DEFAULT NULL,
  create_date DATE NULL DEFAULT NULL,
  email VARCHAR(50) NULL DEFAULT NULL,
  firstname VARCHAR(25) not null,
  lastname VARCHAR(25) not null,
  phone VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE ordere (
  id BIGINT NOT NULL,
  order_date DATETIME not NULL ,
  total DOUBLE NOT NULL check(total >=0),
  totalht DOUBLE NOT NULL check(totalht >=0),
  customer_id BIGINT not null,
  PRIMARY KEY (id),
  CONSTRAINT fkOrdereCustomer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id) on  delete cascade on update cascade);
    CREATE TABLE order_product (
  id BIGINT NOT NULL,
  prix_ht DOUBLE NOT NULL check(prix_ht >=0),
  quantity INT NOT NULL check(quantity >=0),
  totalht DOUBLE NOT NULL check(totalht >=0),
  totalttc DOUBLE NOT NULL check(totalttc >=0),
  tva DOUBLE NOT NULL check(tva >=0),
  ordere_id BIGINT not null,
  product_id BIGINT not null,
  PRIMARY KEY (id),
  CONSTRAINT fkorder_productProduct FOREIGN KEY (product_id) REFERENCES product (id) on  delete cascade on update cascade,
  CONSTRAINT fkorder_productOrdere FOREIGN KEY (ordere_id) REFERENCES ordere (id) on  delete cascade on update cascade);
 

    
    CREATE TABLE supplier_product (
  id BIGINT NOT NULL,
  operation_date DATETIME NULL DEFAULT NULL,
  price DOUBLE NOT NULL check(price >=0),
  quantity INT NOT NULL check(quantity >=0),
  product_id BIGINT NULL DEFAULT NULL,
  supplier_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fksupplier_productsupplier
    FOREIGN KEY (supplier_id)
    REFERENCES supplier (id) on  delete cascade on update cascade,
  CONSTRAINT fksupplier_productproduct
    FOREIGN KEY (product_id)
    REFERENCES product (id) on  delete cascade on update cascade);
    
    CREATE TABLE IF NOT EXISTS employee (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(25) not null,
  `password` VARCHAR(1000) not null,
  `role` VARCHAR(255) not null,
  PRIMARY KEY (`id`));
    select * from supplier_product
 delimiter // 
create  TRIGGER addProductBySupplier  AFTER  INSERT 
ON supplier_product FOR EACH ROW
begin
update product p   set  p.quantity_stock = p.quantity_stock + new.quantity,p.price  = new.price where p.id = new.product_id;
end //
 delimiter 
 alter table order_product add column create_date DATETIME  default CURRENT_TIMESTAMP;
 select * from product
  select * from customer


--chart 2
SELECT CONVERT("2017-08-29", DATE);

 select sum( total) Total,CONVERT(day(order_date), NCHAR ) as dd from ordere 
 where week(order_date) =  week( DATE_ADD(CURRENT_TIMESTAMP, INTERVAL -1 week)) group by day(order_date) order by day(order_date);
 --chart 1
  select   p.name ,count(*) as nombreProduct   from order_product op inner join product p on p.id = op.product_id
  inner join ordere o on op.ordere_id = o.id
 where week(order_date) =  week(DATE_ADD(CURRENT_TIMESTAMP, INTERVAL -1 week)) group by p.name LIMIT 0,9;
   

 
 --insert customer
   insert into customer values (1,'d','d','2020-12-12','','mohamed', 'aghzaou', '0123456789')
insert into customer values (2,'d','d','2020-12-12','','mohamed', 'aghzaou', '0123456789')
  insert into customer values (3,'d','d','2020-12-12','','mohamed', 'aghzaou', '0123456789')
  insert into customer values (4,'d','d','2020-12-12','','mohamed', 'aghzaou', '0123456789')
  insert into customer values (6,'d','d','2020-12-12','','mohamed', 'aghzaou', '0123456789')
  --insert order
  select * from ordere
  insert into ordere values (1,'2021-05-28',1000, 1000 ,1);
        insert into ordere values (2,'2021-05-28',1000, 1000 ,1);
    insert into ordere values (3,'2021-05-29',1000, 1000 ,1);
    insert into ordere values (4,'2021-05-30',1000, 1000 ,1);   
    insert into ordere values (5,'2021-05-27',1000, 1000 ,1);
        insert into ordere values (9,'2021-05-26',1000, 1000 ,1);
    insert into ordere values (7,'2021-05-27',1000, 1000 ,1);
        insert into ordere values (8,'2021-05-27',1000, 1000 ,1);
                insert into ordere values (12,'2021-05-24',1000, 1000 ,1);

    --insert ordere_Product
       insert into order_product values (1,10,10,100,100,1000, 1,4, '2021-5-28');
        insert into order_product values (2,10,10,100,100,1000, 1,4, '2021-5-28');
    insert into order_product values (3,10,10,100,100,1000, 1,4, '2021-5-29');
    insert into order_product values (6,10,10,100,100,1000, 1,4, '2021-5-30');
        insert into order_product values (7,10,10,100,100,1000, 1,7, '2021-5-30');

 
 
 