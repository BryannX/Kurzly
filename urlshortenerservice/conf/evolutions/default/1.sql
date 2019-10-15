# --- !Ups

create table urls (
  "id" SERIAL PRIMARY KEY,
  "originalUrl" varchar NOT NULL,
  "shortUrl" varchar NOT NULL
);

# --- !Downs

drop table urls if exists;
