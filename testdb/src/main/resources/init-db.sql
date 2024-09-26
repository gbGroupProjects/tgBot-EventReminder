
INSERT INTO category(category_id, category_name) VALUES (1, 'День рождения');
INSERT INTO category(category_id, category_name) VALUES (2, 'Праздник');
INSERT INTO category(category_id, category_name) VALUES (3, 'Надо платить');
INSERT INTO category(category_id, category_name) VALUES (4, 'Запросить данные');
INSERT INTO category(category_id, category_name) VALUES (5, 'Контроль чего-то');
INSERT INTO category(category_id, category_name) VALUES (6, 'Прочее');

INSERT INTO user(user_id, user_name , telegram_id) VALUES (1, 'Vladimir Runov', 1915453131);
INSERT INTO user(user_id, user_name , telegram_id) VALUES (2, 'Vlad',           284401506);


INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2022-02-14', 2, 'день Валентина!');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2011-02-13', 1, 'др. Коли');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2011-09-04', 3, 'счета ПЭС');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2022-12-04', 6, 'счета DD');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2022-07-22', 4, 'оплата кредита');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2022-04-24', 6, 'звонок коллектора');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '1972-07-04', 6, 'паша!!');
INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (1,1915453131, '2022-02-14', 2, 'день Валентина!');

INSERT INTO event( user_id, telegram_id, date, category_id, comment) VALUES (2,284401506,  '1972-05-19', 1, 'др.');
