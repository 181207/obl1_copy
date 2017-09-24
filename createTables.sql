CREATE SCHEMA IF NOT EXISTS webshop;

DROP TABLE IF EXISTS webshop.cart CASCADE;
DROP TABLE IF EXISTS webshop.item CASCADE;

CREATE TABLE webshop.cart (
  id            SERIAL PRIMARY KEY,
  description   VARCHAR(40)
);


CREATE TABLE webshop.item (
  id           SERIAL PRIMARY KEY,
  item_name    CHARACTER VARYING(40) NOT NULL,
  cart_id        INTEGER REFERENCES webshop.cart (id)
);