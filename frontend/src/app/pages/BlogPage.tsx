import { useBlogPosts } from '../../features/blog/hooks/useBlogPosts.hooks'
import BlogPostCard from '../../features/blog/components/BlogPostCard'
import styles from './BlogPage.module.css'

export default function BlogPage() {
	const posts = useBlogPosts()

	return (
		<main>
			<section className={styles.intro} aria-labelledby="intro-title">
				<p className={styles.author}>Jonas M. Larsen</p>
				<h1 id="intro-title">Learning notes<br />and project work.</h1>
				<p className={styles.introCopy}>A record of what I have learned during the Advanced Programming course, including the decisions, tools, and process behind the work.</p>
			</section>

			<section aria-labelledby="notes-title">
				<div className={styles.sectionHeading}>
					<h2 id="notes-title">Course notes</h2>
					<span>{posts.length} entries</span>
				</div>
				<div className={styles.postGrid}>
					{posts.map((post, index) => <BlogPostCard key={post.slug} post={post} index={index} />)}
				</div>
			</section>
		</main>
	)
}
