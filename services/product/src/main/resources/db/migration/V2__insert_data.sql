INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Electronics and gadgets', 'Electronics'),
    (nextval('category_seq'), 'Clothing and accessories', 'Apparel'),
    (nextval('category_seq'), 'Home and kitchen appliances', 'Home & Kitchen'),
    (nextval('category_seq'), 'Books of various genres', 'Books'),
    (nextval('category_seq'), 'Sports and outdoor equipment', 'Sports & Outdoors');

INSERT INTO product (id, description, name, availible_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Latest model smartphone with 128GB storage', 'Smartphone', 50, 699.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Wireless noise-cancelling headphones', 'Headphones', 30, 199.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Mens casual leather jacket', 'Leather Jacket', 20, 89.99, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 'Womens running shoes', 'Running Shoes', 100, 59.99, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 'Stainless steel blender with multiple settings', 'Blender', 40, 49.99, (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'Set of non-stick cookware', 'Cookware Set', 25, 79.99, (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'Bestselling mystery novel', 'Mystery Novel', 200, 14.99, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'Comprehensive guide to programming', 'Programming Guide', 150, 29.99, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'High-performance mountain bike', 'Mountain Bike', 10, 499.99, (SELECT id FROM category WHERE name = 'Sports & Outdoors')),
    (nextval('product_seq'), 'Yoga mat with extra cushioning', 'Yoga Mat', 80, 24.99, (SELECT id FROM category WHERE name = 'Sports & Outdoors'));
