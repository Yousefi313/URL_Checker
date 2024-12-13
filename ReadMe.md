# URL Status Checker API

This project provides a simple REST API to check whether a website URL is up or down. The controller accepts a URL, performs an HTTP request to it, and returns a response indicating the status of the site.

## Features
- The API checks the availability of a provided URL.
- It returns a message indicating whether the website is up, down, or if the URL is incorrect.
  
## Endpoint

### `GET /check`

This endpoint accepts a URL as a query parameter and checks if the site is accessible.

**Request Parameter:**
- `url` (required): The URL to check. It should be a valid, fully qualified URL (e.g., `http://example.com`).

**Response:**
- `"Site is up!"`: If the website is accessible and returns a successful HTTP response (2xx or 3xx status code).
- `"Site is down!"`: If the website is inaccessible or returns an error status code (4xx or 5xx).
- `"URL is incorrect!"`: If the provided URL is malformed or invalid.

## Example Usage

### 1. Check if a website is up:

**Request:**
```http
GET /check?url=http://example.com
```

**Response:**
Site is up!

### 2. Check if a website is down:

**Request:**
```http
GET /check?url=http://nonexistentwebsite.com
```
**Response:**
Site is down!

### 3. Handle incorrect URL:
**Request:**
``` http
GET /check?url=htp://invalid-url
```
**Response:**
URL is incorrect!