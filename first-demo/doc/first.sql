
use `first`;

drop table if exists person;

create table person(
	id int(11) not null auto_increment,
	name varchar(120) not null default '',
	sex tinyint(1) not null default 0,
	age tinyint(3) unsigned not null default 0,
	primary key (id)
);

insert into person values
(0, 'xiaoming', 1, 23),
(0, 'hanmeimei', 2, 20),
(0, 'xiaolin', 2, 200);

select * from person;