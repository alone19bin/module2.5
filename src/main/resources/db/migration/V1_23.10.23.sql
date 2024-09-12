USE sec;

create table files
(
    id       int primary key AUTO_INCREMENT ,
    location varchar(255) not null,
    fileName varchar(255) not null,
    status   varchar(50) default 'ACTIVE'

);
create table users
(
    id         int primary key AUTO_INCREMENT ,
    username   varchar(64)   not null unique,
    password   varchar(2048) not null,
    first_name varchar(64)   not null,
    last_name  varchar(64)   not null,
    status     varchar(50)            default 'ACTIVE',
    enabled    boolean       not null default false,
    role       varchar(32)   not null,
    created_at  timestamp,
    updated_at  timestamp

);
create table events
(

    id      int primary key AUTO_INCREMENT ,
    file_id int,
    user_id int,
    status  varchar(50) default 'ACTIVE',
    foreign key (file_id) references files (id),
    foreign key (user_id) references users (id)

);