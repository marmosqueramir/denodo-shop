CREATE TABLE IF NOT EXISTS denodo_shop.prices (
    id bigserial NOT NULL,
    item_price int8 NULL,
    CONSTRAINT prices_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS denodo_shop.users (
   id bigserial NOT NULL,
   age int4 NULL,
   CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE denodo_shop.purchases (
   id bigserial NOT NULL,
   date_purchase timestamp(6) NULL,
   total_amount int8 NULL,
   user_id int8 NULL,
   CONSTRAINT purchases_pkey PRIMARY KEY (id),
   CONSTRAINT fk_purchases_users FOREIGN KEY (user_id) REFERENCES denodo_shop.users(id)
);