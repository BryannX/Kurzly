CREATE TABLE urls (
  id SERIAL PRIMARY KEY,
  "originalUrl" varchar NOT NULL,
  "shortUrl" varchar NOT NULL
);
