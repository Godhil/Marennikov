--Заполнение таблицы с книгами
INSERT INTO book(author, title, publisher, publishyear) VALUES ('Толстой Л.Н.', 'Война и мир', 'Азбука', '2016')
INSERT INTO book(author, title, publisher, publishyear) VALUES ('Булгаков М.А.', 'Белая гвардия. Театральный роман', 'Альфа-книга', '2013')
INSERT INTO book(author, title, publisher, publishyear) VALUES ('Толстой Л.Н.', 'Анна Каренина', 'Азбука', '2016' )
INSERT INTO book(author, title, publisher, publishyear) VALUES ('Булгаков М.А.', 'Мастер и Маргарита', 'book', '2006')
INSERT INTO book(author, title, publisher, publishyear) VALUES ('Полевой Б.Н.', 'Повесть о настоящем человеке', 'Детская литература', '2015')
INSERT INTO book(author, title, publisher, publishyear) VALUES ('Гоголь Н.В.', 'Ревизор. Женитьба', 'АСТ', '2009')

--Заполнение таблицы клиентов
INSERT INTO customer(fio, birthdate) VALUES ('Герасимова Лия Михайловна', '1983-06-18')
INSERT INTO customer(fio, birthdate) VALUES ('Жуков Евдоким Алексеевич', '1976-03-03')
INSERT INTO customer(fio, birthdate) VALUES ('Изофатова Берта Григорьевна', '1976-12-13')
INSERT INTO customer(fio, birthdate) VALUES ('Демьянченко Маргарита Андреевна', '1986-07-20')
INSERT INTO customer(fio, birthdate) VALUES ('Муравьёва Мария Ярославовна', '1991-12-18')
INSERT INTO customer(fio, birthdate) VALUES ('Воробьёв Даниил Константинович', '1974-06-24')

--Заполнение таблицы выданных книг
INSERT INTO issued(customer_id, book_id, out, back) VALUES (1, 1, '2016-05-03', NULL )
INSERT INTO issued(customer_id, book_id, out, back) VALUES (1, 3, '2016-01-13', '2016-01-29')
INSERT INTO issued(customer_id, book_id, out, back) VALUES (2, 3, '2016-04-28', NULL )
INSERT INTO issued(customer_id, book_id, out, back) VALUES (6, 2, '2016-02-15', '2016-05-03')
INSERT INTO issued(customer_id, book_id, out, back) VALUES (4, 5, '2016-03-11', '2016-04-15')
