CREATE TABLE PLANETS (
Name nvarchar(50) NOT NULL,
Radius int NOT NULL,
Core_Temperature decimal(8,2) NOT NULL,
Have_Atmosphere bit NOT NULL,
Have_Life bit NOT NULL
CONSTRAINT PK_PLANETS PRIMARY KEY (Name)
)
CREATE TABLE SATELLITES (
Name nvarchar(50) NOT NULL,
Planet_Name nvarchar(50) NOT NULL CONSTRAINT FK_SATELLITES_Planet_Name FOREIGN KEY REFERENCES Planets(Name),
Radius int NOT NULL,
Planetary_Distance int NOT NULL,
CONSTRAINT PK_SATELLITES PRIMARY KEY (Name)
)