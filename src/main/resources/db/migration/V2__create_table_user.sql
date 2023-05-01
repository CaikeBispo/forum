create table if not exists users (
    id bigint not null,
    name varchar  not null,
    email varchar  not null,
    primary key (id)

);

insert into users values (1, 'Ingrid Bispo', 'ingrid@bispo.co.uk');