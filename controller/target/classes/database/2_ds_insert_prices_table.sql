INSERT INTO denodo_shop.prices (id, item_price)
SELECT 1, 52
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.prices
    WHERE id = 1
);

INSERT INTO denodo_shop.prices (id, item_price)
SELECT 2, 26
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.prices
    WHERE id = 2
);

INSERT INTO denodo_shop.prices (id, item_price)
SELECT 3, 99
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.prices
    WHERE id = 3
);

INSERT INTO denodo_shop.prices (id, item_price)
SELECT 4, 86
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.prices
    WHERE id = 4
);

INSERT INTO denodo_shop.prices (id, item_price)
SELECT 5, 79
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.prices
    WHERE id = 5
);