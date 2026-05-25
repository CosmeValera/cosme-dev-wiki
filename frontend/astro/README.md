<!-- https://www.youtube.com/watch?v=WHqZAXHZN_w -->

# 🧑‍🚀 Astro

Astro is a frontend framework for content-first websites like blogs, portfolios, documentation, marketing pages and landing pages.

For a broader comparison between SSGs, SPAs and meta-frameworks, I wrote a full post here: 
<a href="https://cosmevalera.dev/blog/ssg-vs-spas-meta-frameworks/" target="_blank">SPAs vs SSGs vs Meta-frameworks</a>


## Core idea

```txt
Ship HTML by default.
Ship JavaScript only when a component needs it.
```

Astro starts from HTML first. Most of the page is generated before it reaches the browser, and JavaScript is added only to the parts that need interaction.

## Why use Astro?

Astro is a good fit when you want:

1. Fast static pages
2. Markdown or MDX content
3. Component-based UI
4. React, Vue, Svelte or plain Astro components
5. Interactive islands only where needed
6. Less JavaScript shipped to the browser


## Islands architecture

Astro uses islands architecture: static sections stay as HTML, while interactive components become small JavaScript islands.

Example:

```txt
Header: static HTML
Blog post: static HTML
Newsletter form: interactive island
Search box: interactive island
Theme toggle: interactive island
```

This avoids turning the whole page into a client-side app just because one small part needs interaction.

## Getting Started

Create a new Astro app:

```sh
npm create astro@latest
```

Run the development server:

```sh
npm run dev
```

Run the Ci server:

```sh
# Build the project:
npm run build

# Preview the production build:
npm run preview
```

If you want to use tailwind execute:

```sh
npx astro add tailwind
```