DELETE FROM schedules;
DELETE FROM user_roles;
DELETE FROM talks;
DELETE FROM rooms;
DELETE FROM users;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO users(name, email, password)
VALUES ('user1', 'user1@gmail.com', 'password1'),
       ('user2', 'user2@gmail.com', 'password2'),
       ('user3', 'user3@gmail.com', 'password3');

INSERT INTO rooms(name)
VALUES ('room1'),
       ('room2'),
       ('room3');

INSERT INTO talks(name)
VALUES ('talks1'),
       ('talk2'),
       ('talk3');

INSERT INTO user_roles(role, user_id)
VALUES ('ADMIN', 100000),
       ('user2', 100001),
       ('user3', 100002);

INSERT INTO schedules(date_time, room_id, talk_id)
VALUES ('2020-01-30 10:00:00', 100003, 100006),
       ('2020-01-30 13:00:00', 100004, 100007),
       ('2020-01-31 10:00:00', 100005, 100008);
