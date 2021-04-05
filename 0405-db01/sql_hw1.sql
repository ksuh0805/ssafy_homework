DROP TABLE IF EXISTS product;

CREATE TABLE product(
	code int AUTO_INCREMENT PRIMARY KEY,
	name varchar(20) NOT null,
	price int CHECK (price > 0)
);

INSERT INTO product (name, price)
VALUES ('samsung_tv', 1000000),
		('lg_tv', 2000000),
		('apple_laptop', 2500000),
		('samsung_laptop', 2000000),
		('asus_laptop', 1500000);
		
SELECT * FROM product ;

SELECT price * 0.85 AS '15% 세일된 가격'
FROM product ;

UPDATE product
SET price = price * 0.8
WHERE name like '%tv%';

SELECT SUM(price) AS '총 금액'
FROM product ;