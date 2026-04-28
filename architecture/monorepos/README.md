# Monorepo

### Quick overview
All code for multiple projects is stored in a single repository. The main modern options for monorepo frameworks are NX and Turborepo.

In general, Turborepo is more lightweight and easier to setup, while NX requires more resources and provides more configuration options. Personally, I'd always go with Turborepo, unless you really need NX features.

---

### NX

> [!TIP]
>
> Check out my [notes about NX](./nx/nx-attempt-2-monorepo-react/README.md)

### Turborepo

> [!TIP]
>
> Check out my [notes about Turborepo](./turborepo/2-turboapp/README.md)

---

### Monorepo vs Polyrepo

| Feature | Monorepos | Polyrepos |
| --- | --- | --- |
| Definition | Single repository for multiple projects | Separate repositories for each project |
| Dependency Management | Simplified, centralized | More complex, harder to manage |
| Code Sharing | Easy and promotes reuse | Difficult, often leads to duplication |
| CI/CD | Unified, centralized | Tailored, separate pipelines |
| Code Navigation | All in one place | More complex, across multiple repos |
| Scalability | Can become slow and complex | Easier to scale with smaller repos |
| Permissions | Harder to manage | Easier, per repository |
| Build Overhead | Higher, can trigger broad rebuilds | Lower, changes affect only the specific repo |
| Performance | Slower, single repo | Smaller, faster repos |
