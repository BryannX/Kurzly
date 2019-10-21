# Kurzly
Create short and simple URLs that are easy to use.

## Tech Stack
<b>Built with</b>
- [Scala](https://www.scala-lang.org/)
- [Play! Framework](https://www.playframework.com/) 
- [PostgresSQL](https://www.postgresql.org/) 
- [Slick](http://slick.lightbend.com/) 
- [Docker](https://www.docker.com/)
- [Postman](https://www.getpostman.com/)

## Run
`cd urlshortenerservice/` to enter the app's main directory.

```sh
docker-compose up
```
This will start up the `api` and the `postgresql` database and expose the api port to host on `localhost:9000/`.

## Usage
The following commands can be ran from a browser or an API client like `Postman`. For this example, we shall use the url `https://www.google.com`.


```sh
# Shorten url
http://localhost:9000/shorten/https://www.google.com

# Return original url
http://localhost:9000/geturl/f

# Redirect to original url
http://localhost:9000/go/f

 ```

## Features
* Provides a unique id across past and concurrent requests, and multiple backend service instances.
* ID length max is 6 characters while still providing over `2,000,000,000` unique addresses.
* Uses asynchronous operation allowing the application to be reactive, scalable and concurrent.
* Persists data with `Postgresql` database.

## Algorithm
The algorithm for creating the short url leverages the sequential index provided by the database to create a short url id. The index returned by the database upon insertion of the url into the database is reiteratively moded by 62 into a list which is then mapped with a **base62 conversion** to an ASCII character from the subset `[a-z,A-Z,0-9]`. The returned character list forms the short url id.

## Requirements
- Docker
- Docker-Compose

## Tests
Automated API testing was conducted with Postman with test scripts and CSV files available in the `ApiTests` folder. 


