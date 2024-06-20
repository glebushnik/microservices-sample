CREATE TYPE payment_method AS ENUM
    (
        'PAYPAL',
        'CREDIT_CARD',
        'VISA',
        'MASTER_CARD',
        'MIR',
        'BITCOIN'
        );


CREATE TABLE IF NOT EXISTS "payment"
(
    id BIGINT NOT NULL primary key,
    amount NUMERIC(38,2),
    payment_method payment_method,
    order_id BIGINT,
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_date TIMESTAMP WITH TIME ZONE
);

CREATE SEQUENCE IF NOT EXISTS payment_seq
    START WITH 1
    INCREMENT BY 1;