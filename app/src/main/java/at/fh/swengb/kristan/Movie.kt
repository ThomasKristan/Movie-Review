package at.fh.swengb.kristan

import com.squareup.moshi.JsonClass

@JsonClass (generateAdapter = true)
open class Movie(val id: String,
                 val title: String,
                 val release: String,
                 val posterImagePath: String,
                 val backdropImagePath: String,
                 val reviews: MutableList<Review>
) {
    fun reviewAverage(): Double {
        val average = reviews.map { it.reviewValue }.average()
        if (average.isNaN()) {
            return 0.0
        }

        return (Math.round(average *10)/10.0)

    }
}

