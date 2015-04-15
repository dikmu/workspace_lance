CREATE TABLE USER_WATCH_LIST 
(
  USER_NAME VARCHAR2(60 CHAR) NOT NULL 
, WATCH_USER_NAME VARCHAR2(60 CHAR) 
, CREATE_BY VARCHAR2(60 CHAR) 
, CREATE_ON DATE 
, MODIFY_BY VARCHAR2(60 CHAR) 
, MODIFY_ON DATE 
, VERSION NUMBER 
, CONSTRAINT USER_WATCH_LIST_PK PRIMARY KEY 
  (
    USER_NAME 
  )
  ENABLE 
);

ALTER TABLE USER_WATCH_LIST
ADD CONSTRAINT USER_WATCH_LIST_U_USER_FK1 FOREIGN KEY
(
  USER_NAME 
)
REFERENCES U_USER
(
  USER_NAME 
)
ENABLE;