create table users(
    id bigint primary key auto_increment,
    username varchar(100) not null,
    password varchar(255) not null
);

insert into users(id, username, password) values(1, 'admin', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');