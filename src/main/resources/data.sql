

insert into roles (id, name,createdOn, modifiedOn, createdBy, modifiedBy) values
(1, 'ADMIN','2022-10-20 00:00:00','2022-10-20 00:00:00','admin','admin');

insert into member (id, first_name, last_name, email, password, role, createdOn, modifiedOn, createdBy, modifiedBy) values
(1, 'admin', 'admin', 'admin@admin.com', '$2a$10$bv9jtuan.SZKu9bIbXJSmuUjIDHSN0FCaxR8BvM2Yvkmc5C5yMFpq', 1,
 '2022-10-20 00:00:00','2022-10-20 00:00:00','admin','admin');

--insert into users_roles (id, name, user_id, role_id) values (1, 'Admin role', 1, 1);