create table users
(
    id               uuid primary key,
    version          int         not null,
    name             text        not null,
    first_name       text,
    last_name        text,
    email            text        not null,
    created_at       timestamptz not null,
    last_modified_as timestamptz not null
);

create table companies
(
    id               uuid primary key,
    version          int         not null,
    name             text        not null,
    city             text,
    created_at       timestamptz not null,
    last_modified_as timestamptz not null
);

create table jobs
(
    id               uuid primary key,
    version          int         not null,
    title            text        not null,
    start_date       date        not null,
    end_date         date,
    created_at       timestamptz not null,
    last_modified_as timestamptz not null,
    company_id       uuid        not null references companies (id),
    user_id          uuid        not null references users (id)
);

create table wages
(
    id               uuid primary key,
    version          int         not null,
    wage_per_hour    int         not null,
    currency         text        not null,
    work_hours       int         not null,
    paid_holidays    int         not null,
    start_date       date        not null,
    end_date         date,
    created_at       timestamptz not null,
    last_modified_as timestamptz not null,
    job_id           uuid references jobs (id)
)