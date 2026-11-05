import graphNotes from './blog1.md?raw'
import complexityNotes from './blog2.md?raw'
import sortingNotes from './blog3.md?raw'
import backtrackingNotes from './blog4.md?raw'
import encryptionNotes from './blog5.md?raw'

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
		description: 'Dijkstra & A* learning.. What is it? How does it work? Lets find out!',
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
	}
]