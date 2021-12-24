create schema if not exists playground;

select * from playground.parent_table;
select * from playground.child_table;

-- set search_path to playground
CREATE TABLE IF NOT EXISTS PARENT_TABLE
(
    par_id      serial primary key,
    username    varchar not null,
    modify_date timestamp default now(),
    insert_date timestamp      not null
);

CREATE TABLE IF NOT EXISTS CHILD_TABLE
(
    chi_id      serial primary key,
    par_par_id  integer null ,
    username    varchar not null,
    modify_date timestamp default now(),
    insert_date timestamp      not null
);

ALTER TABLE child_table
    ADD CONSTRAINT fk_child_table_par_par_id FOREIGN KEY (par_par_id) REFERENCES parent_table (par_id);
