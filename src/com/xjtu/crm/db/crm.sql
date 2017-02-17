use mydb3;

drop table if exists customer;
create table if not exists customer(
 id int auto_increment primary key,
 name varchar(20) not null,
 gender varchar(6) not null,
 address varchar(30) not null,
 tel varchar(11) not null,
 email varchar(20) not null,
 birthday date not null
);

insert into customer(name,gender,address,tel,email,birthday)
values('��ǿ','��','����','15012345678','wq@163.com','1990-01-01');

insert into customer(name,gender,address,tel,email,birthday)
values('����','Ů','����','15813572468','lm@163.com','1991-02-02');

insert into customer(name,gender,address,tel,email,birthday)
values('����','��','����','13922334455','yy@163.com','1992-03-03');

insert into customer(name,gender,address,tel,email,birthday)
values('֣���','��','����','15277881290','zhy@163.com','1993-04-04');

insert into customer(name,gender,address,tel,email,birthday)
values('����','��','����','15246581290','wm@163.com','1994-05-05');

insert into customer(name,gender,address,tel,email,birthday)
values('�Ż�','��','����','18677881290','zj@163.com','1995-06-06');

insert into customer(name,gender,address,tel,email,birthday)
values('����','��','�Ϻ�','15577881290','zm@163.com','1996-07-07');

insert into customer(name,gender,address,tel,email,birthday)
values('����','��','�Ϻ�','15277886670','hp@163.com','1997-08-08');

insert into customer(name,gender,address,tel,email,birthday)
values('������','��','��ɽ','13977889324','szs@163.com','1998-09-09');

insert into customer(name,gender,address,tel,email,birthday)
values('������','��','��ɽ','15234561122','hxt@163.com','1999-10-10');

insert into customer(name,gender,address,tel,email,birthday)
values('����','Ů','��ɽ','1323351290','ly@163.com','2000-11-11');

insert into customer(name,gender,address,tel,email,birthday)
values('��С��','Ů','����','13645571290','yxl@163.com','2001-12-12');

select * from customer;

