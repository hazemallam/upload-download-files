INSERT INTO permission_group VALUES(1, 'ADMIN');
INSERT INTO users (id, email, status, password) VALUES(1, 'hazem@gmail.com', 1, '123456');
INSERT INTO users (id, email, status, password) VALUES(2, 'mohamed@gmail.com', 1, '654321');
INSERT INTO permission (id, group_id, permission_level, user_id) VALUES(1, 1, 'VIEW', 1);
INSERT INTO permission (id, group_id, permission_level, user_id) VALUES(2, 1, 'EDIT', 2);
