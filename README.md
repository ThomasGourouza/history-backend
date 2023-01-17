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



Get:
- http://localhost:8080/century/
- http://localhost:8080/century/63c72181980afd286be8eece
- http://localhost:8080/century/search?number=4
- http://localhost:8080/century/search_between?begin=902&end=1453

Delete
- http://localhost:8080/century/63c72181980afd286be8eece

Post
- http://localhost:8080/century/http://localhost:8080/century/
{
	"number": "2",
	"roman": "II"
}
- http://localhost:8080/century/many
[
	{
		"number": "-10",
		"roman": "-X"
	},
	{
		"number": "-9",
		"roman": "-IX"
	},
	{
		"number": "-8",
		"roman": "VIII"
	},
	{
		"number": "-7",
		"roman": "-VII"
	},
	{
		"number": "-6",
		"roman": "-VI"
	},
	{
		"number": "-5",
		"roman": "-V"
	},
	{
		"number": "-4",
		"roman": "-IV"
	},
	{
		"number": "-3",
		"roman": "-III"
	},
	{
		"number": "-2",
		"roman": "-II"
	},
	{
		"number": "-1",
		"roman": "-I"
	},
	{
		"number": "1",
		"roman": "I"
	},
	{
		"number": "2",
		"roman": "II"
	},
	{
		"number": "3",
		"roman": "III"
	},
	{
		"number": "4",
		"roman": "IV"
	},
	{
		"number": "5",
		"roman": "V"
	},
	{
		"number": "6",
		"roman": "VI"
	},
	{
		"number": "7",
		"roman": "VII"
	},
	{
		"number": "8",
		"roman": "VIII"
	},
	{
		"number": "9",
		"roman": "IX"
	},
	{
		"number": "10",
		"roman": "X"
	},
	{
		"number": "11",
		"roman": "XI"
	},
	{
		"number": "12",
		"roman": "XII"
	},
	{
		"number": "13",
		"roman": "XIII"
	},
	{
		"number": "14",
		"roman": "XIV"
	},
	{
		"number": "15",
		"roman": "XV"
	},
	{
		"number": "16",
		"roman": "XVI"
	},
	{
		"number": "17",
		"roman": "XVII"
	},
	{
		"number": "18",
		"roman": "XVIII"
	},
	{
		"number": "19",
		"roman": "XIX"
	},
	{
		"number": "20",
		"roman": "XX"
	},
	{
		"number": "21",
		"roman": "XXI"
	},
	{
		"number": "22",
		"roman": "XXII"
	}
]