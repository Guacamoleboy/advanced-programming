import { Link, Outlet } from 'react-router-dom'
import ToTop from '../../shared/components/totop/ToTop'
import styles from './BlogLayout.module.css'

const repositoryUrl = 'https://github.com/Guacamoleboy/advanced-programming'

export default function BlogLayout() {
	return (
		<div className={styles.shell}>
			<header className={styles.topbar}>
				<Link className={styles.siteTitle} to="/">Advanced Programming Course</Link>
				<a className={styles.githubLink} href={repositoryUrl} aria-label="Se projektet på GitHub">
					<svg viewBox="0 0 24 24" aria-hidden="true">
						<path d="M12 .9a11.1 11.1 0 0 0-3.51 21.63c.56.1.76-.24.76-.54v-2.1c-3.1.67-3.76-1.32-3.76-1.32-.5-1.28-1.24-1.62-1.24-1.62-1.01-.69.08-.68.08-.68 1.12.08 1.71 1.15 1.71 1.15.99 1.7 2.59 1.21 3.22.92.1-.72.39-1.21.7-1.49-2.47-.28-5.07-1.24-5.07-5.51 0-1.22.44-2.22 1.15-3-.12-.29-.5-1.42.11-2.96 0 0 .94-.3 3.05 1.15a10.6 10.6 0 0 1 5.55 0c2.12-1.44 3.05-1.15 3.05-1.15.61 1.54.23 2.67.11 2.96.72.78 1.15 1.78 1.15 3 0 4.28-2.6 5.23-5.08 5.5.4.35.75 1.02.75 2.06v3.09c0 .3.2.65.77.54A11.1 11.1 0 0 0 12 .9Z" />
					</svg>
					<span>GitHub</span>
				</a>
			</header>

			<Outlet />
			<ToTop />

			<footer className={styles.footer}>
				<span>Jonas M. Larsen</span>
				<a href="mailto:cph-jl325@stud.ek.dk">cph-jl325@stud.ek.dk</a>
			</footer>
		</div>
	)
}
