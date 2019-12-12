package at.fh.swengb.kristan

object MovieRepository {
    private val movies: List<Movie>

    init {
        movies = listOf(
            Movie("0",
                "Avengers 4: Endgame",
                "24.04.2019",
                "After the devastating events of Avengers 3: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
                MovieGenre.ACTION,
                Person("Anthony Russo", "03.02.1970"),
                listOf(Person("Robert Downey Jr.", "4.4.1965"), Person(" Chris Evans", "13.6.1981")),
                mutableListOf()
            ),
            Movie("1",
                "Avatar",
                "17.12.2009",
                "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home",
                MovieGenre.ACTION,
                Person("James Cameron", "16.8.1954"),
                listOf(Person("Sam Worthington", "2.8.1976"), Person(" Zoe Saldana", "19.6.1978")),
                mutableListOf()
            ),
            Movie("2",
                "Titanic",
                "09.01.1998",
                "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.",
                MovieGenre.DRAMA,
                Person("James Cameron", "16.8.1954"),
                listOf(Person("Leonardo DiCaprio", "11.11.1974"), Person("Kate Winslet", "05.10.1975")),
                mutableListOf()
            ),
            Movie("3",
                "Star Wars VII - Das Erwachen der Macht",
                "17.12.2015",
                "Three decades after the Empire's defeat, a new threat arises in the militant First Order. Defected stormtrooper Finn and the scavenger Rey are caught up in the Resistance's search for the missing Luke Skywalker.",
                MovieGenre.ACTION,
                Person("Lawrence Kasdan", "14.01.1949"),
                listOf(Person("Daisy Ridley", "10.04.1992"), Person("John Boyega", "17.03.1992")),
                mutableListOf()
            ),
            Movie("4",
                "Avengers 3: Infinity War",
                "26.04.2018",
                "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
                MovieGenre.ACTION,
                Person("Anthony Russo", "03.02.1970"),
                listOf(Person("Robert Downey Jr.", "4.4.1965"), Person("Chris Hemsworth", "11.08.1983")),
                mutableListOf()
            ),
            Movie("5",
                "Jurassic World",
                "11.06.2015",
                "A new theme park, built on the original site of Jurassic Park, creates a genetically modified hybrid dinosaur, the Indominus Rex, which escapes containment and goes on a killing spree.",
                MovieGenre.ACTION,
                Person("Rick Jaffa", "08.05.1956"),
                listOf(Person("Chris Pratt", "21.06.1979"), Person("Bryce Dallas Howard", "02.03.1981")),
                mutableListOf()
            ),
            Movie("6",
                "Der König der Löwen ",
                "17.07.2019",
                "After the murder of his father, a young lion prince flees his kingdom only to learn the true meaning of responsibility and bravery.",
                MovieGenre.DRAMA,
                Person("Jeff Nathanson", "12.10.1965"),
                listOf(Person("Donald Glover", "25.09.1983"), Person("Beyoncé", "04.09.1981")),
                mutableListOf()
            ),
            Movie("7",
                "The Avengers",
                "26.04.2012",
                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.",
                MovieGenre.ACTION,
                Person("Joss Whedon", "23.06.1964"),
                listOf(Person("Robert Downey Jr.", "4.4.1965"), Person("Chris Evans", "13.6.1981")),
                mutableListOf()
            ),
            Movie("8",
                "Furious Seven",
                "02.04.2015",
                "Deckard Shaw seeks revenge against Dominic Toretto and his family for his comatose brother.",
                MovieGenre.ACTION,
                Person("Chris Morgan", "23.06.1975"),
                listOf(Person("Vin Diesel", "18.07.1967"), Person("Paul Walker", "30.11.2013")),
                mutableListOf()
            ),
            Movie("9",
                "Avengers: Age of Ultron",
                "23.04.2015",
                "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
                MovieGenre.ACTION,
                Person("Joss Whedon", "23.06.1964"),
                listOf(Person("Robert Downey Jr.", "4.4.1965"), Person("Chris Evans", "13.6.1981")),
                mutableListOf()
            ),
            Movie("10",
                "Black Panther",
                "15.02.2018",
                "T'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country's past.",
                MovieGenre.ACTION,
                Person("Ryan Coogler", "23.05.1986"),
                listOf(Person("Chadwick Boseman", "29.11.1977"), Person("Michael B. Jordan", "09.02.1987")),
                mutableListOf()
            ),
            Movie("11",
                " Harry Potter and the Deathly Hallows: Part 2",
                "13.07.2011",
                "Harry, Ron and Hermione search for Voldemort's remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.",
                MovieGenre.ACTION,
                Person("J.K. Rowling", "31.07.1965"),
                listOf(Person("Daniel Radcliffe", "23.07.1989"), Person("Emma Watson", "15.04.1990")),
                mutableListOf()
            ),
            Movie("12",
                "Star Wars: Die letzten Jedi",
                "14.12.2017",
                "Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares for battle with the First Order.",
                MovieGenre.ACTION,
                Person("Rian Johnson", "17.12.1973"),
                listOf(Person("Daisy Ridley", "10.04.1992"), Person("John Boyega", "17.03.1992")),
                mutableListOf()
            ),
            Movie("13",
                "Jurassic World: Das gefallene Königreich",
                "07.06.2018",
                "When the island's dormant volcano begins roaring to life, Owen and Claire mount a campaign to rescue the remaining dinosaurs from this extinction-level event.",
                MovieGenre.ACTION,
                Person("Derek Connolly", "26.02.1989"),
                listOf(Person("Chris Pratt", "21.06.1979"), Person("Bryce Dallas Howard", "02.03.1981")),
                mutableListOf()
            ),
            Movie("14",
                "Frozen",
                "28.11.2013",
                "When the newly-crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister Anna teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition.",
                MovieGenre.COMEDY,
                Person("Jennifer Lee", "22.10.1971"),
                listOf(Person("Kristen Bell", "18.07.1980"), Person("Idina Menzel", "30.05.1971")),
                mutableListOf()
            )
        )
    }
    fun moviesList(): List<Movie> {
        return movies
    }

    fun movieById(id: String): Movie? {
        return movies.find { it.id == id }
    }

    fun rateMovie (id: String, rating: Review) {
        val movie = movieById(id)
        movie?.reviews?.add(rating)
    }
}
