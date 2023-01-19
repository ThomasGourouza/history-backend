## history-backend

# century:

Get:
- http://localhost:8080/century/
- http://localhost:8080/century/63c72181980afd286be8eece
- http://localhost:8080/century/search?number=4
- http://localhost:8080/century/search_between?begin=902&end=1453

Delete
- http://localhost:8080/century/63c72181980afd286be8eece

Post
- http://localhost:8080/century/
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

# period_event:

Get:
- http://localhost:8080/period_event/
- http://localhost:8080/period_event/63c7e5f4b60766202078ba7d

Delete
- http://localhost:8080/period_event/63c7e5f4b60766202078ba7d

Post
- http://localhost:8080/period_event/
{
	"type": "PERIOD",
	"name": "Test",
	"description": "",
	"link": "link",
	"fields": [
		"LITTERATURE",
		"SCIENCE"
	],
	"date": {
		"begin": null,
		"end": null
	},
	"location": {
		"name": "Location",
		"description": "",
		"flagImageId": "",
		"todayLocationDetailIds": []
	},
	"imageIds": [],
	"personalityIds": []
}

# personality:

Get:
- http://localhost:8080/personality/
- http://localhost:8080/personality/63c7e5f4b60766202078ba7d

Delete
- http://localhost:8080/personality/63c7e5f4b60766202078ba7d

Post
- http://localhost:8080/personality/
{
	"firstname": "Test",
	"lastname": "Test",
	"nickname": "Test",
	"date": {
		"begin": null,
		"end": null
	},
	"livingLocation": {
		"name": "name",
		"description": "",
		"flagImageId": "",
		"todayLocationDetailIds": []
	},
	"imageIds": [],
	"fields": [
		"LITTERATURE",
		"SCIENCE"
	],
	"movement": [],
	"description": "",
	"link": "link",
	"works": [
		{
			"name": "Test",
			"type": "BOOK",
			"date": null,
			"imageIds": [],
			"fields": [
				"LITTERATURE"
			],
			"movement": [],
			"description": "",
			"link": "link",
			"language": "FRENCH"
		}
	]
}

# TodayLocationDetail:

Get:
- http://localhost:8080/today_location_detail/
- http://localhost:8080/today_location_detail/63c7e5f4b60766202078ba7d

Delete
- http://localhost:8080/today_location_detail/63c7e5f4b60766202078ba7d

Post
- http://localhost:8080/today_location_detail/
{
	"continent": "test",
	"country": "test",
	"flagImageId": null
}


---

- L’ORGANISATION POLITIQUE ET SOCIALE
	Les groupes sociaux
	Les institutions et l’exercice du pouvoir
	La justice
	Les finances
	Le pouvoir militaire
	La santé et la médecine
	L’éducation et l’école

- LA VIE ÉCONOMIQUE
	L’agriculture
	L’artisanat
	Le commerce
	La monnaie

- LA RELIGION
	Les divinités païennes et fêtes païennes
	Le christianisme et fêtes chrétiennes
	Les églises et les monastères
	La spiritualité

- LA LITTÉRATURE
	La langue
	Les genres littéraires
	Les traductions
	Roman
	Poesie
	Théâtre

- LA PHILOSOPHIE
	Les courants philosophiques

- LA SCIENCE
	Les mathématiques et la logique
	La science

- LES ARTS
	L’architecture
	Les arts appliqués
	tableaux
	courants artistiques
	musique
	courants musicaux
