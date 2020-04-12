CREATE TABLE user_personal(
userID VARCHAR(30),
u_email VARCHAR(30),
fname VARCHAR(30),
lname  VARCHAR(30),
city VARCHAR(30),
state VARCHAR(30),
zip NUMBER(20));

INSERT INTO user_personal 
VALUES('MA12','alex@gmail.com','Alex','Jones','Hoyton','Texas',75001);
INSERT INTO user_personal 
VALUES('PO45','emma.john@gmail.com','Emma','Stone','Albany','New York',10008);
INSERT INTO user_personal 
VALUES('LA33','victoria@yahoo.com','Victoria','Aorora','Istanbul','Turkey',34000);
INSERT INTO user_personal 
VALUES('CH99','joe.197@gmail.com','Joe','Johnson','Los angales','california',90201);
INSERT INTO user_personal 
VALUES('PA74','dlany01@gmail.com','Dany','William','Miami','Florida',32006);

------------------------------------------------------------------------------------------------------

CREATE TABLE USERPERSONAL(
USERID VARCHAR(10)PRIMARY KEY,
U_EMAIL VARCHAR(30)NOT NULL,
FNAME VARCHAR(30)NOT NULL,
LNAME VARCHAR(30)NOT NULL,
CITY VARCHAR(30)NOT NULL,
STATE VARCHAR(30)NOT NULL,
ZIP VARCHAR(20)NOT NULL
);

INSERT INTO USERPERSONAL
(USERID,U_EMAIL,FNAME,LNAME,CITY,STATE,ZIP)
VALUES('MA12','alex@ymail.com','alex','jones','houston','texas','75001');
INSERT INTO USERPERSONAL
(USERID,U_EMAIL,FNAME,LNAME,CITY,STATE,ZIP)
VALUES('PO45','emma.john@gmail.com','emma','stone','albany','new work','10008');
INSERT INTO USERPERSONAL
(USERID,U_EMAIL,FNAME,LNAME,CITY,STATE,ZIP)
VALUES('LA33','victoria@yahoo.com','victoria','aurora','istanbul','turkey','34000');
INSERT INTO
USERPERSONAL(USERID,U_EMAIL,FNAME,LNAME,CITY,STATE,ZIP)
VALUES('CH99','joe.1997@hotmailmail.com','joe','johnson','los angeles','california','90201');
INSERT INTO USERPERSONAL
(USERID,U_EMAIL,FNAME,LNAME,CITY,STATE,ZIP)
VALUES('DA74','dlany01@live.com','dany','william','miami','florida','32006');

---------------------------------------------------------------------------------------------------------
CREATE TABLE USERINFO(
USERID VARCHAR(10)PRIMARY KEY,
U_EMAIL VARCHAR(30)NOT NULL,
FNAME VARCHAR(30)NOT NULL,
LNAME VARCHAR(30)NOT NULL
);

INSERT INTO USERINFO
(USERID,U_EMAIL,FNAME,LNAME)
VALUES('MA12','alex@ymail.com','alex','jones');
INSERT INTO USERINFO
(USERID,U_EMAIL,FNAME,LNAME)
VALUES('PO45','emma.john@gmail.com','emma','stone');
INSERT INTO USERINFO
(USERID,U_EMAIL,FNAME,LNAME)
VALUES('LA33','victoria@yahoo.com','victoria','aurora');
INSERT INTO USERINFO
(USERID,U_EMAIL,FNAME,LNAME)
VALUES('CH99','joe.1997@hotmailmail.com','joe','johnson');
INSERT INTO USERINFO
(USERID,U_EMAIL,FNAME,LNAME)
VALUES('DA74','dlany01@live.com','dany','william');

CREATE TABLE ADDRESS(
CITY VARCHAR(30)NOT NULL,
STATE VARCHAR(30)NOT NULL,
ZIP VARCHAR(20) PRIMARY KEY
);

INSERT INTO ADDRESS
(CITY,STATE,ZIP)
VALUES('houston','texas','75001');
INSERT INTO ADDRESS
(CITY,STATE,ZIP)
VALUES('albany','new work','10008');
INSERT INTO ADDRESS
(CITY,STATE,ZIP)
VALUES('istanbul','turkey','34000');
INSERT INTO ADDRESS
(CITY,STATE,ZIP)
VALUES('los angeles','california','90201');
INSERT INTO ADDRESS
(CITY,STATE,ZIP)
VALUES('miami','florida','32006');

---------------------------------------------------------------------------------------------------------

CREATE TABLE USERDATA1(
USERID VARCHAR(10)NOT NULL,
U_EMAIL VARCHAR(30)NOT NULL,
CONSTRAINT USERDATA1_PK PRIMARY KEY (USERID)
);

INSERT INTO USERDATA1
(USERID,U_EMAIL)
VALUES('MA12','alex@ymail.com');
INSERT INTO USERDATA1
(USERID,U_EMAIL)
VALUES('PO45','emma.john@gmail.com');
INSERT INTO USERDATA1
(USERID,U_EMAIL)VALUES('LA33','victoria@yahoo.com');
INSERT INTO USERDATA1
(USERID,U_EMAIL)V
ALUES('CH99','joe.1997@hotmailmail.com');
INSERT INTO USERDATA1
(USERID,U_EMAIL)VALUES('DA74','dlany01@live.com');

CREATE TABLE USERDATA2(
USERID VARCHAR(10),
FNAME VARCHAR(30)NOT NULL,
LNAME VARCHAR(30)NOT NULL,
CONSTRAINT FK_USERID
FOREIGN KEY (USERID)
REFERENCES USERDATA1(USERID)
 );
 
INSERT INTO USERDATA2
(USERID,FNAME,LNAME)
VALUES('MA12','alex','jones');
INSERT INTO USERDATA2
(USERID,FNAME,LNAME)
VALUES('PO45','emma','stone');
INSERT INTO USERDATA2
(USERID,FNAME,LNAME)
VALUES('LA33','victoria','aurora');
INSERT INTO USERDATA2
(USERID,FNAME,LNAME)
VALUES('CH99','joe','johnson');
INSERT INTO USERDATA2
(USERID,FNAME,LNAME)
VALUES('DA74','dany','william');

CREATE TABLE ADDRESS1(
CITY VARCHAR(30)NOT NULL,
STATE VARCHAR(30)NOT NULL,
ZIP VARCHAR(20) PRIMARY KEY
);

INSERT INTO ADDRESS1
(CITY,STATE,ZIP)
VALUES('houston','texas','75001');
INSERT INTO ADDRESS1
(CITY,STATE,ZIP)
VALUES('albany','new work','10008');
INSERT INTO ADDRESS1
(CITY,STATE,ZIP)VALUES('istanbul','turkey','34000');
INSERT INTO ADDRESS1
(CITY,STATE,ZIP)
VALUES('los angeles','california','90201');
INSERT INTO ADDRESS1
(CITY,STATE,ZIP)
VALUES('miami','florida','32006');
