import { Link, Route, Routes, useParams } from 'react-router-dom'
import ReactMarkdown from 'react-markdown'
import { posts } from '../shared/data/posts'

const repositoryUrl = 'https://github.com/Guacamoleboy/advanced-programming'

function Header() {
  return (
    <header className="topbar">
      <Link className="site-title" to="/">Advanced Programming Course</Link>
      <a className="github-link" href={repositoryUrl} aria-label="Se projektet på GitHub">
        <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M12 .9a11.1 11.1 0 0 0-3.51 21.63c.56.1.76-.24.76-.54v-2.1c-3.1.67-3.76-1.32-3.76-1.32-.5-1.28-1.24-1.62-1.24-1.62-1.01-.69.08-.68.08-.68 1.12.08 1.71 1.15 1.71 1.15.99 1.7 2.59 1.21 3.22.92.1-.72.39-1.21.7-1.49-2.47-.28-5.07-1.24-5.07-5.51 0-1.22.44-2.22 1.15-3-.12-.29-.5-1.42.11-2.96 0 0 .94-.3 3.05 1.15a10.6 10.6 0 0 1 5.55 0c2.12-1.44 3.05-1.15 3.05-1.15.61 1.54.23 2.67.11 2.96.72.78 1.15 1.78 1.15 3 0 4.28-2.6 5.23-5.08 5.5.4.35.75 1.02.75 2.06v3.09c0 .3.2.65.77.54A11.1 11.1 0 0 0 12 .9Z" /></svg>
        <span>GitHub</span>
      </a>
    </header>
  )
}

function Home() {
  return (
    <main className="shell">
      <Header />
      <section className="intro" aria-labelledby="intro-title">
        <p className="author">Jonas M. Larsen</p>
        <h1 id="intro-title">Learning notes<br />and project work.</h1>
        <p className="intro-copy">A record of what I have learned during the Advanced Programming course, including the decisions, tools, and process behind the work.</p>
      </section>

      <section className="notes-section" aria-labelledby="notes-title">
        <div className="section-heading"><h2 id="notes-title">Course notes</h2><span>5 entries</span></div>
        <div className="post-grid">
          {posts.map((post, index) => (
            <Link className="post-card" to={`/posts/${post.slug}`} key={post.slug}>
              <span className="post-number">0{index + 1}</span>
              <h3>{post.title}</h3>
              <p className="card-description">{post.description}</p>
              <div className="card-meta"><span>{post.category}</span><span>{post.readTime}</span></div>
            </Link>
          ))}
        </div>
      </section>

      <footer className="footer"><span>Jonas M. Larsen</span><a href="mailto:cph-jl325@stud.ek.dk">cph-jl325@stud.ek.dk</a></footer>
    </main>
  )
}

function Post() {
  const { slug } = useParams()
  const post = posts.find((item) => item.slug === slug)

  if (!post) {
    return <main className="shell not-found"><Header /><h1>Page not found</h1><Link className="back-link" to="/">← Back to course notes</Link></main>
  }

  return (
    <main className="shell article-shell">
      <Header />
      <article>
        <Link className="back-link" to="/">← All course notes</Link>
        <div className="article-heading"><h1>{post.title}</h1><p className="article-meta">{post.category} <span>·</span> {post.readTime}</p><p className="article-deck">{post.description}</p></div>
        <div className="markdown-body"><ReactMarkdown>{post.content}</ReactMarkdown></div>
      </article>
      <footer className="footer"><a href="mailto:cph-jl325@stud.ek.dk">cph-jl325@stud.ek.dk</a><Link to="/">Back to course notes ↑</Link></footer>
    </main>
  )
}

export default function App() {
  return <Routes><Route path="/" element={<Home />} /><Route path="/posts/:slug" element={<Post />} /><Route path="*" element={<Post />} /></Routes>
}