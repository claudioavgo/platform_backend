CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    phone TEXT NOT NULL,
    balance INT NOT NULL DEFAULT 0,
    password TEXT NOT NULL,
    created_at DATE NOT NULL DEFAULT now()
)