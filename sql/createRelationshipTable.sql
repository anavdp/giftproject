create table relationship
(
    id                integer  not null,
    creation_date     datetime not null,
    modification_date datetime,
    relationship_type varchar(255),
    usera_id          integer  not null,
    userb_id          integer  not null,
    primary key (id)
);

alter table relationship add constraint FK86ebmrc6qrp5a17lmkq3qdadl foreign key (usera_id) references user (id);
alter table relationship add constraint FKsc1mxci4e9flq3bf06wuvhnix foreign key (userb_id) references user (id);

