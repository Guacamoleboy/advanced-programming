import { posts } from '../data/posts'

export function useBlogPosts() {
	return posts
}

export function useBlogPost(slug: string | undefined) {
	return posts.find((post) => post.slug === slug)
}
