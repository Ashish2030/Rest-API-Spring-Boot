DROP TABLE IF EXISTS UserDetails;
  
CREATE TABLE UserDetails (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  number VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);