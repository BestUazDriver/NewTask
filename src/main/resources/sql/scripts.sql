create table accounts (
                          id serial primary key,
                          role varchar(20),
                          email varchar(50),
                          name varchar(20),
                          surname varchar(20)
);
insert into accounts (role, email, name, surname) VALUES ('admin', 'Sabitov.daniyar18@mail.ru', 'Daniyar', 'Sabitov'),
                                                    ('user', 'ex@mail.ru', 'Lana','Del Rey'),
                                                    ('user', 'sing@yandex.com', 'Grey', 'Headfrozen');
drop table accounts