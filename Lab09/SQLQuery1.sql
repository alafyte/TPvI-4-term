create table Users
(
	ID int identity(1, 1) PRIMARY KEY,
	User_Login nvarchar(50) NOT NULL,
	User_Password nvarchar(50) NOT NULL,
	User_Role nvarchar(10) NOT NULL
)
insert into Users ([ID], [User_Login], [User_Password], [User_Role]) VALUES (1, N'admin', N'⌡⤯坺ꞥ襃๊聊쌟', N'admin')
insert into Users ([ID], [User_Login], [User_Password], [User_Role]) VALUES (18, N'user1', N'줤廡꽒糄嬢繵鴟', N'user')