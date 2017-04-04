INSERT INTO USER (id, userName, password) VALUES (1, 'Admin', 'admin');

INSERT INTO ROLE (id, name) VALUES (1, 'Admin');
INSERT INTO ROLE (id, name) VALUES (2, 'User');

INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
