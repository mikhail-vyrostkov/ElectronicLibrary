create table Book
(
    id                 int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    person_id int REFERENCES Person(id) ON DELETE SET NULL,
    bookName           varchar(200) NOT NULL,
    first_name_author  varchar(200) NOT NULL,
    last_name_author   varchar(200) NOT NULL,
    middle_name_author varchar(200),
    year_of_publishing int CHECK ( year_of_publishing > 1500 )
)