# Microfrontends

Practicing microfrontends with different setups, hosts, remotes and frameworks.

## Entry points

**The first two are the most interesting for learning**, the rest are very specific.

- [**Simple React microfrontend**](./micro-fe-2-react/readme.md)
- [**Cross-framework microfrontends**](./micro-fe-from-basic-sample-try-different-frameworks/README.md)
- [Basic sample of host and remote linked](./micro-fe-basic-sample-of-host-and-remote-linked/README.md)
- [Image sharing between microfrontends](./micro-fe-img-share/remote/README.md)
- [Vite microfrontend](./micro-fe-vite-1-mf/README.md)
- [Vite host and remotes](./micro-fe-vite-2-mfs-connected/README.md)
- [React version isolation with Grafana remote](./micro-fe-from-basic-sample-try-with-different-react-versions-integrate-grafana-remote/README.md)
  - (similar to **Cross-framework microfrontends**)

## Getting Started

> For a quick setup you can copy the folders inside [Basic sample of host and remote linked](./micro-fe-basic-sample-of-host-and-remote-linked/README.md), but if you want to learn follow the steps below

To create one microfrontend for the `host` and one for the `remote`, run this command twice:

```bash
npx create-mf-app
```

Install dependencies in each one:

```bash
npm i
```

Run each project:

```bash
npm start
```

To import PrimeReact and related styles:

```bash
npm i primereact primeicons primeflex sass sass-loader
```

> [!TIP]
> Start with the [Simple React microfrontend](./micro-fe-2-react/readme.md) if you want the easiest path first.
