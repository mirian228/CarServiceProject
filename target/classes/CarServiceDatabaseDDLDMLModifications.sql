USE mydb;
-- Statements for insertion: --
SELECT * FROM Customer;
SELECT * FROM Employees;
SELECT * FROM Manager;
SELECT * FROM CarServiceA;
SELECT * FROM CarServiceB;

INSERT INTO Customer VALUES(1, "Mirian", "Surmanidze", "577480406", "Bagrationi Street", "10%" );
INSERT INTO Customer VALUES(2, "Giorgi", "Giorgadze", "555400400", "Gorgasali Street", "5%");

INSERT INTO Car VALUES(1, 1, "WBAAA1305H8251545", "BMW", "X5", "SUV", 2009, "2993cc", "Diesel", "SpaceGray");
INSERT INTO Car VALUES(2, 2, "WBDBA2505H8342325", "Mercedes", "CLA", "Sedan", 2015, "1992cc", "Gasoline", "SunYellow");
INSERT INTO CarServiceA VALUES(1 , 1, "EngineOilReplacement");
INSERT INTO CarServiceB VALUES(2, 2, "GearBoxReplacement");

INSERT INTO Manager VALUES(1, "George", "Smith", "+32131", "Bond Road", 125.000);
INSERT INTO Manager VALUES(2, "Martin", "White", "+12323", "Beasley Lane" , 90.000);
INSERT INTO Manager VALUES(3, "Benjamin", "White", "+32131", "Buford Street", 110.000);


INSERT INTO Employees VALUES(1, "George", "Macalister", "Washington", "+1534341", "Montgomery Street", 60000 , 1);
INSERT INTO Employees VALUES(2, "Olivia", "Williams", "Phoenix", "+2312513 ", "Bowden Street", 49000 , 2);
INSERT INTO Employees VALUES(3, "Lucas", "King", "Austin", "+129703 ", "Glen Street", 52000 , 1);
INSERT INTO Employees VALUES(4, "Benjamin", "White", "San Diego", "+167093 ", "Clayton Street", 47000 , 2);
INSERT INTO Employees VALUES(5, "Henry", "Lopez", "Jacksonville", "+122334 ", "Dolton Street", 37000 , 1);
INSERT INTO Employees VALUES(6, "James", "Williams", "Chicago", "+123123 ", "Buford Street", 65000 , 1);
INSERT INTO Employees VALUES(7, "Amelia", "Clark", "Seattle", "+13232", "Jennings Street", 80000, 2);
INSERT INTO Employees VALUES(8, "Lucas", "White", "Washington", "+13232", "Dolton", 20000, 1);
INSERT INTO Employees VALUES(9, "Amelia", "Sanders", "Chicago", "+13232", "Bellwood Street", 31500, 3);
INSERT INTO Employees VALUES(10, "Benjamin", "Williams", "Phoenix", "+13232", "Golf Street", 15000, 2);
INSERT INTO Employees VALUES(11, "Charlotte", "Myers", "Boston", "+13232", "Flossmoor Street", 44000, 3);



INSERT INTO EngineMechanic VALUES(1, 1, 1 );
INSERT INTO DiagnosticsMechanic VALUES(1, 1, 3);
INSERT INTO AutomotiveElectrician VALUES(1, 2, 4);
INSERT INTO SuspensionMechanic VALUES(1, 2, 5);
INSERT INTO GearboxMechanic VALUES(1, 2, 6);
INSERT INTO Сashier VALUES(1, 2);
INSERT INTO Сashier VALUES(2, 7);

INSERT INTO PartWarehouse VALUES(1, 1, "ZF8HP", "XBC23054", 1 , "Zeppelin-Stiftung", 2009);
INSERT INTO PartWarehouse VALUES(1, 2, "Oil-Filter", "3412PDY", 55 , "Mahle", 2023);
INSERT INTO PartWarehouse VALUES(1, 3, "Oil-Pan", "ZCX2357", 7 , "Bayerische-Motoren-Werke", 2015);

INSERT INTO Orders VALUES(1, 1, "Engine-Oil", 140, "2023-1-10");
INSERT INTO Orders VALUES(2, 2, "Gearbox", 5000, "2023-1-5");

INSERT INTO EnginePartsStore VALUES(1, 1, 1, 1, 1);
INSERT INTO AutomotivePartsStore VALUES(1, 2, 2, 1, 2);
COMMIT;

-- UPDATE Statements -- 

UPDATE Employees SET fname = "Nelson" WHERE fname = "Bryan";
UPDATE Employees SET fname = "Isabella", lname = "Baker" WHERE idEmployees = 2;
UPDATE Employees SET Salary = 45000 WHERE idEmployees = 1;
UPDATE Employees SET Adress = "Jennings" WHERE idEmployees = 7;
UPDATE Employees SET City = "Denver" WHERE City = "Chicago";
UPDATE Orders SET orderAmount = 200 WHERE idOrders = 1;
UPDATE Manager SET fname = "Rivera" WHERE fname = "George";
UPDATE Employees SET fname = "Bryan" Where idEmployees = 1;
UPDATE Car SET productionYear = 2010 WHERE idCar = 1;
UPDATE Car SET model = "S-Class" WHERE model = "CLA";
UPDATE Customer SET discount = "15%" WHERE idCustomer = 1;

-- DELETE Statements -- 
SELECT * FROM Car;
SELECT * FROM Customer;
DELETE FROM Employees WHERE idEmployees = 1;
DELETE FROM Car WHERE make = "BMW";
DELETE FROM Customer WHERE idCustomer < 2;
DELETE FROM Orders WHERE OrderAmount BETWEEN 2500 AND 7500;
DELETE FROM Employees WHERE Salary BETWEEN 55000 AND 65000;
DELETE FROM PartWareHouse WHERE releaseYear < 2010;
DELETE FROM Employees WHERE City = "Jacksonville";
DELETE FROM AutomotiveElectrician WHERE Employeeid = 4;
DELETE FROM EngineMechanic WHERE Employeeid = 1;
DELETE FROM Customer WHERE discount = "5%";


-- ALTER tables --
ALTER TABLE Customer ADD(Age INT);
ALTER TABLE Customer DROP COLUMN AGE;
DESCRIBE Customer;
ALTER TABLE Orders DROP COLUMN OrderDate;
ALTER TABLE Orders ADD(OrderDate DATE);
ALTER TABLE Employees ADD(Age INT);
ALTER TABLE Employees DROP COLUMN Age;
ALTER TABLE Manager ADD(City VARCHAR(15));
ALTER TABLE Manager DROP COLUMN City;

-- 1 big statement to join all tables in database --


-- statements with left, right, inner, outer joins -- 
SELECT * FROM Employees INNER JOIN Manager
ON Employees.idManager=Manager.idManager;
SELECT * FROM Employees LEFT JOIN Manager
ON Employees.idManager=Manager.idManager;
SELECT * FROM Employees RIGHT JOIN Manager
ON Employees.idManager=Manager.idManager;
SELECT * FROM Employees Full JOIN Manager
ON Employees.idManager=Manager.idManager;

SELECT * FROM Employees INNER JOIN Manager
ON Employees.fname=Manager.fname;
SELECT * FROM Employees LEFT JOIN Manager
ON Employees.fname=Manager.fname;
SELECT * FROM Employees RIGHT JOIN Manager
ON Employees.fname=Manager.fname;
SELECT * FROM Employees FULL JOIN Manager
ON Employees.fname=Manager.fname;

SELECT * FROM Manager INNER JOIN Employees
ON Manager.lname=Employees.lname;
SELECT * FROM Manager LEFT JOIN Employees
ON Manager.lname=Employees.lname;
SELECT * FROM Manager RIGHT JOIN Employees
ON Manager.lname=Employees.lname;
SELECT * FROM Manager FULL JOIN Employees
ON Manager.lname=Employees.lname;

SELECT * FROM Car INNER JOIN Customer
ON Car.idCustomer=Customer.idCustomer;
SELECT * FROM Car LEFT JOIN Customer
ON Car.idCustomer=Customer.idCustomer;
SELECT * FROM Car RIGHT JOIN Customer
ON Car.idCustomer=Customer.idCustomer;
SELECT * FROM Car FULL JOIN Customer
ON Car.idCustomer=Customer.idCustomer;

SELECT * FROM Orders INNER JOIN Customer
ON Orders.idCustomer=Customer.idCustomer;
SELECT * FROM Orders LEFT JOIN Customer
ON Orders.idCustomer=Customer.idCustomer;
SELECT * FROM Orders RIGHT JOIN Customer
ON Orders.idCustomer=Customer.idCustomer;
SELECT * FROM Orders FULL JOIN Customer
ON Orders.idCustomer=Customer.idCustomer;

-- statements with aggregate functions and group by and without having--

SELECT city, MAX(salary), MIN(salary) FROM Employees GROUP BY city;
SELECT city, AVG(salaryt), MAX(salary), MIN(salary) FROM Employees GROUP BY city;
SELECT idManager, MAX(salary), MIN(salary) FROM Employees GROUP BY idManager;
SELECT idManager, AVG(salary), MIN(salary), MAX(salary) FROM Employees GROUP BY idManager ORDER BY salary ASC;
SELECT idManager, COUNT(idEmployees) FROM Employees GROUP BY idManager;
SELECT city, idManager, SUM(Salary), COUNT(idEmployees) FROM Employees GROUP BY city, idManager;
SELECT city, SUM(Salary)FROM Employees WHERE idEmployees <> 2 GROUP BY city;
SELECT city, AVG(Salary)FROM Employees WHERE idEmployees > 3 GROUP BY city;


-- statements with aggregate functions and group by and with having --

SELECT city, MAX(salary), MIN(salary) FROM Employees WHERE idEmployees <> 3 GROUP BY city HAVING MIN(salary) > 35000;
SELECT city, MAX(salary), MIN(salary) FROM Employees WHERE idEmployees <> 3 GROUP BY city HAVING MAX(salary) > 35000;
SELECT city, SUM(salary) FROM Employees WHERE idEmployees <> 4 GROUP BY city HAVING SUM(salary) > 35000;
SELECT idManager, AVG(SALARY) FROM Employees Group By city HAVING AVG(SALARY) <> 44000 AND AVG(SALARY) <> 49000;
SELECT idManager, AVG(SALARY) FROM Employees WHERE idManager <> 1 Group By city HAVING AVG(SALARY) <> 44000 AND SUM(SALARY) < 80000;
SELECT fname, SUM(salary) FROM Employees GROUP BY fname HAVING MIN(SALARY) > 15000 ORDER BY fname ASC;
SELECT lname, SUM(salary) FROM Employees WHERE lname <> "Lopez" GROUP BY fname HAVING MIN(SALARY) > 15000 ORDER BY salary DESC;