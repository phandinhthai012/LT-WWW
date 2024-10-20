create Database shopping
USE shopping

CREATE TABLE Product(
	id int NOT NULL IDENTITY(1,1),
	name NVARCHAR(50),
	price float,
	image NVARCHAR(50)
	
)
select * from Product
SELECT * FROM Product WHERE id = 1