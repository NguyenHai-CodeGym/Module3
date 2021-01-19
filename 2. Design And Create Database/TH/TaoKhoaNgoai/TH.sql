use taokhoangoai;
create table customers(
id int auto_increment primary key,
name varchar(40),
address varchar(255),
email varchar(255));

CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   PRIMARY KEY(id),
   customer_id INT,
   FOREIGN KEY (customer_id) REFERENCES customers(id)
);


