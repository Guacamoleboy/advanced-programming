import { useEffect, useState } from 'react'
import { useLocation } from 'react-router-dom'

export function useToTop(threshold = 320) {
	const [isVisible, setIsVisible] = useState(false)

	useEffect(() => {
		const updateVisibility = () => {
			setIsVisible(window.scrollY > threshold)
		}

		updateVisibility()
		window.addEventListener('scroll', updateVisibility, { passive: true })

		return () => window.removeEventListener('scroll', updateVisibility)
	}, [threshold])

	const scrollToTop = () => {
		const prefersReducedMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches

		window.scrollTo({
			top: 0,
			behavior: prefersReducedMotion ? 'auto' : 'smooth',
		})
	}

	return { isVisible, scrollToTop }
}

export function useScrollToTopOnNavigation() {
	const { key } = useLocation()

	useEffect(() => {
		window.scrollTo({ top: 0, left: 0 })
	}, [key])
}
