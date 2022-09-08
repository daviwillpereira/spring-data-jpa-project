

insert into course(id,name,created_date,last_updated_date) values(10001,'JPA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id,name,created_date,last_updated_date) values(10002,'Spring', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id,name,created_date,last_updated_date) values(10003,'Spring Boot', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


insert into review(id,rating,description, course_id) values(30001,'FIVE','Amazing Course!', 10001);
insert into review(id,rating,description, course_id) values(30002,'FOUR','Great Course!', 10001);
insert into review(id,rating,description, course_id) values(30003,'ONE','Terrible Course!', 10003);


insert into passport(id,number) values(40001,'F123456');
insert into passport(id,number) values(40002,'E123456');
insert into passport(id,number) values(40003,'N123456');


insert into student(id,name, line1, line2, city, passport_id) values(20001,'Gohan', 'Street 1', 'number 123', 'Belém', 40001);
insert into student(id,name, line1, line2, city, passport_id) values(20002, 'Joãozinho','Street 2', 'number 124', 'São Paulo', 40002);
insert into student(id,name, line1, line2, city, passport_id) values(20003,'Chaves','Street 3', 'number 125', 'Rio de Janeiro', 40003);


insert into student_course(student_id, course_id) values(20001, 10001);
insert into student_course(student_id, course_id) values(20002, 10002);
insert into student_course(student_id, course_id) values(20003, 10001);
insert into student_course(student_id, course_id) values(20001, 10003);
