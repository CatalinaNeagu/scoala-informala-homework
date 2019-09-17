drop database `school`;

create database `school`;
use `school`;

create table `classes` (
classid int, 
courseid int, 
days int, 
starttime time, 
endtime time, 
bldg varchar(64), 
roomnum int,
primary key(courseid));

create table `courses` (
courseid int, 
area varchar(64), 
title varchar(64), 
descrip varchar(64), 
prereqs int,
foreign key(courseid) references classes (courseid));


create table `crosslistings` (
courseid int,
dept varchar(64), 
coursenum int,
foreign key(courseid) references courses(courseid));

create table `coursesprofs` (
courseid int,
profid int,
primary key(profid),
foreign key(courseid) references courses(courseid));

create table `profs` (
profid int,
profname varchar(64),
foreign key(profid) references coursesprofs(profid));

insert into `classes`
values (1, 3, 10, "16:00", "17:00", "A", 12);
insert into `classes`
values (2, 5, 4, "15:00", "16:00", "C2", 12);

insert into `courses` 
values ( 3, "Engineering", "Math", "Mathematics", 4);
insert into `courses`
values ( 5, "Programming", "Intro in IT", "HTML, CSS, JavaScript", 20);
insert into `courses` 
values ( 3, "Programming", "Intro in SQL", "MySQL", 20);
insert into `crosslistings`
values (3, "Cos", 35);
insert into `crosslistings` 
values (5, "Cos", 4);
insert into `coursesprofs`
values (3, 10);
insert into `profs`
values (10, "Cosmin");


select * from classes;
select * from courses where courseid = 3;
select * from classes join courses on classes.courseid = courses.courseid where lower(courses.title) like "intro%";
select * from classes join crosslistings on classes.courseid = crosslistings.courseid where lower(crosslistings.dept) = "cos" and crosslistings.coursenum like "3%";
select * from classes 
join coursesprofs on classes.courseid = coursesprofs.courseid 
join profs on profs.profid = coursesprofs.profid where lower(profs.profname) like "cos%"; 

