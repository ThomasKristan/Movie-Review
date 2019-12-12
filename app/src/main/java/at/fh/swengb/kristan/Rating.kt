package at.fh.swengb.kristan

class Rating(val movie: String, var rating: Double? = null, var feedback: String? = null)

class Rating2(val movie: String) {
    var rating: Double? = null
    var feedback: String? = null
}