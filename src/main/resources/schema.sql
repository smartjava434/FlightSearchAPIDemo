DROP TABLE IF EXISTS Flight;  
CREATE TABLE Flight (  
NUMBER VARCHAR2(50) PRIMARY KEY,  
ORIGIN VARCHAR2(50) NOT NULL, 
DESTINATION  VARCHAR2(50) NOT NULL,
DEPARTURETIME DATETIME NOT NULL,
ARRIVALTIME DATETIME NOT NULL,
PRICE DECIMAL(10,2) NOT NULL
); 