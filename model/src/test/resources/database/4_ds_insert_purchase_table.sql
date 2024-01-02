INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 201, 104, '2023-11-22 10:36:00'::timestamp, 78
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 201
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 202, 105, '2023-11-22 12:56:00'::timestamp, 131
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 202
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 203, 104, '2023-11-22 16:41:00'::timestamp, 99
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 203
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 204, 102, '2023-11-20 18:03:00'::timestamp, 26
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 204
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 205, 101, '2023-11-21 19:53:00'::timestamp, 165
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 205
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 206, 101, '2023-11-20 20:44:00'::timestamp, 125
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 206
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 207, 105, '2023-11-20 22:06:00'::timestamp, 217
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 207
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 208, 105, '2023-11-21 22:28:00'::timestamp, 177
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 208
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 209, 104, '2023-11-22 23:11:00'::timestamp, 86
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 209
);

INSERT INTO denodo_shop.purchases (id, user_id, date_purchase, total_amount)
SELECT 210, 105, '2023-11-23 23:20:00'::timestamp, 164
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.purchases
    WHERE id = 210
);
