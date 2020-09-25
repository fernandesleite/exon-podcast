package me.fernandesleite.exonpodcast.network.models

data class ITunesRSS(val feed: Feed){
    data class Feed(val results: List<ResultsRSS>) {
        data class ResultsRSS(
            val artistName: String,
            val id: String,
            val releaseDate: String,
            val name: String,
            val kind: String,
            val copyright: String?,
            val contentAdvisoryRating: String?,
            val artistUrl: String?,
            val artworkUrl100: String?,
            val genres: List<GenresRSS>,
            val url: String
        ) {
            data class GenresRSS(
                val genreId: String,
                val name: String,
                val url: String
            )
        }
    }
}
