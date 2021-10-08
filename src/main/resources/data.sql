DROP TABLE IF EXISTS appliance;

CREATE TABLE appliance (
  serial_number INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT,
  brand VARCHAR(100) NOT NULL,
  model VARCHAR(100) NOT NULL,
  status VARCHAR(20) DEFAULT NULL,
  date_bought DATE
);
