
create table books (
                      author nvarchar(30),
                      book_name nvarchar(30),
                      publication_year int,
                      pages int);

insert into books (author, book_name, publication_year, pages)
values  ('author1', 'book1', 2001, 1),
        ('author2', 'book2', 2002, 1),
        ('author3', 'book3', 2003, 2),
        ('author4', 'book4', 2004, 2),
        ('author5', 'book5', 2005, 3);