import graphNotes from './blog1.md?raw'
import complexityNotes from './blog2.md?raw'
import sortingNotes from './blog3.md?raw'
import backtrackingNotes from './blog4.md?raw'
import encryptionNotes from './blog5.md?raw'
import reactMarkdownCheatSheet from './react-markdown-cheat-sheet.md?raw'

export interface BlogPost {
	slug: string
	title: string
	content: string
	description?: string
}

export const posts: BlogPost[] = [
	{
		slug: 'grafer-og-korteste-vej',
		title: 'Grafer og korteste vej',
		description: 'N/A Description',
		content: graphNotes,
	},
	{
		slug: 'kompleksitet-og-datastrukturer',
		title: 'Kompleksitet og datastrukturer',
		description: 'N/A Description',
		content: complexityNotes,
	},
	{
		slug: 'sortering',
		title: 'Sortering',
		description: 'N/A Description',
		content: sortingNotes,
	},
	{
		slug: 'backtracking',
		title: 'Backtracking',
		description: 'N/A Description',
		content: backtrackingNotes,
	},
	{
		slug: 'kryptering',
		title: 'Kryptering',
		description: 'N/A Description',
		content: encryptionNotes,
	},
	{
		slug: 'react-markdown-cheat-sheet',
		title: 'React Markdown Cheat Sheet',
		description: 'En praktisk reference til Markdown-syntaks, ReactMarkdown, plugins og typiske faldgruber.',
		content: reactMarkdownCheatSheet,
	},
]
