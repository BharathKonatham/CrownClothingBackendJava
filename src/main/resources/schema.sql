--CREATE TABLE IF NOT EXISTS run (
--  id SERIAL PRIMARY KEY,
--  title VARCHAR(250) NOT NULL,
--  started_on TIMESTAMP NOT NULL,
--  completed_on TIMESTAMP NOT NULL,
--  miles INT NOT NULL,
--  location VARCHAR(10) NOT NULL,
--  version INT
--);
BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE categories (
       id INT PRIMARY KEY,
       title VARCHAR2(250) NOT NULL,
       image_url VARCHAR2(500) NOT NULL
   )';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -955 THEN -- Table already exists
         RAISE;
      END IF;
END;

