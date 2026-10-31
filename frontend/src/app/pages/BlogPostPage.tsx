import ReactMarkdown from 'react-markdown'
import { Link, useParams } from 'react-router-dom'
import { useBlogPost } from '../../features/blog/hooks/useBlogPosts.hooks'
import styles from './BlogPostPage.module.css'

export default function BlogPostPage() {
	const { slug } = useParams()
	const post = useBlogPost(slug)

	if (!post) {
		return (
			<main className={styles.notFound}>
				<h1>Page not found</h1>
				<Link className={styles.backLink} to="/">← Back to course notes</Link>
			</main>
		)
	}

	return (
		<main>
			<article className={styles.article}>
				<Link className={styles.backLink} to="/">
					<svg viewBox="0 0 16 16" aria-hidden="true">
						<path d="M10.5 3.5 6 8l4.5 4.5M6.5 8H13" />
					</svg>
					<span>All course notes</span>
				</Link>
				<div className={styles.articleHeading}>
					<h1>{post.title}</h1>
					{post.description && <p className={styles.articleDeck}>{post.description}</p>}
				</div>
				<div className={styles.markdownBody}><ReactMarkdown>{post.content}</ReactMarkdown></div>
			</article>
		</main>
	)
}
