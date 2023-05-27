USE Lab09
CREATE TABLE Timetable (
	ClassId int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	ClassName nvarchar (150) NOT NULL,
	ClassDay nvarchar (20) NOT NULL,
	ClassHours nvarchar (15) NOT NULL,
)


