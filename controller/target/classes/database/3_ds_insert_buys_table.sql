INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 201, 104, '2023-11-22'::date, '10:36'::time, 78
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 201
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 202, 105, '2023-11-22'::date, '12:56'::time, 131
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 202
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 203, 104, '2023-11-22'::date, '16:41'::time, 99
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 203
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 204, 102, '2023-11-20'::date, '18:03'::time, 26
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 204
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 205, 101, '2023-11-21'::date, '19:53'::time, 165
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 205
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 206, 101, '2023-11-20'::date, '20:44'::time, 125
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 206
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 207, 105, '2023-11-20'::date, '22:06'::time, 217
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 207
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 208, 105, '2023-11-21'::date, '22:28'::time, 177
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 208
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 209, 104, '2023-11-22'::date, '23:11'::time, 86
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 209
);

INSERT INTO denodo_shop.buys (id, user_id, date_purchase, hour_purchase, total_amount)
SELECT 210, 105, '2023-11-23'::date, '23:20'::time, 164
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.buys
    WHERE id = 210
);
