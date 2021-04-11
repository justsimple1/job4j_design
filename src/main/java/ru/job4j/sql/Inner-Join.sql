create table cars(
	id serial primary key,
	model varchar(255),
	condition varchar(255)
);

create table tasks(
	id serial primary key,
	name varchar(255),
	price int,
	cars_id int references cars(id)
);

insert into cars(model, condition) values('BMW', 'good');
insert into cars(model, condition) values('Lada', 'worst');
insert into cars(model, condition) values('Audi', 'normal');

insert into tasks(name, price, cars_id) values('Смена колёс', 5500, 1);
insert into tasks(name, price, cars_id) values('Починка руля', 1500, 1);
insert into tasks(name, price, cars_id) values('Заправка автомобиля', 200, 1);
insert into tasks(name, price, cars_id) values('Смена колёс', 500, 2);
insert into tasks(name, price, cars_id) values('Заправка автомобиля', 300, 2);
insert into tasks(name, price, cars_id) values('Смена колёс', 1500, 3);
select pp.name, p.model from tasks as pp join cars as p on pp.cars_id = p.id;
select pp.name, p.condition from tasks as pp join cars as p on pp.cars_id = p.id;
select p.name, p.price, pp.condition from tasks as p join cars as pp on p.price > 500;