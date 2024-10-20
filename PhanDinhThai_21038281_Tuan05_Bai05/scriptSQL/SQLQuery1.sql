create Database BookCart
USE BookCart

CREATE TABLE BOOK(
	id int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(256),
	author NVARCHAR(256),
	price float,
	quantity int,
	description NVARCHAR(256),
	image NVARCHAR(50)
)

CREATE TABLE RECEIPT(
	id int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(256),
	address NVARCHAR(256),
	total float,
	payment NVARCHAR(50),
	listIDBook NVARCHAR(100)
)

select * from BOOK where name like '%s%'
select * from RECEIPT