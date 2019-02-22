create table customer(
   id long not null auto_increment,
   name varchar(255) not null,
   age integer not null,
   active varchar(255),
   primary key(id)
);

insert into customer(id, name, age, active)
values(1,"Raj", 22, "false");

insert into customer(id, name, age, active)
values(2,"Ravi", 23, "true");