use library;
create table Students (
student_id int primary key auto_increment,
student_name varchar(50) not null, 
address varchar(500) not null,
email varchar(50) not null,
image varchar(500));

create table books(
book_Id int primary key auto_increment,
book_Name varchar(50) not null, 
book_Price double not null, 
book_Author varchar(50) not null, 
book_DatePublication date not null, 
book_republish int not null);

create table categorys(
cate_id int primary key auto_increment,
cate_name varchar(50) not null);

alter table books 
add column cate_id int not null,
add foreign key(cate_id) references categorys(cate_id);

alter table books
add column cate_PubCom varchar(50) not null, 
add column image varchar(50);

create table BorrowOrders(
student_name varchar(50) not null primary key unique,
dateBorrowed date not null,