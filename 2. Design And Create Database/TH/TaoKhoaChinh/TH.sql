use thuchanh2;
create table users(
user_id int auto_increment primary key,
username varchar(40),
password varchar(255),
email varchar(255));

create table roles(
role_id int auto_increment,
role_name varchar(50),
primary key(role_id));

CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);
