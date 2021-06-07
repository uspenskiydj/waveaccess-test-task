DELETE FROM schedules;
DELETE FROM user_talks;
DELETE FROM talks;
DELETE FROM rooms;
DELETE FROM users;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO users(name, email, password, role)
VALUES ('Имя 1', 'admin@gmail.com', '{noop}admin', 'ADMIN'),
       ('Имя 2', 'listener@gmail.com', '{noop}listener', 'LISTENER'),
       ('Имя 3', 'speaker@gmail.com', '{noop}speaker', 'SPEAKER');

INSERT INTO rooms(name)
VALUES ('Комната 1'),
       ('Комната 2'),
       ('Комната 3');

INSERT INTO talks(name, duration_minutes)
VALUES ('Доклад 1', 30),
       ('Доклад 2', 60),
       ('Доклад 3', 90);

INSERT INTO user_talks(talk_id, user_id)
VALUES (100006, 100000),
       (100007, 100002),
       (100008, 100002);

INSERT INTO schedules(date_time, room_id, talk_id, user_id)
VALUES ('2020-01-30 10:00:00', 100003, 100006, 100000),
       ('2020-01-30 13:00:00', 100004, 100007, 100002),
       ('2020-01-31 10:00:00', 100005, 100008, 100002);
