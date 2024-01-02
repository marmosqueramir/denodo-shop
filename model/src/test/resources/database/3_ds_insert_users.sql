INSERT INTO denodo_shop.users (id, age)
SELECT 101, 18
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.users
    WHERE id = 101
);

INSERT INTO denodo_shop.users (id, age)
SELECT 102, 32
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.users
    WHERE id = 102
);

INSERT INTO denodo_shop.users (id, age)
SELECT 103, 44
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.users
    WHERE id = 103
);

INSERT INTO denodo_shop.users (id, age)
SELECT 104, 38
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.users
    WHERE id = 104
);

INSERT INTO denodo_shop.users (id, age)
SELECT 105, 42
WHERE NOT EXISTS (
    SELECT 1
    FROM denodo_shop.users
    WHERE id = 105
);