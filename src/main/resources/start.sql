create table if not exists public.address (
id bigint primary key auto_increment,
phoneNumber integer,
street varchar,
city varchar,
state varchar,
country varchar,
pincode integer
);

insert into public.address (phoneNumber, street, city, state, country, pincode) values (298687764, 'Folush', 'Hrodna', 'Hrodna Region', 'Belarus', 230006);
insert into public.address (phoneNumber, street, city, state, country, pincode) values (336549871, 'Strelkovaya', 'Hrodna', 'Hrodna Region', 'Belarus', 230009);

create table if not exists public.customer (
id bigint primary key auto_increment,
name varchar,
password varchar,
email varchar
);

insert into public.customer (name, password, email) values ('Dzmitry', '1488', 'amator@gmail.com');
insert into public.customer (name, password, email) values ('Olga', 'Dance', 'love@gmail.com');

create table if not exists public.customers_addresses (
id bigint primary key auto_increment,
address_id bigint,
customer_id bigint,
foreign key (address_id) references public.address (id),
foreign key (customer_id) references public.customer (id)
);

insert into public.customers_addresses (address_id, customer_id) values (1, 1);
insert into public.customers_addresses (address_id, customer_id) values (2, 1);

create table if not exists public.provider (
id bigint primary key auto_increment,
name varchar
);

insert into public.provider (name) values ('Yuriy');
insert into public.provider (name) values ('Vasiliy');

create table if not exists public.heaver (
id bigint primary key auto_increment,
name varchar,
age smallint,
salary integer,
bonus integer
);

insert into public.heaver (name, age, salary, bonus) values ('Anton', 25, 500, 100);
insert into public.heaver (name, age, salary, bonus) values ('Artyom', 30, 600, 200);

create table if not exists public.stock (
id bigint primary key auto_increment,
quantity integer,
provider_id bigint,
heaver_id bigint,
foreign key (provider_id) references public.provider (id),
foreign key (heaver_id) references public.heaver (id)
);

insert into public.stock (quantity, provider_id, heaver_id) values (1, 1, 1);
insert into public.stock (quantity, provider_id, heaver_id) values (3, 1, 2);

create table if not exists public.car (
id bigint primary key auto_increment,
model varchar,
year smallint,
pincode varchar
);

insert into public.car (model, year, pincode) values ('ZAZ-965', 1969, 'KLP30061969');
insert into public.car (model, year, pincode) values ('VAZ-2107', 1990, 'ABC14881990');

create table if not exists public.detail (
id bigint primary key auto_increment,
name varchar,
type varchar,
price double,
car_id bigint,
foreign key (car_id) references car (id)
);

insert into public.detail (name, type, price, car_id) values ('Engine', 'Chassis', 107.58, 1);
insert into public.detail (name, type, price, car_id) values ('Wheel', 'Chassis', 25.14, 1);

create table if not exists public.details_stocks (
id bigint primary key auto_increment,
stock_id bigint,
detail_id bigint,
foreign key (stock_id) references public.stock (id),
foreign key (detail_id) references public.detail (id)
);

insert into public.details_stocks (stock_id, detail_id) values (1, 1);
insert into public.details_stocks (stock_id, detail_id) values (2, 1);

create table if not exists public.seller (
id bigint primary key auto_increment,
name varchar,
age smallint,
salary integer,
category smallint
);

insert into public.seller (name, age, salary, category) values ('Danuta', 20, 700, 2);
insert into public.seller (name, age, salary, category) values ('Anna', 30, 800, 1);