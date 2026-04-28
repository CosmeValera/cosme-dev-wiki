## Basic Sample of Host and Remote linked
Feel free to copy the folders `host` and `remote` in this repository, to have a quick fresh start with linkned microfrontends.

### 🤔 How was this repository done?

I executed this command for each folder:
```bash
npx create-mf-app@1.1.8
```

And then I edited the `webpack.config.js` files of both `host` and `remote`, so that the `remote` shares a React component and the `host` imports it as its remote.