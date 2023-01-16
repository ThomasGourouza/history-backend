# history-backend

BDD: History

Century = {						// BDD
	number: number;
	roman: string;
	begin: number;
	end: number;
}

Period = {
	name: string;
	types: string[]; (Enum: litteraire, scientifique, politique, musical, artistique, religieux, ...)
	time: Time;
	locations: Location[];
};

Time = {
	begin: number;
	end: number;
};

Location = {
	continent: string (Enum);
	country: string (Enum) | undefined;
	place: string (Enum) | undefined;
	description: string;
	images: Image[];
};

Event = {
	name: string;
	date: string;
	location: Location;
	images: Image[];
	description: string;
}

Image = {
	title: string;
	imageUrl: string;
	description: string;
}

Personality = {
	name: string;
	time: Time;
	location: Location;
	images: Image[];
	categories: string[] (Enum: music, philosophy, science, ...);
	movements: string[] (Enum);
	description: string;
	work: Work[];
}

Work = {
	name: string;
	date: number;
	type: string; (Enum: book, music, theater play, painting, ...)
	categories: string[]
	language: string;
	images: Image[];
	description: string;
}

-----------

- geopolitique du monde/guerres
- par pays/region et par periode:
	- systeme politique
	- systeme economique:
		commerce
		finance
		travail (images)
	- systeme social:
		famille
		justice
		education/ecole (images)
		securite/police (images)
		militaire (images)
	- culturel: (images)
		style vestimentaire, mode
		traditions
		religions
		mythologie
		divertissements/loisirs/activites
		cuisine
		art
		musique (audio)
		litterature
		langues
	- technique:
		science
		technologie
		progres techniques
	- intellectuel:
		mathematiques
		philosophie
	- communication:
		marketing
		information
		correspondance/poste
	- personalites:
		biographie (images)