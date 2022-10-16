

insert into roles (id, name,createdOn, modifiedOn, createdBy, modifiedBy) values
(1, 'ADMIN','2019-11-20 00:00:00','2019-11-20 00:00:00','admin','admin');

insert into member (id, first_name, last_name, email, password, role, createdOn, modifiedOn, createdBy, modifiedBy) values
(1, 'admin', 'admin', 'admin123@admin.com', 'is$2a$10$eyc7z5iMD.Enxx5p7WsIB.yJv7TUCrOB4hSJMgZrk.FLTsA0oGweu', 1,
 '2019-11-20 00:00:00','2019-11-20 00:00:00','admin','admin');

--insert into users_roles (id, name, user_id, role_id) values (1, 'Admin role', 1, 1);