CREATE TABLE publisher (
    id INT PRIMARY KEY,
    name VARCHAR(30)
);

create sequence pub_seq start with 1;

CREATE TABLE book (
    id INT PRIMARY KEY,
    name VARCHAR(30),
    price INT,
    "year" INT,  
    publisher_id INT REFERENCES publisher(id)
);

create sequence book_seq start with 1;

create table author(
id int primary key,
name varchar(30),
address varchar(100));

create sequence author_seq start with 1;

create table book_author(
book_id int not null,
author_id int not null,
primary key (book_id,author_id)
);