CREATE TABLE IF NOT EXISTS Genre (
    id          INTEGER                         COMMENT 'Уникальный идентификатор'      PRIMARY KEY AUTO_INCREMENT,
    genre_name        VARCHAR(50) NOT NULL    UNIQUE  COMMENT 'Название жанра'
);
COMMENT ON TABLE Genre IS 'Жанр';

CREATE TABLE IF NOT EXISTS Author (
    id          INTEGER                         COMMENT 'Уникальный идентификатор'      PRIMARY KEY AUTO_INCREMENT,
    author_name VARCHAR(50) NOT NULL    UNIQUE  COMMENT 'Имя автора'
);
COMMENT ON TABLE Author IS 'Автор';

CREATE TABLE IF NOT EXISTS User_Info (
    id          INTEGER                         COMMENT 'Уникальный идентификатор'      PRIMARY KEY AUTO_INCREMENT,
    username    VARCHAR(50) NOT NULL    UNIQUE  COMMENT 'Имя пользователя',
    password    VARCHAR     NOT NULL            COMMENT 'Пароль пользователя',
    is_admin    BOOLEAN     NOT NULL            COMMENT 'Статус админа'
);
COMMENT ON TABLE User_Info IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Book (
    id          INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL    COMMENT 'Название книги',
    genre_id    INTEGER     NOT NULL    COMMENT 'Жанр',
    author_id   INTEGER     NOT NULL    COMMENT 'Автор'
);
COMMENT ON TABLE Book IS 'Книга';

CREATE TABLE IF NOT EXISTS Comment (
    id              INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    msg             VARCHAR     NOT NULL    COMMENT 'Сообщение комментария',
    book_id         INTEGER     NOT NULL    COMMENT 'Книга',
    user_info_id    INTEGER     NOT NULL    COMMENT 'Пользователь'
);
COMMENT ON TABLE Book IS 'Книга';

CREATE INDEX IX_Comment_User_Info ON Comment (user_info_id);
CREATE INDEX IX_Comment_Book_Id ON Comment (book_id);
ALTER TABLE Comment ADD FOREIGN KEY (user_info_id) REFERENCES User_Info (id);
ALTER TABLE Comment ADD FOREIGN KEY (book_id) REFERENCES Book (id);

CREATE INDEX IX_Book_Author_Id ON Book (author_id);
CREATE INDEX IX_Book_Genre_Id ON Genre (id);
ALTER TABLE Book ADD FOREIGN KEY (author_id) REFERENCES Author (id);
ALTER TABLE Book ADD FOREIGN KEY (genre_id) REFERENCES Genre (id);

CREATE INDEX UX_User_Info_Name ON User_Info (username);