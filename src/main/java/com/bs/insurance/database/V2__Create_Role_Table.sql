CREATE TABLE auth.role
(
    id BIGSERIAL PRIMARY KEY,

    role_name VARCHAR(50) NOT NULL,

    description VARCHAR(255),

    active BOOLEAN DEFAULT TRUE,

    created_by VARCHAR(100),

    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_by VARCHAR(100),

    updated_date TIMESTAMP
);
