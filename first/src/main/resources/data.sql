insert into publisher (id,name) values (nextval('pub_seq'),'Oreilly');
insert into publisher (id,name) values (nextval('pub_seq'),'tata mcgraw hill');
insert into publisher (id,name) values (nextval('pub_seq'),'Pigeon');
 
insert into book (id,name,price,year,publisher_id) values (nextval('book_seq'),'the complete refrence - java',120,1997,2);
insert into book (id,name,price,year,publisher_id) values (nextval('book_seq'),'anxious people',100,2001,3);
insert into book (id,name,price,year,publisher_id) values (nextval('book_seq'),'kite runner',90,2004,3);
insert into book (id,name,price,year,publisher_id) values (nextval('book_seq'),'J2ee best practices',300,2001,1);
insert into book (id,name,price,year,publisher_id) values (nextval('book_seq'),'the spring framework',250,2005,1);
insert into book (id,name,price,year,publisher_id) values (nextval('book_seq'),'hibernate workbook',100,2003,2);
 
insert into author (id,name,address) values (nextval('author_seq'),'Rod Johnson','Europe');
insert into author (id,name,address) values (nextval('author_seq'),'Jurgeon holler','Europe');
insert into author (id,name,address) values (nextval('author_seq'),'james goshling','US');
insert into author (id,name,address) values (nextval('author_seq'),'gavin king','US');
insert into author (id,name,address) values (nextval('author_seq'),'fedrick backman','Australia');
insert into author (id,name,address) values (nextval('author_seq'),'Khaled Hosseini','Afganisthan');
 
 
insert into book_author(book_id, author_id) values(1,3);
insert into book_author(book_id, author_id) values(2,5);
insert into book_author(book_id, author_id) values(3,6);
insert into book_author(book_id, author_id) values(4,1);
insert into book_author(book_id, author_id) values(4,2);
insert into book_author(book_id, author_id) values(5,1);
insert into book_author(book_id, author_id) values(5,2);
insert into book_author(book_id, author_id) values(6,4);
 
 
 