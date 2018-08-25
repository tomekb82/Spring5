## Environment prepare

1. Run MySQL server as docker
```
cd docker/mysql
docker-compose up
```

2. Open in your browser: http://localhost:8080

- DB: springbatchmysql
- login/pass: root/root

### MYSQL init:
In schema: springbatchmysql create new table:
```
CREATE TABLE person
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    pesel VARCHAR(11) NOT NULL,
    occupation TEXT
);
```

### MYSQL data:
```
INSERT INTO person (name, surname, pesel, occupation) VALUES ("Mike", "Lisbeth", "80050529434", "driver");
INSERT INTO person (name, surname, pesel, occupation) VALUES ("Ann", "Mardo", "80090548945", "nurse");
INSERT INTO person (name, surname, pesel, occupation) VALUES ("Peter", "Mardock", "88051694814", "capitan");
INSERT INTO person (name, surname, pesel, occupation) VALUES ("Kim", "Teylor", "63090513128", "docktor");
```

### Run app

Run application from main. File `people.xml` should be created in `target`.