create table books(
    id bigint primary key auto_increment,
    title varchar(255) not null unique,
    author varchar(255) not null,
    isbn varchar(255) not null unique,
    quantity integer not null
);