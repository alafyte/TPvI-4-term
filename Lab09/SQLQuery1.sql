create table Users
(
	ID int identity(1, 1) PRIMARY KEY,
	User_Login nvarchar(50) NOT NULL,
	User_Password nvarchar(50) NOT NULL,
	User_Role nvarchar(10) NOT NULL
)
insert into Users (User_Login, User_Password, User_Role) values ('admin', 'admin', 'admin');
insert into Users (User_Login, User_Password, User_Role) values ('user11', 'user11', 'user');