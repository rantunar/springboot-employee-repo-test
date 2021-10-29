DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id int AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  designation VARCHAR(250) NOT NULL,
  salary bigint NOT NULL
);

INSERT INTO employee (first_name, designation, salary) VALUES
  ('Aliko', 'Architect', 600000),
  ('Bill', 'Senior Architect', 600000),
  ('Folrunsho', 'Sales Lead', 600000);