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
		description: '500.000 tal i lister og sæt. Hvad koster det at finde, indsætte og fjerne dem?',
		content: complexityNotes,
	},
	{
		slug: 'sortering',
		title: 'Sortering',
		description: 'De samme afstande sorteret med Bubble Sort, Merge Sort, Quick Sort og Heap Sort.',
		content: sortingNotes,
	},
	{
		slug: 'backtracking',
		title: 'Backtracking',
		description: 'En vej gennem labyrinten, hvor blindgyderne skal prøves og fjernes igen.',
		content: backtrackingNotes,
	},
	{
		slug: 'kryptering',
		title: 'Kryptering',
		description: 'Kommer snart.',
		content: encryptionNotes,
	}
]
