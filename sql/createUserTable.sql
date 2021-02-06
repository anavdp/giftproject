create table user
(
    `id`                integer      not null,
    `birthdate`         date         not null,
    `creation_date`     datetime     not null,
    `email`             varchar(255) not null,
    `gender`            varchar(255),
    `lastname`          varchar(255) not null,
    `modification_date` datetime,
    `name`              varchar(255) not null,
    `phone_number`      varchar(255),
    `pronoun`           varchar(255),
    primary key (id)
);