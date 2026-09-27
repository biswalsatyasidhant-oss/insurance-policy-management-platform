CREATE TABLE auth.user
(
    id BIGSERIAL PRIMARY KEY,

    username VARCHAR(100),

    password VARCHAR(255),

    role_id BIGINT,

    CONSTRAINT fk_role
        FOREIGN KEY(role_id)
        REFERENCES auth.role(id)
);

ALTER TABLE auth.user
ADD CONSTRAINT uk_username UNIQUE(username);