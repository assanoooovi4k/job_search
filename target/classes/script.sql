 CREATE TABLE Users(
   id SERIAL PRIMARY KEY,
   username VARCHAR(255),
   password VARCHAR(255)
);

CREATE TABLE Vacancies(
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  title VARCHAR(255),
  content TEXT,
  salary VARCHAR(255),
  date VARCHAR(255)
)