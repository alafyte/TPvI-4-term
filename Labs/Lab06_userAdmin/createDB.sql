
create table users3 (
                      id int primary key identity(1, 1),
                      password nvarchar(20),
                      role nvarchar(20)
                   );

insert into users3 (password, role)
values ('123456', 'ADMIN'),
       ('123456', 'USER');