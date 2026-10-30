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
				<Link className={styles.backLink} to="/">← All course notes</Link>
				<div className={styles.articleHeading}>
					<h1>{post.title}</h1>
					<p className={styles.articleMeta}>{post.category} <span>·</span> {post.readTime}</p>
					<p className={styles.articleDeck}>{post.description}</p>
				</div>
				<div className={styles.markdownBody}><ReactMarkdown>{post.content}</ReactMarkdown></div>
			</article>
		</main>
	)
}
