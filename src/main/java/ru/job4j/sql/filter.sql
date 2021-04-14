create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type(name) values ('Сыр');
insert into type(name) values ('Молоко');
insert into type(name) values ('Мясо');
insert into type(name) values ('Рыба');

insert into product(name, type_id, expired_date, price) values ('Вязанка сырокопчёная колбаса', 1, 12.05.2021, 100);
insert into product(name, type_id, expired_date, price) values ('Моцарелла', 1, 12.07.2021, 300);
insert into product(name, type_id, expired_date, price) values ('Голандский', 1, 12.06.2021, 250);

insert into product(name, type_id, expired_date, price) values ('Бурёнка', 2, 20.04.2021, 60);
insert into product(name, type_id, expired_date, price) values ('Простоквашино', 2, 22.04.2021, 55);
insert into product(name, type_id, expired_date, price) values ('Домик в деревне', 2, 03.05.2021, 60);

insert into product(name, type_id, expired_date, price) values ('Свинина', 3, 20.07.2021, 500);
insert into product(name, type_id, expired_date, price) values ('Говядина', 3, 20.07.2021, 800);
insert into product(name, type_id, expired_date, price) values ('Телятина', 3, 20.07.2021, 1000);
insert into product(name, type_id, expired_date, price) values ('Свинина мороженная', 3, '20-11-2021', 700);
insert into product(name, type_id, expired_date, price) values ('Говядина мороженная', 3, '20-11-2021', 1000);

insert into product(name, type_id, expired_date, price) values ('Вобла сушёная', 4, 20.10.2021, 100);
insert into product(name, type_id, expired_date, price) values ('Сельдь слабосолёная', 4, 20.05.2021, 150);
insert into product(name, type_id, expired_date, price) values ('Горбуша консерва', 4, 20.04.2022, 200);


select p.name from product as p join type as t on p.type_id = t.id
where t.name = 'Сыр';

select * from product as p where p.name like '%мороженная%';

select  name from product
where Extract(month from  EXPIRED_DATE  ) = (
select Extract(month from CURRENT_DATE + interval '1 month'));

select name from product where price = (select max(product.price) from product);

select t.name, count(t.id) from type as t join product as p on p.type_id = t.id
group by t.name, t.id;

select p.name from type as t join product as p on p.type_id = t.id
where t.name = 'Сыр'
or t.name = 'Молоко';

select t.name, count(t.id) from type as t join product as p on p.type_id = t.id
group by t.name, t.id
having t.id < 10;

select p.name, t.name from type as t join product as p on p.type_id = t.id
group by p.name, t.name;