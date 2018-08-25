CREATE TABLE ROOM (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  number INT,
  capacity INT,
  PRIMARY KEY (id),
  cinema_id BIGINT,

  CONSTRAINT FK_CINEMA FOREIGN KEY (cinema_id) REFERENCES CINEMA(id)
);

INSERT INTO ROOM VALUES (NULL, 1, 2, 1);
INSERT INTO ROOM VALUES (NULL, 2, 4, 1);