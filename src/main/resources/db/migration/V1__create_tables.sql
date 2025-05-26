CREATE TABLE car(
    id varchar(36) primary key,
    brand varchar(20) not null,
    model varchar(20) not null,
    color varchar(20) not null,
    year  integer not null,
    price float(10) not null,
    customer_id varchar(36) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

CREATE TABLE customer(
    id varchar(36) primary key,
    name varchar(40) not null,
    address varchar(60) not null,
    phone varchar(20) not null,
    seller_type varchar(20) not null,
    cars jsonb,
    created_at timestamp not null,
    updated_at timestamp not null
);

CREATE TABLE account(
    id varchar(36) primary key,
    username varchar(40) not null,
    email varchar(40) not null,
    password varchar(40) not null,
    customer_id varchar(36),
    created_at timestamp not null,
    updated_at timestamp not null

);

