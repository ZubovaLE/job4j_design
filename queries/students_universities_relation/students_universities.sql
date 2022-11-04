create table universities
(
    id   serial primary key,
    name text
);

create table students
(
    id            serial primary key,
    name          text,
    course        int,
    budget        bool,
    speciality    text,
    enroll_date   timestamp,
    university_id int references universities (id)
);

insert into universities(name)
values ('U1'), ('U2'), ('U3'), ('U4'), ('U5');

insert into students(name, course, budget, speciality, enroll_date, university_id)
values ('AB', 1, true, 'S1', date '2020-09-01', 1), ('AC', 2, true, 'S1', date '2019-09-02', 1), 
('AD', 3, true, 'M1', date '2018-09-03', 1), ('AE', 4, false, 'Z1', date '2017-09-04', 1), 
('AF', 5, false, 'E1', date '2016-09-05', 1), ('BC', 1, true, 'Q2', date '2020-09-01', 2), 
('BD', 2, true, 'R2', date '2019-09-02', 2), ('BE', 3, false, 'T2', date '2018-09-03', 2),
('BF', 4, false, 'Y2', date '2017-09-04', 2), ('BG', 5, false, 'U2', date '2016-09-05', 2),
('CD', 1, true, 'A3', date '2020-09-01', 3), ('CE', 2, true, 'D3', date '2019-09-01', 3),
('CF', 3, false, 'F3', date '2018-09-01', 3), ('CG', 4, false, 'G3', date '2017-09-01', 3),
('CH', 5, true, 'H3', date '2016-09-01', 3), ('DE', 1, false, 'Z4', date '2020-09-01', 4),
('DF', 2, true, 'X4', date '2019-09-01', 4), ('DG', 3, true, 'C4', date '2018-09-01', 4),
('DH', 4, false, 'V4', date '2017-09-01', 4), ('DJ', 5, true, 'V4', date '2016-09-01', 4),
('EF', 1, true, 'P5', date '2020-09-01', 5), ('EG', 2, true, 'O5', date '2019-09-01', 5),
('EH', 3, false, 'I5', date '2018-09-01', 5), ('EJ', 4, true, 'J5', date '2017-09-01', 5),
('EI', 5, true, 'K5', date '2016-09-01', 5);