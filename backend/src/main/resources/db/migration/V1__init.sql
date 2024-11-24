CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(1000),
    price FLOAT,
    description TEXT,
    image VARCHAR(1000)
);