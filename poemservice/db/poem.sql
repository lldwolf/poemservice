alter table poem rename to poem_bak;

CREATE TABLE poem (id integer primary key autoincrement,
title varchar(200),
author varchar(20),
content varchar(6000),
album varchar(40),
type varchar(10),
url varchar(100),
public_degree int,
dynasty varchar(10));


insert into poem(id, title, author, content, album, type, url, public_degree, dynasty)
select id, title, author, content, album, type, url, public_degree, dynasty
from poem_bak;

drop table poem_bak;

alter table poem add column author_id integer;

create table author (
	id integer primary key autoincrement,
	name varchar(20),
	dynasty varchar(10)
);

insert into author(name, dynasty)
select distinct author, dynasty
from poem;

update poem set author_id = (select b.id from author b where poem.author = b.name and poem.dynasty = b.dynasty);