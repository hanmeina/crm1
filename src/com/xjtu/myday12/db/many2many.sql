use mydb2;

drop table if exists middle;
drop table if exists teacher;
drop table if exists student;

create table if not exists teacher(
	id int primary key auto_increment,
	name varchar(20) not null
);
create table if not exists student(
	id int primary key auto_increment,
	name varchar(20) not null
);
create table if not exists middle(
	tid int, 
	sid	int,
	primary key(tid,sid),
	constraint tid_FK foreign key(tid) references teacher(id),
	constraint sid_FK foreign key(sid) references student(id)
);

