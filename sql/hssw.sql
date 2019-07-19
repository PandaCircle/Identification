CREATE TABLE users (id INT NOT NULL AUTO_INCREMENT,
username varchar(64) NOT NULL,
password varchar(64) NOT NULL,
nickname varchar(64) NOT NULL,
PRIMARY KEY(id),
UNIQUE(username)
);