CREATE TABLE USER (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME  VARCHAR(255) NOT NULL,
    USERNAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    ENABLED TINYINT NOT NULL,
    CREATED_DATE_TIME DATETIME NOT NULL,
    LAST_LOGIN_DATE_TIME DATETIME
)