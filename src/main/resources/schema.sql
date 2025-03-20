--CREATE TABLE IF NOT EXISTS run (
--  id SERIAL PRIMARY KEY,
--  title VARCHAR(250) NOT NULL,
--  started_on TIMESTAMP NOT NULL,
--  completed_on TIMESTAMP NOT NULL,
--  miles INT NOT NULL,
--  location VARCHAR(10) NOT NULL,
--  version INT
--);
CREATE TABLE IF NOT EXISTS categories (
  id INT PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  image_url VARCHAR(500) NOT NULL
);
