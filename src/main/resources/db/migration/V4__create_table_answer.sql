create table if not exists answer (
    id bigint not null,
    message varchar  not null,
    dt_criation datetime  not null,
    topic_id bigint not null,
    author_id bigint not null,
    solution int not null,
    primary key (id),
    foreign key (topic_id) references topic(id),
    foreign key (author_id) references users(id)

);
