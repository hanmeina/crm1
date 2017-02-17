use mydb2;

drop table if exists employee;
drop table if exists department;

create table if not exists department(
	id int primary key auto_increment,
	name varchar(20) not null
);
create table if not exists employee(
	id int primary key auto_increment,
	name varchar(20) not null,
	did int,
	constraint did_FK foreign key(did) references department(id)
);

