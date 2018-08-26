"# Spring5"

## GIT

git branch -a: pokaz wszystkie branche

## Stos projektu

ElastickSearch - szybki, ma failovery, na elasticksearch przychodza gotowe dane z logstasha 
KIBANA - GUI do Elasticksearch
Logstash - logika w ruby do mergowania/agregowania danych przesylanych do Elasticksearch
Apache Kafka - rozproszona kolejka podobna do RabbitMQ, wiele punkt�w skad przesylamy dane, szybka

##  Spring batch

### 1. Run MySQL server as docker
```
cd docker/mysql
docker-compose up
```

### 2. Open in your browser: http://localhost:8080

- DB: springbatchmysql
- login/pass: root/root
- table: springbatch

### 3. MYSQL db (optional if no db is not initialized) 

init:
In schema: springbatchmysql create new table:
```
CREATE TABLE album
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    version INT,
    name TEXT NOT NULL
);
```

data:
```
INSERT INTO album (version, name) VALUES (0, 'album 1');
INSERT INTO album (version, name) VALUES (0, 'album 2');
```

#### Run app

Run application. 
File `album.xml` should be created in `target`.
