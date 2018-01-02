
/*CREATE SCHEMA*/
-- CREATE DATABASE training_vendetta_db WITH ENCODING='UTF8' OWNER=postgres;


/*CREATE TABLES*/
-- auto-generated definition
CREATE TABLE IF NOT EXISTS orders
(
  pk               BIGSERIAL NOT NULL
    CONSTRAINT orders_pkey
    PRIMARY KEY,
  birthday_date    TIMESTAMP,
  delivery_address VARCHAR(255),
  delivery_date    TIMESTAMP,
  first_name       VARCHAR(255),
  last_name        VARCHAR(255),
  order_status     VARCHAR(255),
  total_cost       DOUBLE PRECISION
);


-- auto-generated definition
CREATE TABLE IF NOT EXISTS products
(
  pk          BIGSERIAL NOT NULL
    CONSTRAINT computer_part_pkey
    PRIMARY KEY,
  cost        DOUBLE PRECISION,
  description VARCHAR(255),
  name        VARCHAR(255)
);



-- auto-generated definition
CREATE TABLE IF NOT EXISTS orders_products
(
  order_pk   BIGINT NOT NULL
    CONSTRAINT fka53oeh8rtg3102kgtghk9tda5
    REFERENCES orders,
  product_pk BIGINT NOT NULL
    CONSTRAINT fk3e414est1c4538o55r4heyx4i
    REFERENCES products
);


-- auto-generated definition
CREATE TABLE IF NOT EXISTS product_images
(
  pk           BIGSERIAL    NOT NULL
    CONSTRAINT product_images_pkey
    PRIMARY KEY,
  content_type VARCHAR(255) NOT NULL,
  created_date TIMESTAMP    NOT NULL,
  description  VARCHAR(255),
  lob          BYTEA          NOT NULL,
  name         VARCHAR(255) NOT NULL,
  product_id   BIGINT
    CONSTRAINT fkqnq71xsohugpqwf3c9gxmsuy
    REFERENCES products
);



