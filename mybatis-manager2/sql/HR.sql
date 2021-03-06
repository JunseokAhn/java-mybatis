DROP TABLE CONSUMER;
CREATE TABLE CONSUMER(
CONSUMER_ID VARCHAR2(20) primary key ,
CONSUMER_NAME VARCHAR2(20),
PROPERTY NUMBER DEFAULT 50000
);

DROP TABLE PRODUCER;
CREATE TABLE PRODUCER(
PRODUCER_ID VARCHAR2(20) primary key ,
PRODUCER_NAME VARCHAR2(20),
PROPERTY NUMBER DEFAULT 100000
);

DROP TABLE MOVIE;
CREATE TABLE MOVIE(
MOVIE_NUM NUMBER PRIMARY KEY,
MOVIE_NAME VARCHAR2(20),
SEKI NUMBER,
PRICE NUMBER,
PRODUCER_ID VARCHAR2(20),
FOREIGN KEY (PRODUCER_ID)REFERENCES PRODUCER(PRODUCER_ID) ON DELETE SET NULL 
);

ALTER TABLE MOVIE MODIFY(SEKI NUMBER DEFAULT 5);

DROP SEQUENCE MOVIE_SEQ;
CREATE SEQUENCE MOVIE_SEQ;
DROP TRIGGER MOVIE_TRI;
/
CREATE OR REPLACE TRIGGER MOVIE_TRI
    BEFORE INSERT ON MOVIE FOR EACH ROW
    BEGIN
    SELECT MOVIE_SEQ.NEXTVAL
    INTO :NEW.MOVIE_NUM
    FROM DUAL;
END;
/

DROP TABLE BRIDGE;
CREATE TABLE BRIDGE(
MOVIE_NUM NUMBER,
FOREIGN KEY(MOVIE_NUM) REFERENCES MOVIE(MOVIE_NUM) ON DELETE CASCADE,
CONSUMER_ID VARCHAR2(20) ,
FOREIGN KEY(CONSUMER_ID) REFERENCES CONSUMER(CONSUMER_ID) ON DELETE CASCADE
);

DROP TABLE REPLY;
CREATE TABLE REPLY(
REPLY_NUM NUMBER PRIMARY KEY,
CONTENTS VARCHAR2(1000),
MOVIE_NUM NUMBER,
CONSUMER_ID VARCHAR2(20),
REREPLY_NUM NUMBER,
FOREIGN KEY(REREPLY_NUM) REFERENCES REPLY(REPLY_NUM) ON DELETE CASCADE,
FOREIGN KEY(MOVIE_NUM) REFERENCES MOVIE(MOVIE_NUM) ON DELETE CASCADE
);

DROP SEQUENCE REPLY_SEQ;
CREATE SEQUENCE REPLY_SEQ;

DROP TRIGGER REPLY_TR;
CREATE OR REPLACE TRIGGER REPLY_TR
BEFORE INSERT ON REPLY FOR EACH ROW
    BEGIN
    SELECT REPLY_SEQ.NEXTVAL
    INTO :NEW.REPLY_NUM
    FROM DUAL;
END;
/
