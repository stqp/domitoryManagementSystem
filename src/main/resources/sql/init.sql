create table user (
    id int primary key,
    name char(255),
    email char(255),
    pass char(255)
);

insert into user (id, name, email, pass) values(1, 'test01', 'test01@gmail.com', 'pass');


create table building (
    id int primary key,
    name char(255)
);


create table floor {
    id int primary key,
    name
}