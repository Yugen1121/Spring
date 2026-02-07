DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;
DROP SEQUENCE IF EXISTS author_id_seq;

CREATE SEQUENCE author_id_seq
    INCREMENT BY 1
    MINVALUE 1;

CREATE TABLE author (
                        id bigint DEFAULT nextval('author_id_seq') NOT NULL,
                        name text,
                        age integer,
                        CONSTRAINT author_pkay PRIMARY KEY (id)
);

CREATE TABLE books (
                       isbn text NOT NULL,
                       title text,
                       author_id bigint,
                       CONSTRAINT books_pkey PRIMARY KEY (isbn),
                       CONSTRAINT fk_author
                           FOREIGN KEY (author_id)
                               REFERENCES author(id)
);
