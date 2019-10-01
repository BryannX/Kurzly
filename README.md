# Coding Challenge

URL shortener HTTP service.

## Problem Specification

Design and implement a URL shortener HTTP service that fulfils the following criteria:

* Provides an HTTP API to:
  * Shorten a URL
  * Redirect to the long URL from the shortened URL
* Shortened URL requirements:
  * The ID of the shortened URL needs to be unique (across past and concurrent requests, and multiple backend service instances)
  * Optional: The ID of the shortened URL should be as short as possible (max. 8 characters long)
  * Optional: The long/shortened URL mapping needs to be persisted and shouldn't be lost after a backend service restart

## Assessment Criteria

We expect well-structured, clean code without needless duplication. The solution should be automatically verified and follow best practices.

What we will look at:

* How clean your design and implementation is
* How easy it is to understand and maintain your code
* How you verify your software, whether by automated tests or otherwise