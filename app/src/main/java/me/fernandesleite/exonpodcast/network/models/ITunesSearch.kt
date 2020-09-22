package me.fernandesleite.exonpodcast.network.models

data class ITunesSearch (
    val resultCount : Int,
    val results: List<Results>
) {
    data class Results (
        val wrapperType : String,
        val explicitness : String?,
        val kind  : String,
        val trackName : String,
        val artistName : String,
        val collectionName : String,
        val censoredName : String?,
        val artworkUri100 : String?,
        val artworkUrl60: String?,
        val viewURL : String?,
        val previewURL : String?,
        val trackTimeMillis : String?
    )
}

