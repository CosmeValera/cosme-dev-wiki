# Nginx

## What is Nginx?

Nginx can work as a proxy server or as a web server.

Common uses:

1. Load balancing
2. Caching
3. Security
4. Compression
5. Serving static files
6. Reverse proxy for backend services

The configuration file is usually called `nginx.conf`.

In Linux it is usually placed here:

```txt
/etc/nginx
```

## Web server example

```nginx
server {
    listen 80;
    server_name example.com www.example.com;

    location / {
        root /var/www/example.com;
        index index.html index.htm;
    }
}
```

This serves HTML directly on HTTP port 80.

For real apps, usually we want HTTPS and a reverse proxy in front of the application.

## Reverse proxy idea

A common setup is:

```txt
Browser
  |
  v
Nginx
  |
  v
App server
```

Nginx receives the request, applies the proxy rules, and forwards the request to the internal app.

Example:

```nginx
server {
    listen 80;
    server_name example.com;

    location / {
        proxy_pass http://localhost:3000;
    }
}
```

## Load balancing

For load balancing, Nginx uses `upstream`.

```nginx
http {
    upstream myapp1 {
        server srv1.example.com;
        server srv2.example.com;
        server srv3.example.com;
    }

    server {
        listen 80;

        location / {
            proxy_pass http://myapp1;
        }
    }
}
```

By default, Nginx uses round robin.

Example:

```txt
Request 1 goes to server 1
Request 2 goes to server 2
Request 3 goes to server 3
Request 4 goes to server 1
```

You can also use the server with fewer active connections:

```nginx
upstream myapp1 {
    least_conn;
    server srv1.example.com;
    server srv2.example.com;
    server srv3.example.com;
}
```

## Nginx and Kubernetes

Nginx can also be used as a Kubernetes Ingress controller.

The idea is similar to the reverse proxy example:

```txt
Browser
  |
  v
Ingress Controller
  |
  v
Kubernetes Service
  |
  v
Pod
```

## Apache vs Nginx

| Apache | Nginx |
| --- | --- |
| Created in 1994 | Created in 2004 |
| Highly customizable | Faster and more lightweight |
| Good for dynamic content and legacy support | Good for static content and proxy setups |
| Configuration can be harder | Configuration is usually simpler |
| Classic server world | Very popular in containers |
