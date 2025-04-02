CREATE DATABASE spring DEFAULT CHARSET utf8;
CREATE USER spring IDENTIFIED BY 'spring';
grant all privileges on spring.* to spring;
