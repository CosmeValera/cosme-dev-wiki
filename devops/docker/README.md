# Docker

## What is Docker?

Docker lets you package an app with the dependencies it needs to run. The main idea is that the app can run the same way in different environments.

### Image

An image is a template. It is used to create containers and it does not change while it is being used.

Images are usually defined with a `Dockerfile`. They are built in layers, so one image can be based on another image.

### Container

A container is a running instance of an image.

It is lightweight and portable. It contains the app and its dependencies, so the app can run consistently in any environment where Docker is available.

### Base image

A base image is the first layer used to build a Docker image.

If you want to start from nothing, you can use:

```dockerfile
FROM scratch
```

### Docker manifest

A Docker image also includes a manifest.

The manifest is a JSON description of the image. It references the layers and metadata needed to run it.

## Useful Docker commands

| Command | What it does |
| --- | --- |
| `docker images` | List Docker images |
| `docker ps` | List running containers |
| `docker ps -a` | List all containers |
| `docker pull <image>` | Download an image |
| `docker push <image>` | Upload an image |
| `docker build` | Build an image from a Dockerfile |
| `docker tag` | Add a name or version to an image |
| `docker rmi <image>` | Remove an image |
| `docker rm <container>` | Remove a container |
| `docker history <image>` | See image layers |
| `docker save <image>` | Save an image to a tar file |
| `docker load -i <tar-file>` | Load an image from a tar file |

## Docker registries

Docker registries store Docker images.

Examples:

1. Docker Cloud
2. Docker Hub
3. GitHub Docker registry
4. Private registry

## Docker volumes

Volumes are used to persist data or share data between a container and the host.

Default places:

```txt
Linux: /var/lib/docker/volumes
Windows: C:\ProgramData\Docker
```

## Dockerfile

A `Dockerfile` is a text file with the instructions needed to create an image.

With this command Docker builds the image:

```sh
docker build --tag node-docker .
```

### Dockerfile instructions

| Instruction | What it does |
| --- | --- |
| `FROM` | Sets the base image |
| `ENV` | Sets environment variables |
| `USER` | Changes the user |
| `RUN` | Executes a command while building |
| `ADD` | Copies files or directories |
| `EXPOSE` | Documents the port used by the app |

## Example with PostgreSQL

Download the image:

```sh
docker pull postgres
docker pull postgres:bullseye
```

Create a container:

```sh
docker run --name postgres -e POSTGRES_PASSWORD=password -d postgres:bullseye
```

See logs:

```sh
docker logs postgres
```

Open a shell inside the container:

```sh
docker exec -it postgres sh
psql -U postgres
```

Create a small table:

```sql
CREATE TABLE example (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO example (name) VALUES ('John');

SELECT * FROM example;
```

## Node Docker example

### .dockerignore

Use `.dockerignore` to avoid copying things like `node_modules` into the Docker build context.

Example:

```txt
node_modules
```

Build the image:

```sh
docker build --tag node-docker .
docker images
```

Create a tag:

```sh
docker tag node-docker:latest node-docker:v1.0.0
```

Remove the tag:

```sh
docker rmi node-docker:v1.0.0
```

Run the image:

```sh
docker run node-docker
docker run --publish 8000:8000 node-docker
docker run -dp 8000:8000 node-docker
```

Create a stopped container and see why it failed:

```sh
docker run -d postgres:bullseye
docker logs <container-id>
```

In this case it fails because PostgreSQL needs a password.

Create it correctly and stop it:

```sh
docker run --name post -e POSTGRES_PASSWORD=password -d postgres:bullseye
docker stop post
```

Restart a container:

```sh
docker restart <container-id>
```

## Docker Compose

Docker Compose lets you define and run apps that need more than one container.

You define the services, networks and volumes in a YAML file.

### Mongo example

```sh
docker volume create mongodb
docker volume create mongodb_config
docker network create mongodb

docker run -it --rm -d \
  -v mongodb:/data/db \
  -v mongodb_config:/data/configdb \
  -p 27017:27017 \
  --network mongodb \
  --name mongodb \
  mongo
```

Build the Node image and connect it to the Mongo network:

```sh
docker build --tag node-docker .

docker run -it --rm -d \
  --network mongodb \
  --name rest-server \
  -p 8000:8000 \
  -e CONNECTIONSTRING=mongodb://mongodb:27017/notes \
  node-docker
```

Run with Compose:

```sh
docker compose -f docker-compose.dev.yml up --build
```

## Example files

### Dockerfile

```dockerfile
# syntax=docker/dockerfile:1

FROM node:18-alpine
ENV NODE_ENV=production

WORKDIR /app

COPY ["package.json", "package-lock.json", "./"]

RUN npm install --production

COPY . .

CMD [ "node", "server.js" ]
```

### docker-compose.yml

```yaml
version: '3.0'

services:
  notes:
    build:
      context: .
    ports:
      - 8000:8000
      - 9229:9229
    environment:
      - SERVER_PORT=8000
      - CONNECTIONSTRING=mongodb://mongo:27017/notes
    volumes:
      - ./:/app
      - /app/node_modules
    command: npm run debug

  mongo:
    image: mongo:4.2.8
    ports:
      - 27017:27017
    volumes:
      - mongodb:/data/db
      - mongodb_config:/data/configdb

volumes:
  mongodb:
  mongodb_config:
```
