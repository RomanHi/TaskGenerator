CREATE TABLE century (
  id    SERIAL PRIMARY KEY,
  value INT
);

CREATE TABLE event (
  id         SERIAL PRIMARY KEY,
  century INT,
  name VARCHAR,
  year INT UNIQUE
);