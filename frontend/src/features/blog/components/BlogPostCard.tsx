import { Link } from 'react-router-dom'
import type { BlogPost } from '../data/posts'
import styles from './BlogPostCard.module.css'

interface BlogPostCardProps {
	post: BlogPost
	index: number
}

export default function BlogPostCard({ post, index }: BlogPostCardProps) {
	return (
		<Link className={styles.postCard} to={`/posts/${post.slug}`}>
			<span className={styles.postNumber}>0{index + 1}</span>
			<h3>{post.title}</h3>
			{post.description && <p className={styles.description}>{post.description}</p>}
		</Link>
	)
}
