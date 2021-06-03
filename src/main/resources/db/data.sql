DELETE FROM schedules;
DELETE FROM user_roles;
DELETE FROM talks;
DELETE FROM rooms;
DELETE FROM users;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO users(name, email, password)
VALUES ('u1', 'admin@gmail.com', '{noop}p1'),
       ('u2', 'listener@gmail.com', '{noop}p2'),
       ('u3', 'speaker@gmail.com', '{noop}p3');

INSERT INTO rooms(name)
VALUES ('Комната 1'),
       ('Комната 2'),
       ('Комната 3');

INSERT INTO talks(name)
VALUES ('Доклад 1'),
       ('Доклад 2'),
       ('Доклад 3');

INSERT INTO user_roles(role, user_id)
VALUES ('ADMIN', 100000),
       ('LISTENER', 100001),
       ('SPEAKER', 100002);


INSERT INTO schedules(date_time, room_id, talk_id)
VALUES ('2020-01-30 10:00:00', 100003, 100006),
       ('2020-01-30 13:00:00', 100004, 100007),
       ('2020-01-31 10:00:00', 100005, 100008);
