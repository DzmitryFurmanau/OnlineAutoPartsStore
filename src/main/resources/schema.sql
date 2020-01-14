DROP TABLE IF EXISTS public.addresses;
CREATE TABLE public.addresses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    phoneNumber INTEGER,
    street VARCHAR,
    city VARCHAR,
    state VARCHAR,
    country VARCHAR,
    pinCode INTEGER,
);

INSERT INTO public.addresses (id, phoneNumber, street, city, state, country, pinCode) VALUES (1, 298687764, 'Folush', 'Hrodna', 'Hrodna Region', 'Belarus', 230006);
INSERT INTO public.addresses (id, phoneNumber, street, city, state, country, pinCode) VALUES (2, 336549871, 'Strelkovaya', 'Hrodna', 'Hrodna Region', 'Belarus', 230009);


DROP TABLE IF EXISTS public.customers;
CREATE TABLE public.customers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
    password VARCHAR,
    email VARCHAR,
);

INSERT INTO public.customers (id, name, password, email) VALUES (1, 'Dzmitry', '1488', 'amator@gmail.com');
INSERT INTO public.customers (id, name, password, email) VALUES (2, 'Volha', 'Dance', 'love@gmail.com');


DROP TABLE IF EXISTS public.customers_addresses;
CREATE TABLE public.customers_addresses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
        customer_id BIGINT,
        address_id BIGINT,
            FOREIGN KEY (customer_id) REFERENCES public.customers (id),
            FOREIGN KEY (address_id) REFERENCES public.addresses (id),
);

INSERT INTO public.customers_addresses (id, customer_id, address_id) VALUES (1, 1, 1);
INSERT INTO public.customers_addresses (id, customer_id, address_id) VALUES (2, 1, 2);


DROP TABLE IF EXISTS public.providers;
CREATE TABLE public.providers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
);

INSERT INTO public.providers (id, name) VALUES (1, 'Yuriy');
INSERT INTO public.providers (id, name) VALUES (2, 'Vasiliy');


DROP TABLE IF EXISTS public.heavers;
CREATE TABLE public.heavers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
    age SMALLINT,
    salary INTEGER,
    bonus INTEGER,
);

INSERT INTO public.heavers (id, name, age, salary, bonus) VALUES (1, 'Anton', 25, 500, 100);
INSERT INTO public.heavers (id, name, age, salary, bonus) VALUES (2, 'Artyom', 30, 600, 200);


DROP TABLE IF EXISTS public.stocks;
CREATE TABLE public.stocks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    quantity INTEGER,
        provider_id BIGINT,
        heaver_id BIGINT,
            FOREIGN KEY (provider_id) REFERENCES public.providers (id),
            FOREIGN KEY (heaver_id) REFERENCES public.heavers (id),
);

INSERT INTO public.stocks (id, quantity, provider_id, heaver_id) VALUES (1, 1, 1, 1);
INSERT INTO public.stocks (id, quantity, provider_id, heaver_id) VALUES (2, 3, 1, 2);


DROP TABLE IF EXISTS public.cars;
CREATE TABLE public.cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR,
    year SMALLINT,
    pinCode VARCHAR,
);

INSERT INTO public.cars (id, model, year, pinCode) VALUES (1, 'ZAZ-965', 1969, 'KLP30061969');
INSERT INTO public.cars (id, model, year, pinCode) VALUES (2, 'VAZ-2107', 1990, 'ABC14881990');


DROP TABLE IF EXISTS public.details;
CREATE TABLE public.details (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
    type VARCHAR,
    price DOUBLE,
        car_id BIGINT,
            FOREIGN KEY (car_id) REFERENCES public.cars (id),
);

INSERT INTO public.details (id, name, type, price, car_id) VALUES (1, 'Engine', 'Chassis', 107.58, 1);
INSERT INTO public.details (id, name, type, price, car_id) VALUES (2, 'Wheel', 'Chassis', 25.14, 1);


DROP TABLE IF EXISTS public.details_stocks;
CREATE TABLE public.details_stocks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    stock_id BIGINT,
        detail_id BIGINT,
            FOREIGN KEY (stock_id) REFERENCES public.stocks (id),
            FOREIGN KEY (detail_id) REFERENCES public.details (id),
);

INSERT INTO public.details_stocks (id, stock_id, detail_id) VALUES (1, 1, 1);
INSERT INTO public.details_stocks (id, stock_id, detail_id) VALUES (2, 2, 1);


DROP TABLE IF EXISTS public.sellers;
CREATE TABLE public.sellers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
    age SMALLINT,
    salary INTEGER,
    category SMALLINT,
);

INSERT INTO public.sellers (id, name, age, salary, category) VALUES (1, 'Danuta', 20, 700, 2);
INSERT INTO public.sellers (id, name, age, salary, category) VALUES (2, 'Anna', 30, 800, 1);


DROP TABLE IF EXISTS public.orders;
CREATE TABLE public.orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date VARCHAR,
    sum INTEGER,
        seller_id BIGINT,
        detail_id BIGINT,
        stock_id BIGINT,
        customer_id BIGINT,
        address_id BIGINT,
            FOREIGN KEY (seller_id) REFERENCES public.sellers (id),
            FOREIGN KEY (detail_id) REFERENCES public.details (id),
            FOREIGN KEY (stock_id) REFERENCES public.stocks (id),
            FOREIGN KEY (customer_id) REFERENCES public.customers (id),
            FOREIGN KEY (address_id) REFERENCES public.addresses (id),
);

INSERT INTO public.orders (id, date, sum, seller_id, detail_id, stock_id, customer_id, address_id) VALUES (1, '2019-12-12', 1524, 1, 1, 1, 1, 1);
INSERT INTO public.orders (id, date, sum, seller_id, detail_id, stock_id, customer_id, address_id) VALUES (2, '2019-11-11', 123, 2, 2, 2, 2, 2);


DROP TABLE IF EXISTS public.roles;
CREATE TABLE public.roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
);

INSERT INTO public.roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO public.roles (id, name) VALUES (2, 'ROLE_ADMIN');


DROP TABLE IF EXISTS public.users;
CREATE TABLE public.users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
    password VARCHAR,
);

INSERT INTO public.users (id, name, password) VALUES (1, 'user.simple','$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K');
INSERT INTO public.users (id, name, password) VALUES (2, 'user.admin','$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K');


DROP TABLE IF EXISTS public.users_roles;
CREATE TABLE public.users_roles (
    user_id BIGINT,
    role_id BIGINT,
        FOREIGN KEY (user_id) REFERENCES public.users(id),
        FOREIGN KEY (role_id) REFERENCES public.roles(id),
);

INSERT INTO public.users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO public.users_roles (user_id, role_id) VALUES (2, 2);
