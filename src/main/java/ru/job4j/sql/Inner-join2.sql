create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('smartphone', 500.00);
insert into devices(name, price) values ('notepad', 3500.00);
insert into devices(name, price) values ('notebook', 7500.00);

insert into people(name) values ('Hank');
insert into people(name) values ('Josh');
insert into people(name) values ('Garry');
insert into people(name) values ('Stat');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(2, 1);

insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(3, 2);

insert into devices_people(device_id, people_id) values(1, 3);
insert into devices_people(device_id, people_id) values(2, 3);
insert into devices_people(device_id, people_id) values(3, 3);

insert into devices_people(device_id, people_id) values(3, 4);

select avg(s.price) from devices as s;
select s.name, avg(ss.price) from people as s join devices_people as dp on dp.people_id = s.id
join devices as ss on dp.device_id = ss.id
group by s.name;

select s.name, avg(ss.price) from people as s join devices_people as dp on dp.people_id = s.id
join devices as ss on dp.device_id = ss.id
group by s.name
having avg(ss.mark) > 5000;