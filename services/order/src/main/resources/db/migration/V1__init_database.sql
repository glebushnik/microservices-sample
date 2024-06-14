CREATE TYPE payment_method AS ENUM
    (
        'PAYPAL',
        'CREDIT_CARD',
        'VISA',
        'MASTER_CARD',
        'MIR',
        'BITCOIN'
        );

CREATE TABLE IF NOT EXISTS "order"
(
    id BIGINT NOT NULL PRIMARY KEY,
    reference VARCHAR(255),
    total_amount NUMERIC(38, 2),
    payment_method payment_method,
    customer_id VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_date TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS order_line
(
    id BIGINT NOT NULL PRIMARY KEY,
    product_id BIGINT,
    quantity DOUBLE PRECISION,
    order_id BIGINT NOT NULL,
    CONSTRAINT fk1orderorderline FOREIGN KEY (order_id) REFERENCES "order" (id)
);

CREATE SEQUENCE IF NOT EXISTS order_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS order_line_seq
    START WITH 1
    INCREMENT BY 1;
