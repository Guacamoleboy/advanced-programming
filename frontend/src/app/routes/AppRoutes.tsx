import { Route, Routes } from 'react-router-dom'
import BlogLayout from '../layouts/BlogLayout'
import BlogPage from '../pages/BlogPage'
import BlogPostPage from '../pages/BlogPostPage'

export default function AppRoutes() {
	return (
		<Routes>
			<Route element={<BlogLayout />}>
				<Route path="/" element={<BlogPage />} />
				<Route path="/posts/:slug" element={<BlogPostPage />} />
				<Route path="*" element={<BlogPostPage />} />
			</Route>
		</Routes>
	)
}
