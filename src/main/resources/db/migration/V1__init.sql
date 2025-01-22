CREATE TABLE entities
(
    id          SERIAL PRIMARY KEY,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);