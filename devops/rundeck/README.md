# Rundeck

## Why Rundeck?

Rundeck supports SRE work by reducing TOIL.

TOIL is repetitive manual work that is necessary for the system but does not provide long term value.

Rundeck is useful for workload automation and for orchestrating procedures.

You can execute jobs manually, schedule them, or trigger them from other systems.

## How it works

### Projects

Projects are workspaces inside Rundeck.

### Jobs

Jobs are the workflows that you define and execute.

### Steps

Steps are the individual actions inside a job.

Examples:

1. Execute a command
2. Run a script
3. Use a plugin

### Nodes

Nodes are the remote endpoints where a step can run.

Examples:

1. Physical machines
2. Virtual machines
3. Containers
4. Databases

## Getting Started

Create a container:

```sh
docker run -d \
  --name rundeck \
  -p 4440:4440 \
  -v data:/home/rundeck/server/data \
  rundeck/rundeck:4.14.0
```

Open it in the browser:

```txt
http://localhost:4440
```

## Ansible vs Rundeck

### Ansible

Ansible is a configuration management tool focused on automation.

With Ansible you define tasks or playbooks that describe the desired state of your infrastructure.

You execute these playbooks using the Ansible CLI, or by integrating Ansible into other tools.

Ansible usually works in a push model. The control machine pushes configuration or commands to target machines over SSH.

Common uses:

1. Software installation
2. Configuration management
3. Application deployment

### Rundeck

Rundeck is an operations automation tool with a web interface.

With Rundeck you define jobs that contain one or more steps.

Users can trigger jobs manually from the UI, schedule them, or call them through the API.

Rundeck can execute tasks on remote machines, but it can also run tasks on the Rundeck server itself.

Common uses:

1. Ad hoc command execution
2. Job scheduling
3. Workflow orchestration
4. Giving controlled operational actions to a team

## Summary

Ansible is stronger when the goal is configuration management and desired state.

Rundeck is stronger when the goal is a central place to run operational jobs, schedule them, and give people a safer button to execute known procedures.
