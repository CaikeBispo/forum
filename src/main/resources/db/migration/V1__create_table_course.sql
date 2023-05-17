create table if not exists course (
    id bigint not null,
    name varchar,
    category varchar,
    primary key (id)

);

insert into course values (1, 'Java', 'Development');