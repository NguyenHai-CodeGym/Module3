use btkhoachinhvakhoangoai;
create table customers (
customers_number int(11) not null auto_increment primary key,
fullname varchar(255) not null,
address varchar(255),
email varchar(100) unique,
sdt int(11) unique
);

create table accounts(
accounts_number int(11) primary key auto_increment,
accounts_type varchar(100),
accounts_date datetime,
blance int(11));

create table transactions (
tran_number int(11) primary key auto_increment,
tran_date datetime ,
amounts int(11),
descriptions varchar(250),
accounts_number int(11) not null,
foreign key(accounts_number) references accounts(accounts_number));

alter table accounts
add column customers_number int(11) not null,
add foreign key(customers_number) references customers(customers_number);