import styles from './ToTop.module.css'
import { useScrollToTopOnNavigation, useToTop } from './useToTop.hooks'

export default function ToTop() {
	useScrollToTopOnNavigation()
	const { isVisible, scrollToTop } = useToTop()

	if (!isVisible) {
		return null
	}

	return (
		<button
			className={styles.button}
			type="button"
			onClick={scrollToTop}
			aria-label="Scroll to top"
			title="Scroll to top"
		>
			<svg viewBox="0 0 24 24" aria-hidden="true">
				<path d="M12 19V5M6 11l6-6 6 6" />
			</svg>
		</button>
	)
}
