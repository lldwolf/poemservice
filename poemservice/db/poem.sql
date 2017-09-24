alter table poem rename to poem_bak;

CREATE TABLE poem (id integer primary key autoincrement,
title varchar(200),
author varchar(20),
content varchar(6000),
album varchar(40),
type varchar(10),
url varchar(100),
public_degree int, dynasty varchar(10));

insert into poem(id, title, author, content, album, type, url, public_degree, dynasty)
select id, title, author, content, album, type, url, public_degree, dynasty
from poem_bak;

drop table poem_bak;