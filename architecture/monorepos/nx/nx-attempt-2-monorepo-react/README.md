## NX

NX is useful when you have several apps and libraries in the same repo.

The important idea is that NX knows the project graph. Because of that, it can understand which apps depend on which libs, and it can run only the affected tasks.

> Check out [NX docu](https://nx.dev/)

### Create a new NX project
```bash
npx create-nx-workspace@latest nxapp
```

### Install all dependencies

```bash
npm i
```

<small>Common dependencies will be installed in the root `node_modules`</small>

### List apps

```bash
npx nx show projects
```

### See the project graph

```bash
npx nx graph
```

This opens a visual graph with apps and libs. It is useful to understand what depends on what.

### Run ALL apps

```bash
npm run start
```

or

```bash
npx nx run-many -t start
```

### Run ONE app

```bash
npx nx run my-app-1:start
```

<small>Change `my-app-1` with the app you want to start.</small>

### Test ONE app

```bash
npx nx run my-app-1:test
```

<small>Change `my-app-1` with the app you want to test.</small>

### Run only affected projects

```bash
npx nx affected -t test
npx nx affected -t build
```

This is one of the main reasons to use NX in CI.

### Apps and libs

```bash
npx nx g @nx/react:app my-app-1
npx nx g @nx/react:lib shared-ui
```

Typical structure:

```txt
apps/
  my-app-1/
  my-app-2/
libs/
  shared-ui/
  utils/
```
