# Grafana and Docker

## What is Grafana?

Grafana is used to create dashboards and visualize metrics, logs and traces.

The usual flow is:

```txt
Data source -> Query -> Panel -> Dashboard
```

## Docker

### Watch processes

```sh
docker ps -a
```

### Remove container `grafana`

```sh
docker stop grafana
docker rm grafana
```

### Create container `grafana`

```sh
docker run -d --name=grafana -p 3122:3000 grafana/grafana-oss
```

Access it here:

```txt
http://localhost:3122
```

Default credentials:

```txt
User: admin
Password: admin
```

### Start a container `grafana`

```sh
docker start grafana
```

### Execute a container `grafana`

```sh
docker exec -it grafana /bin/bash
```

## Allow embedding

To be able to embed Grafana panels in another app, execute the container as root and change the config:

```bash
docker exec -it -u 0 grafana bash
cd conf
sed -i '/allow_embedding = false/c\allow_embedding = true' defaults.ini
```

> For a real setup, it is better to use environment variables or mounted config files instead of editing files inside the running container.

## Windows Grafana

If you install Grafana with the Windows installer, go here:

```txt
C:\Program Files\GrafanaLabs\grafana\bin
```

Run:

```txt
grafana-server.exe
```
