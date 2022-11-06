insert into roles (name) values ('Role 1'), ('Role 2'), ('Role 3'), ('Role 4'), ('Role 5');
insert into users (name, role_id) values ('User 1', 5), ('User 2', 4), ('User 3', 3), ('User 4', 2), 
('User 5', 1);
insert into users (name) values ('User 6'), ('User 7');
insert into rules (name) values ('Rule 1'), ('Rule 2'), ('Rule 3');
insert into roles_rules (role_id, rule_id) values (1, 1), (1, 2), (2, 1), (2, 3), (3, 2), 
(4, 3), (5, 2), (5, 3);

insert into states (name) values ('Accepted'), ('Rejected');
insert into categories (name) values ('Category 1'), ('Category 2'), ('Category 3');

insert into items (name, state_id, category_id, user_id) values ('Item 1', 1, 1, 1), ('Item 2', 1, 2, 2), 
('Item 3', 2, 3, 3), ('Item 4', 2, 1, 4), ('Item 5', 1, 2, 5), ('Item 6', 1, 3, 6), 
('Item 7', 1, 2, 7), ('Item 8', 2, 2, 1), ('Item 9', 2, 3, 2), ('Item 10', 2, 1, 3);

insert into comments (name, item_id) values ('Comment 1', 1), ('Comment 2', 2), ('Comment 3', 3),
('Comment 1', 4), ('Comment 2', 5), ('Comment 3', 6), ('Comment 1', 7), 
('Comment 2', 8), ('Comment 3', 9), ('Comment 1', 10);

insert into attachments (name, item_id) values ('Attachment 1', 1), ('Attachment 2', 2), ('Attachment 3', 3), 
('Attachment 4', 4), ('Attachment 5', 1), ('Attachment 6', 2), ('Attachment 7', 3);

