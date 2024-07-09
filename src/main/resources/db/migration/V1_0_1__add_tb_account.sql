CREATE TABLE IF NOT EXISTS account (
    id              UUID                DEFAULT uuid_generate_v4(),
    username        VARCHAR(255),
    password        VARCHAR(255),
    nickname        VARCHAR(255),

    status          VARCHAR(255),
    created_at      TIMESTAMP           DEFAULT now(),
    updated_at      TIMESTAMP,

    CONSTRAINT pk_account PRIMARY KEY (id),
    CONSTRAINT uq_account_username UNIQUE (username),
    CONSTRAINT uq_account_nickname UNIQUE (nickname)
);