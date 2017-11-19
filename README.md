# Railway_Project

## About

A Railway Reservation Portal to demonstrate the uses of various design patterns & principles.

## Requirements

- JDK
- JRE

## Instructions

Download mysql-connector and set the classpath as:

```
$ export CLASSPATH=/path/to/mysql-connector-java-5.1.44-bin.jar:$CLASSPATH
```

In file JavaSQL.java, set your host address, MySQL username & password in the following line in the functions executeSQL() and executeSQLUpdate()

```
Connection con=DriverManager.getConnection("host_addr", "username", "password");  
```

Compilation

```
$ javac *.java
```

RailwayMenu is the driver program
```
$ java RailwayMenu
```