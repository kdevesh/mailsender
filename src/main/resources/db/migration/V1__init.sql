CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS customer (
    id         uuid NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName  VARCHAR NOT NULL,
    lastName   VARCHAR,
    email      VARCHAR NOT NULL,
    hasClicked BOOLEAN NOT NULL
);