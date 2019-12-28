create table if not exists address (
id bigint primary key auto_increment,
phoneNumber integer,
street varchar,
city varchar,
state varchar,
country varchar,
pincode integer
);

insert into address (phoneNumber, street, city, state, country, pincode) values (298687764, 'Folush', 'Hrodna', 'Hrodna Region', 'Belarus', 230006);
insert into address (phoneNumber, street, city, state, country, pincode) values (336549871, 'Strelkovaya', 'Hrodna', 'Hrodna Region', 'Belarus', 230009);

create table if not exists customer (
id bigint primary key auto_increment,
name varchar,
password varchar,
email varchar
);

insert into customer (name, password, email) values ('Dzmitry', '1488', 'amator@gmail.com');
insert into customer (name, password, email) values ('Olga', 'Dance', 'love@gmail.com');

create table if not exists customers_addresses (
id bigint primary key auto_increment,
address_id bigint,
customer_id bigint,
foreign key (address_id) references address (id),
foreign key (customer_id) references customer (id)
);

insert into customers_addresses (address_id, customer_id) values (1, 1);
insert into customers_addresses (address_id, customer_id) values (2, 1);

create table if not exists provider (
id bigint primary key auto_increment,
name varchar
);

insert into provider (name) values ('Yuriy');
insert into provider (name) values ('Vasiliy');

create table if not exists heaver (
id bigint primary key auto_increment,
name varchar,
age smallint,
salary integer,
bonus integer
);

insert into heaver (name, age, salary, bonus) values ('Anton', 25, 500, 100);
insert into heaver (name, age, salary, bonus) values ('Artyom', 30, 600, 200);

create table if not exists stock (
id bigint primary key auto_increment,
quantity integer,
provider_id bigint,
heaver_id bigint,
foreign key (provider_id) references provider (id),
foreign key (heaver_id) references heaver (id)
);

insert into stock (quantity, provider_id, heaver_id) values (1, 1, 1);
insert into stock (quantity, provider_id, heaver_id) values (3, 1, 2);

create table if not exists car (
id bigint primary key auto_increment,
model varchar,
year smallint,
pincode varchar
);

insert into car (model, year, pincode) values ('ZAZ-965', 1969, 'KLP30061969');
insert into car (model, year, pincode) values ('VAZ-2107', 1990, 'ABC14881990');

create table if not exists detail (
id bigint primary key auto_increment,
name varchar,
type varchar,
price double,
car_id bigint,
foreign key (car_id) references car (id)
);

insert into detail (name, type, price, car_id) values ('Engine', 'Chassis', 107.58, 1);
insert into detail (name, type, price, car_id) values ('Wheel', 'Chassis', 25.14, 1);