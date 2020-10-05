# Stored-Procedure
Theory of Databases - DB2

## To run the JDBC code:
1. Compile the program: javac SalaryStdDev.java
2. Run the program:   
   - If the database requires a login id and password:-   
	java -cp "<path_to_jdbc_driver.jar>";"<path_to_compiled_class_file>" SalaryStdDev <database_name> <table_name> <user_id> <password>   
   - If the database does not require a login id and password:-   
	java -cp "<path_to_jdbc_driver.jar>";"<path_to_compiled_class_file>" SalaryStdDev <database_name> <table_name>   


## To run the Stored Procedure code:
1. Connect to the database: db2 connect to <database_name>
2. Run the program: db2 -td@ -f stddev.sql
