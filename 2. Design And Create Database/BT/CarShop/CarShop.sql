use carshop;

create table customers (
customerNumber int primary key auto_increment,
customerName varchar(50) not null, 
contactLastName varchar(50) not null, 
contactFirstName varchar(50) not null, 
phone varchar(50) not null, 
addressLine1 varchar(50) not null, 
addressLine2 varchar(50),
city varchar(50) not null, 
state varchar(50) not null, 
postalCode varchar(15) not null, 
country varchar(50) not null,
creditLimit double);

create table orders (
orderNumber int primary key auto_increment,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
`status` varchar(15) not null, 
comments text,
quantityOrdered int not null, 
priceEach double not null, 
customerNumber int,
foreign key(customerNumber) references customers(customerNumber));

create table payments (
customerNumber int, 
foreign key(customerNumber) references customers(customerNumber),
checkNumber varchar(50) not null, 
paymentDate date not null, 
amount double not null
);

create table products (
productCode varchar(15) not null primary key unique,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text not null, 
quantityInStock int not null, 
buyPrice double not null, 
MSRP double not null
);

create table orderDetails(
	productCode varchar(15) not null,
    orderNumber int not null,
    constraint fk_productCode_orderDetail foreign key(productCode) references products(productCode),
    constraint fk_orderNumber_orderDetail foreign key(orderNumber) references orders(orderNumber)
);

create table  productlines (
productLine varchar(50) not null primary key unique,
textDescription text,
image varchar(250)); 

alter table products 
add column productLine varchar(50) not null,
add foreign key(productLine) references productlines(productLine);

create table employees (
employeeNumber int primary key auto_increment,
lastName varchar(50) not null, 
firstName varchar(50) not null, 
email varchar(100) not null,
jobTitle varchar(50) not null );

alter table customers 
add column salesRepEmployeeNumber int not null,
add foreign key(salesRepEmployeeNumber) references employees(employeeNumber);

create table offices (
officeCode varchar(10) not null primary key unique,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
state varchar(50),
country varchar(50) not null,
postalCode varchar(15) not null );

alter table employees
add column reportTo int not null,
add foreign key(reportTo) references employees(employeeNumber);

alter table employees
add column officeCode varchar(10) not null,
add foreign key(officeCode) references offices(officeCode);