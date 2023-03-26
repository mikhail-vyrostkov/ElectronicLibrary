CREATE TABLE Person
(
    id         int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    firstName  varchar(100) NOT NULL,
    lastName   varchar(100) NOT NULL,
    middleName varchar(100),
    birthday   varchar(100) NOT NULL,
    email      varchar(100) NOT NULL UNIQUE,
    phone      varchar(100) NOT NULL UNIQUE,
    photo      bytea
);