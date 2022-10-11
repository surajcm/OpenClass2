--create table member (
    --id bigint generated by default as identity (start with 1) primary key,
    --first_name varchar(225),
    --last_name varchar(225),
    --email varchar(225),
    --password varchar(255),
    --users_roles varchar(45)
--);

--create table users_roles
--(
    --id   bigint generated by default as identity (start with 1) primary key,
    --name varchar(225)
--);

drop table if exists member cascade;
drop table if exists users_roles cascade;
drop table if exists roles cascade;
create table member (
   id bigint generated by default as identity,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    primary key (id)
);
create table roles (
     id bigint generated by default as identity,
     name varchar(255),
     primary key (id)
);
create table users_roles (
   id bigint generated by default as identity,
    name varchar(255),
    user_id bigint not null,
    role_id bigint not null,
    primary key (id)
);

alter table if exists member
       add constraint UKmbmcqelty0fbrvxp1q58dn57t unique (email);


alter table if exists users_roles
       add constraint FKaxm251aosah2cgsmksb5xy7if
       foreign key (role_id)
       references roles;

alter table if exists users_roles
       add constraint FK66pv2grnj7pivu4d3y8s5gxgx
       foreign key (user_id)
       references member;
