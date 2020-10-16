package me.fernandesleite.exonpodcast.util

import me.fernandesleite.exonpodcast.persistence.entities.GenreEntity
import me.fernandesleite.exonpodcast.ui.discoverPage.Genre

fun List<GenreEntity>.toDomain(): List<Genre> {
    return map {
        Genre(
            id = it.id,
            name = it.name
        )
    }
}