DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;

CREATE TABLE category
(
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(20) UNIQUE,
  CONSTRAINT category_pk PRIMARY KEY (category_id)
);

CREATE TABLE user
(
  user_id INT NOT NULL AUTO_INCREMENT,
  telegram_id INT NOT NULL,
  user_name VARCHAR(64) UNIQUE,
  CONSTRAINT user_pk PRIMARY KEY (user_id)
);

CREATE TABLE event
(
  event_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  category_id INT NOT NULL,
  date DATE NOT NULL,
  active INT NOT NULL DEFAULT 0,
  regular INT NOT NULL DEFAULT 0,
  daysIn INT NOT NULL DEFAULT 0,

  comment VARCHAR(20) NOT NULL,

    CONSTRAINT event_pk PRIMARY KEY (event_id),
    CONSTRAINT event_category_fk FOREIGN KEY (category_id) REFERENCES category (category_id)
);