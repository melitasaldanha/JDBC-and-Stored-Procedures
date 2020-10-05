-- Define procedure to find standard deviation of salary in employee table
CREATE OR REPLACE PROCEDURE stddev(OUT std_dev DECIMAL(9,2))
LANGUAGE SQL
BEGIN
	-- Declare variables
	DECLARE length INTEGER;
	DECLARE sum DOUBLE;
	DECLARE sum_of_sq DOUBLE;

	-- Initialize value of variables
	SET length = 0;
	SET sum = 0.0;
	SET sum_of_sq = 0.0;
	SET std_dev = 0.0;

	-- Traverse through salary of employee table
	FOR v1 as c1 CURSOR FOR
		SELECT SALARY FROM EMPLOYEE
	DO 
		SET length = length + 1;
		SET sum = sum + SALARY;
		SET sum_of_sq = sum_of_sq + POWER(SALARY,2);
	END FOR;

	-- Find standard deviation
	SET std_dev = SQRT((sum_of_sq/length) - POWER(sum/length,2));
	
END@

-- Call prodecure
CALL stddev(?)@