create table parking
(
    id bigserial not null,
    userId bigserial not null,
    bookedFrom timestamp,
    bookedTo timestamp,
    deleted timestamp,
    primary key(id)
--     constraint uidx_parking_code unique (code)
);

create index idx_parking_userId on parking (userId);
create index idx_parking_deleted on parking (deleted);
