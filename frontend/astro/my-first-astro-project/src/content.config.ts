import { defineCollection } from "astro:content";
import { glob } from "astro/loaders";
import { z } from "astro/zod";

// z -> zod schema

const books = defineCollection({
    loader: glob({
        pattern: "**/*.{md,mdx}",
        base: "./src/content/books",
    }),
    schema: z.object({
        title: z.string(),
        author: z.string(),
        img: z.string(),
        readtime: z.number(),
        description: z.string(),
        buy: z.object({
            spain: z.string().url(),
            usa: z.string().url()
        })
    })
})

export const collections = { books }