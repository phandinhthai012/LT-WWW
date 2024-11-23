-- Insert sample categories
INSERT INTO CATEGORY (Name) VALUES ('Electronics');
INSERT INTO CATEGORY (Name) VALUES ('Books');
INSERT INTO CATEGORY (Name) VALUES ('Clothing');

-- Insert sample products
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P001', 'Laptop', 'High performance laptop', '2023-01-01', 1200.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P002', 'Smartphone', 'Latest model smartphone', '2023-02-01', 800.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P003', 'Tablet', '10-inch screen tablet', '2023-03-01', 300.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P004', 'Headphones', 'Noise-cancelling headphones', '2023-04-01', 150.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P005', 'E-Reader', 'E-ink display e-reader', '2023-05-01', 100.00, 2);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P006', 'Novel', 'Bestselling novel', '2023-06-01', 20.00, 2);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P007', 'Textbook', 'Educational textbook', '2023-07-01', 50.00, 2);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P008', 'T-Shirt', 'Cotton t-shirt', '2023-08-01', 15.00, 3);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P009', 'Jeans', 'Denim jeans', '2023-09-01', 40.00, 3);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P010', 'Jacket', 'Winter jacket', '2023-10-01', 100.00, 3);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P011', 'Sneakers', 'Running sneakers', '2023-11-01', 60.00, 3);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P012', 'Watch', 'Smartwatch', '2023-12-01', 200.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P013', 'Camera', 'Digital camera', '2024-01-01', 500.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P014', 'Printer', 'Wireless printer', '2024-02-01', 150.00, 1);
INSERT INTO PRODUCT (Code, Name, Description, Register_Date, Price, CART_ID) VALUES ('P015', 'Monitor', '4K monitor', '2024-03-01', 300.00, 1);

select * from product