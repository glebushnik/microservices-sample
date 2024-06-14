CREATE TABLE IF NOT EXISTS category
(
    id bigint not null primary key,
    description varchar(255),
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS product
(
    id bigint not null primary key,
    description varchar(255),
    name varchar(255),
    availible_quantity double precision not null,
    price numeric(38, 2),
    category_id bigint
        constraint fk1categoryproductref references category
);

CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS product_seq INCREMENT BY 50;