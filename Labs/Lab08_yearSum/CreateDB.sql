
create table task (
                       id int primary key identity(1, 1),
                       task_sum int,
                       task_year int
);

insert into task (task_sum, task_year)
values  (100, 2016),(-100, 2019),(3, 2022);