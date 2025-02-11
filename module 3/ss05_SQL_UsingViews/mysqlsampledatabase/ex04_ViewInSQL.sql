CREATE VIEW customer_views AS

SELECT customerNumber, customerName, phone

FROM  customers;

select * from customer_views;

-- Ví dụ
CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers

WHERE city = 'Nantes';

-- xóa cột
DROP VIEW view_name;
-- xóa bảng view
DROP VIEW customer_views;