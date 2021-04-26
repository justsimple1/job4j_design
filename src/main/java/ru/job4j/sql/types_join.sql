create table departments (
                             id serial primary key,
                             name varchar(200)
);

create table emploees (
                          name varchar(200),
                          id_department int references departments(id)
);

insert into departments(name) values ('Main');
insert into departments(name) values ('Worked');
insert into departments(name) values ('Control');
insert into departments(name) values ('Production');

insert into emploees(name, id_department) values ('junior', 2);
insert into emploees(name, id_department) values ('middle', 3);
insert into emploees(name, id_department) values ('senior', 1);

select * from emploees e left join departments d on e.id_department = d.id;
select * from emploees e right join departments d on e.id_department = d.id;
select * from emploees e full join departments d on e.id_department = d.id;
select * from emploees e cross join departments d;

select * from departments d left join emploees e on e.id_department = d.id where e.id_department is null;

select * from departments d left join emploees e on e.id_department = d.id where e.name is not null;
select * from departments d right join emploees e on e.id_department = d.id where e.name is not null;

create table teens (
                       name varchar(255),
                       gender varchar(255)
);

insert into teens(name, gender) values ('Smith', 'Men
insert into teens(name, gender) values ('John', 'Men');
insert into teens(name, gender) values ('Lisa', 'Women');
insert into teens(name, gender) values ('Eva', 'Women');

select n1.name as a, n2.name as b from teens n1 cross join teens n2 where n1.name != n2.name