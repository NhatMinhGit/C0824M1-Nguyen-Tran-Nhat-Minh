-- ex01 : Tham số loại in
DELIMITER //

CREATE PROCEDURE getCusById

(IN cusNum INT(11)) -- khai bao bien

BEGIN

  SELECT * FROM customers WHERE customerNumber = cusNum;

END //

DELIMITER ;

call getCusById(175);

-- ex 02 : Tham số loại out
DELIMITER //

CREATE PROCEDURE GetCustomersCountByCity(

    IN  in_city VARCHAR(50),

    OUT total INT

)

BEGIN

    SELECT COUNT(customerNumber)

    INTO total -- covert customerNumber into total 

    FROM customers

    WHERE city = in_city;

END//

DELIMITER ;

CALL GetCustomersCountByCity('Lyon',@total);

SELECT @total;

-- ex03 : Tham số loại inout
DELIMITER //

CREATE PROCEDURE SetCounter(

    INOUT counter INT,

    IN inc INT

)

BEGIN

    SET counter = counter + inc;

END//

DELIMITER ;

SET @counter = 1;

CALL SetCounter(@counter,1); -- 2

CALL SetCounter(@counter,1); -- 3

CALL SetCounter(@counter,5); -- 8

SELECT @counter; -- 8
