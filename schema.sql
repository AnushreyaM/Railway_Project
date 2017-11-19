DROP DATABASE Railway;

CREATE DATABASE Railway;
USE Railway;

CREATE TABLE train(
    source varchar(20),
    destination varchar(20),
    cur_first_class integer,
    cur_second_class integer,
    cur_economy_class integer,
    tno integer primary key
    );


CREATE TABLE ticket(
    
    tid integer primary key AUTO_INCREMENT,
    trainNo integer,
    pname varchar(20),
    FOREIGN KEY(trainNo) REFERENCES train(tno)
    
    );


CREATE TABLE users
(
  uname varchar(20) primary key,
  psswd varchar(20)
);

 CREATE TABLE passenger(
    
    pid varchar(20),
    pname varchar(20),
    tid integer,
    FOREIGN KEY(tid) REFERENCES ticket(tid),
    FOREIGN KEY(pid) REFERENCES users(uname)
    );