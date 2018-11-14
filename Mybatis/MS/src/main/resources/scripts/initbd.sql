create table users
(
  user_id         serial       not null
    constraint users_pkey
    primary key,
  user_first_name varchar(255) not null,
  user_last_name  varchar(255) not null,
  user_name       varchar(255) not null,
  password        varchar(255) not null,
  email           varchar(255) not null,
  is_active       boolean      not null
);

create table user_roles
(
  roles_id  serial      not null
    constraint user_roles_pkey
    primary key,
  user_id   integer     not null
    constraint user_roles_users_user_id_fk
    references users
    on update cascade on delete cascade,
  authority varchar(45) not null
);
