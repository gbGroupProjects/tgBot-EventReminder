DROP TABLE IF EXISTS "pgBot".event;
DROP TABLE IF EXISTS "pgBot".user;
DROP TABLE IF EXISTS "pgBot".category;

CREATE TABLE IF NOT EXISTS "pgBot".category
(
    category_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    category_name VARCHAR(20) NOT NULL,
    bAct boolean NOT NULL DEFAULT true,
    CONSTRAINT category_pk PRIMARY KEY (category_id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS "pgBot".category OWNER to postgres;
COMMENT ON TABLE "pgBot".category    IS 'test...';

CREATE TABLE "pgBot".user
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    telegram_id integer NOT NULL,
    user_name VARCHAR(64) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS "pgBot".user OWNER to postgres;
COMMENT ON TABLE "pgBot".user    IS 'user...';

CREATE TABLE "pgBot".event
(
    event_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    category_id integer NOT NULL,
    date DATE NOT NULL,
    comment VARCHAR(20) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    regular BOOLEAN NOT NULL DEFAULT FALSE,
    daysIn INT NOT NULL DEFAULT 0,

    CONSTRAINT event_pk PRIMARY KEY (event_id),
    CONSTRAINT event_category_fk FOREIGN KEY (category_id) REFERENCES category (category_id)
);

INSERT INTO "pgBot".category(category_name) VALUES ( 'День рождения');
INSERT INTO "pgBot".category(category_name) VALUES ( 'Праздник');
INSERT INTO "pgBot".category(category_name) VALUES ( 'Надо платить');
INSERT INTO "pgBot".category(category_name) VALUES ( 'Запросить данные');
INSERT INTO "pgBot".category(category_name) VALUES ( 'Контроль чего-то');
INSERT INTO "pgBot".category(category_name) VALUES ( 'Прочее');

INSERT INTO "pgBot".user( user_name , telegram_id) VALUES ( 'Vladimir Runov', 1915453131);

INSERT INTO "pgBot".event( user_id, date, category_id, comment) VALUES (1, '2022-02-14', 2, 'день Валентина!');
INSERT INTO "pgBot".event( user_id, date, category_id, comment) VALUES (1, '2011-02-13', 1, 'др. Коли');
INSERT INTO "pgBot".event( user_id, date, category_id, comment) VALUES (1, '2011-09-04', 3, 'счета ПЭС');
INSERT INTO "pgBot".event( user_id, date, category_id, comment) VALUES (1, '2022-12-04', 3, 'счета DD');
INSERT INTO "pgBot".event( user_id, date, category_id, comment) VALUES (1, '2022-07-22', 3, 'оплата кредита');
INSERT INTO "pgBot".event( user_id, date, category_id, comment) VALUES (1, '2022-04-24', 5, 'звонок коллектора');
