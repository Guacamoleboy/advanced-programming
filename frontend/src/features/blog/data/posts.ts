import postOne from './blog1.md?raw'
import postTwo from './blog2.md?raw'
import postThree from './blog3.md?raw'
import postFour from './blog4.md?raw'
import postFive from './blog5.md?raw'

export interface BlogPost {
	slug: string
	title: string
	description: string
	category: string
	readTime: string
	content: string
}

export const posts: BlogPost[] = [
	{ slug: 'projektstruktur', title: 'Projektstruktur og valg', description: 'En gennemgang af mapperne og de valg, der ligger bag opdelingen.', category: 'Projekt', readTime: '4 min', content: postOne },
	{ slug: 'react-typescript', title: 'React med TypeScript', description: 'Hvordan komponenter og typer tilsammen gør brugerfladen lettere at arbejde med.', category: 'Frontend', readTime: '5 min', content: postTwo },
	{ slug: 'markdown-indlaeg', title: 'Indlæg skrevet i Markdown', description: 'Sådan holdes indholdet adskilt fra præsentationen på siden.', category: 'Indhold', readTime: '4 min', content: postThree },
	{ slug: 'responsivt-layout', title: 'Et layout til flere skærme', description: 'Små tilpasninger, der gør kort og artikler behagelige at læse på mobil.', category: 'CSS', readTime: '4 min', content: postFour },
	{ slug: 'arbejdsproces', title: 'Arbejdsproces og refleksion', description: 'Noter om at bygge løsningen trin for trin og dokumentere undervejs.', category: 'Refleksion', readTime: '3 min', content: postFive },
]
