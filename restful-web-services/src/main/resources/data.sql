insert into user_details(id, birth_date,name)
values(10001, current_date(), 'Duc');

insert into user_details(id, birth_date,name)
values(10002, current_date(), 'An');

insert into user_details(id, birth_date,name)
values(10003, current_date(), 'Tung');

insert into post(id,description,user_id)
values(20001,'I want to 650 point toeic', 10001);

insert into post(id,description,user_id)
values(20002,'I want to learn backend', 10001);

insert into post(id,description,user_id)
values(20003,'I want to learn frontend', 10002);