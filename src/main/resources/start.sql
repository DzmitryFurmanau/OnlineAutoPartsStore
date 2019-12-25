create table if not exists address (
id bigint primary key auto_increment,
phoneNumber integer,
street varchar,
city varchar,
state varchar,
country varchar,
pinCode integer
);

insert into address (phoneNumber, street, city, state, country, pinCode)
values (298687764, 'Folush', 'Hrodna', 'Hrodna Region', 'Belarus', 230006);

create table if not exists customer (
id bigint primary key auto_increment,
name varchar,
password varchar,
email varchar,
address_id bigint,
foreign key (address_id) references address (id)
);

insert into customer (name, password, email, address_id)
values ('Dzmitry Furmanau', '288', 'amator@gmail.com', 1);

create table if not exists customers_addresses (
id bigint primary key auto_increment,
address_id bigint,
customer_id bigint,
foreign key (address_id) references address (id),
foreign key (customer_id) references customer (id)
);

insert into customers_addresses (address_id, customer_id) values (1, 1);
