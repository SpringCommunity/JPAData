CREATE DATABASE IF NOT EXISTS `springcommunity`;

USE `springcommunity`;

--
--This script is for MariaDB
--

--
-- Table structure for table role
--

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id int(3) NOT NULL AUTO_INCREMENT,
  role varchar(255) NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;

--
-- Table structure for table user
--

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  roleid int(1),
  PRIMARY KEY(id, username),
  FOREIGN KEY(roleid) REFERENCES role(id)
) ENGINE=InnoDB CHARSET=utf8;

--
-- Table structure for table category
--

DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id int(3) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;

--
-- Table structure for table book
--

DROP TABLE IF EXISTS book;
CREATE TABLE book (
  id int(3) NOT NULL AUTO_INCREMENT,
  isbn varchar(255) NOT NULL,
  name varchar(255) NOT NULL DEFAULT 'book',
  author varchar(255) NOT NULL DEFAULT 'author',
  categoryid int(3),
  publisheddate datetime,
  PRIMARY KEY(id, isbn),
  FOREIGN KEY(categoryid) REFERENCES category(id)
) ENGINE=InnoDB CHARSET=utf8;



--
--This script is for PostgreSQL
--

--
-- Table structure for table role
--
DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id SERIAL NOT NULL,
  role varchar(255) NOT NULL,
  PRIMARY KEY(id)
);





DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id bigserial NOT NULL,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  roleid serial,
  PRIMARY KEY(id, username),
  FOREIGN KEY(roleid) REFERENCES role(id)
);




DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id SERIAL NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY(id)
);


DROP TABLE IF EXISTS book;
CREATE TABLE book (
  id SERIAL NOT NULL,
  isbn varchar(255) NOT NULL,
  name varchar(255) NOT NULL DEFAULT 'book',
  author varchar(255) NOT NULL DEFAULT 'author',
  categoryid serial,
  publisheddate date,
  PRIMARY KEY(id, isbn),
  FOREIGN KEY(categoryid) REFERENCES category(id)
);



--
-- Insert test DATABASE
--

INSERT INTO role(role) VALUES ('member');
INSERT INTO role(role) VALUES ('guest');
INSERT INTO account(username, password, roleid) VALUES ('demo','demo123',1);
INSERT INTO account(username, password, roleid) VALUES ('guest','guest123',2);
INSERT INTO category(name) VALUES ('Kinh Te'), ('Cong Nghe Thong Tin'), ('Tam Ly'), ('Lich Su'), ('Truyen ngu ngon');
INSERT INTO book(isbn, name, author, categoryid, publisheddate) VALUES ('88474747474747474747','SQL for beginner','Phan Manh Quynh',3,'2017-02-12'), ('948474636363636','Chi Dau','Le Quyen',5,'2017-12-25'), ('835857575757575757','Hoang Phi','Le Quyen',5,'2017-12-25') ;





