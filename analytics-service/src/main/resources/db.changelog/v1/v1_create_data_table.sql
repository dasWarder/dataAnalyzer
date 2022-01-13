DROP TABLE IF EXISTS data_info;
DROP SEQUENCE IF EXISTS data_seq;

CREATE SEQUENCE data_seq START WITH 1;

CREATE TABLE data_info (
    id BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('data_seq'),
    data_id VARCHAR NOT NULL UNIQUE,
    author VARCHAR NOT NULL,
    message VARCHAR NOT NULL,
    creating_date TIMESTAMP NOT NULL,
    processing_date TIMESTAMP NOT NULL
);