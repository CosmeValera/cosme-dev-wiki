<!-- https://www.youtube.com/watch?v=WHqZAXHZN_w -->

# 🧑‍🚀 Astro

## Why Astro?

Not every frontend tool is meant for the same job.

React, Vue and Angular are great when the page is an app: lots of state, lots of user interaction, dashboards, forms, private areas, complex UI flows.

Astro is for a different kind of website: content first pages where most of the HTML can exist before the user opens the browser.

Examples:

1. Blogs
2. Portfolios
3. Documentation
4. Marketing pages
5. Landing pages
6. Content sites with a few interactive pieces

The main Astro idea is simple:

```txt
Ship HTML by default.
Ship JavaScript only when a component needs it.
```

That is the opposite of a normal SPA, where the browser usually downloads JavaScript first and then builds the page.

## Where Astro fits

There are three common categories:

| Category | Examples | Best for |
| --- | --- | --- |
| SSGs | Astro, Zola, Hugo, VitePress | Content heavy websites |
| SPA frameworks | React, Vue, Angular | Interactive apps |
| Meta frameworks | Next.js, Nuxt, SvelteKit | Projects that need both content and app behavior |

Astro is an SSG, but it is more flexible than classic SSGs like Zola or Hugo because you can use React, Vue, Svelte or plain Astro components in the same project.

That makes Astro a good fit when you want the speed and simplicity of a static site, but you still want to reuse frontend skills from React, Vue or other frameworks.

## Astro vs React, Vue and Angular

You can build a blog with React, Vue or Angular, but you will probably fight the tool.

For a content site, an SPA usually means:

1. More JavaScript than needed
2. More work for SEO and initial load
3. More routing and content setup
4. More client side logic for pages that are mostly static

Astro starts from the opposite assumption. The page is HTML first. If a section needs interaction, then you make only that section interactive.

## Astro vs Next.js or Nuxt

Next.js and Nuxt are useful when the project needs both sides:

1. Static public pages
2. Server rendering
3. API routes
4. Authentication
5. App dashboards
6. Dynamic user specific pages

If the project is mostly content, Astro is simpler.

If the project is a full product app, Next, Nuxt, React, Vue or Angular may fit better.

## Astro vs Zola or Hugo

Zola and Hugo are excellent static site generators. They are fast and simple.

Astro is usually better when you want:

1. Component based UI
2. React, Vue or Svelte components
3. Interactive islands
4. npm ecosystem
5. More frontend flexibility

Zola or Hugo are usually better when you want:

1. A very simple content site
2. No Node.js
3. A single binary
4. Mostly Markdown and templates

## Islands architecture

Astro uses islands architecture.

The idea is that most of the page is static HTML, and only the interactive parts become JavaScript in the browser.

Example:

```txt
Header: static HTML
Blog post: static HTML
Newsletter form: interactive island
Search box: interactive island
Theme toggle: interactive island
```

So instead of making the whole page a client side app, Astro lets you add interactivity only where it is needed.

## Getting Started

Create a new Astro app:

```sh
npm create astro@latest
```
