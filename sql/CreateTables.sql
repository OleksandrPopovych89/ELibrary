DROP SCHEMA IF EXISTS library;
CREATE SCHEMA IF NOT EXISTS library;

CREATE TABLE IF NOT EXISTS library.roles
(
    role_id   INT PRIMARY KEY NOT NULL,
    role_name VARCHAR(15)     NOT NULL
);

INSERT INTO library.roles (role_id, role_name)
VALUES (1, 'Admin'),
       (2, 'Librarian'),
       (3, 'Reader');

CREATE TABLE IF NOT EXISTS library.users
(
    user_id          INT PRIMARY KEY AUTO_INCREMENT,
    user_email       VARCHAR(50) NOT NULL,
    user_password    VARCHAR(50) NOT NULL,
    user_pone_number VARCHAR(18) NOT NULL,
    user_firstname   VARCHAR(50) NOT NULL,
    user_lastname    VARCHAR(50) NOT NULL,
    user_role_id     INT,
    user_is_blocked  BOOLEAN,
    FOREIGN KEY (user_role_id) REFERENCES library.roles (role_id)
);

INSERT INTO library.users (user_email, user_password, user_pone_number, user_firstname, user_lastname, user_role_id,
                           user_is_blocked)
VALUES ('ap@gmail.com', '12345678', '+380-66-689-76-00', 'Олександр', 'Попович', '1', false),
       ('vs@gmail.com', '12345678', '+380-99-000-55-00', 'Валентина', 'Степанова', '2', false),
       ('sn@gmail.com', '12345678', '+380-67-111-66-00', 'Cергій', 'Нікітенко', '2', false),
       ('vdp@gmail.com', '12345678', '+380-67-333-44-00', 'Віталій', 'Дрозд', '3', false),
       ('ms@gmail.com', '12345678', '+380-50-222-999-11', 'Микита', 'Шевченко', '3', false);

CREATE TABLE IF NOT EXISTS library.books
(
    book_id             INT PRIMARY KEY AUTO_INCREMENT,
    book_title          VARCHAR(50)               NOT NULL,
    author_name         VARCHAR(50)               NOT NULL,
    publisher_name      VARCHAR(50)               NOT NULL,
    isbn                VARCHAR(30)               NOT NULL,
    date_of_publication INT                       NOT NULL,
    quantity            INT CHECK (quantity >= 0) NOT NULL
);

INSERT INTO library.books (isbn, book_title, author_name, publisher_name, date_of_publication, quantity)
VALUES ('978-966-03-6330-4', 'Книга джунглів', 'Фоліо', 'Редьярд Кіплінг', 2013, 5),
       ('978-966-942-796-0', 'Фактор Черчилля: Як одна людина змінила історію', 'Джонсон Борис', 'Vivat', 2019, 4),
       ('978-617-095-285-1', 'Чистий код', 'Роберт С. Мартін', 'Фабула', 2019, 8),
       ('978-617-095-286-8', 'Чиста архітектура', 'Роберт С. Мартін', 'Фабула', 2019, 6),
       ('978-617-09-7933-9', 'Привид Києва', 'Мацуда Джюко', 'Ранок', 2022, 16);

CREATE TABLE IF NOT EXISTS library.orders
(
    order_id           INT PRIMARY KEY AUTO_INCREMENT,
    user_id            INT,
    book_id            INT,
    subscription_type_id  INT,
    order_status_id       INT,
    order_created_time DATETIME NOT NULL,
    return_deadline    DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES library.users (user_id),
    FOREIGN KEY (book_id) REFERENCES library.books (book_id)
);

INSERT INTO library.orders (user_id, book_id, subscription_type_id, order_status_id, order_created_time, return_deadline)
VALUES (1, 1, 1, 1, '2023-01-02 22:12:33', '2023-04-29 22:12:35');