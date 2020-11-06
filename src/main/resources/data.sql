INSERT INTO Genre (id, genre_name) VALUES (1, 'Classic');
INSERT INTO Genre (id, genre_name) VALUES (2, 'Novel');
INSERT INTO Genre (id, genre_name) VALUES (3, 'Horror');

INSERT INTO Author (id, author_name) VALUES (1, 'Adam');
INSERT INTO Author (id, author_name) VALUES (2, 'Smith');
INSERT INTO Author (id, author_name) VALUES (3, 'James');

INSERT INTO User_Info (id, username, password, is_admin) VALUES (1, 'Alan', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm', true);
INSERT INTO User_Info (id, username, password, is_admin) VALUES (2, 'Steve', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm', false);

INSERT INTO Book (id, name, author_id, genre_id) VALUES (1, 'Book1', 1, 1);
INSERT INTO Book (id, name, author_id, genre_id) VALUES (2, 'Book2', 1, 2);
INSERT INTO Book (id, name, author_id, genre_id) VALUES (3, 'Book3', 2, 1);
INSERT INTO Book (id, name, author_id, genre_id) VALUES (4, 'Book4', 3, 2);
INSERT INTO Book (id, name, author_id, genre_id) VALUES (5, 'Book5', 3, 3);

INSERT INTO Comment (id, msg, book_id, user_info_id) VALUES (1, 'Nice book!', 1, 2);
INSERT INTO Comment (id, msg, book_id, user_info_id) VALUES (2, 'So so', 1, 1);
INSERT INTO Comment (id, msg, book_id, user_info_id) VALUES (3, 'Pretty well', 2, 1);
INSERT INTO Comment (id, msg, book_id, user_info_id) VALUES (4, 'Too bad', 3, 1);
INSERT INTO Comment (id, msg, book_id, user_info_id) VALUES (5, 'Good job', 4, 1);
INSERT INTO Comment (id, msg, book_id, user_info_id) VALUES (6, 'I like it!', 4, 2);