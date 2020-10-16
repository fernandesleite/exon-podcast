package me.fernandesleite.exonpodcast.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.fernandesleite.exonpodcast.persistence.entities.GenreEntity

@Dao
interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(genreEntity: List<GenreEntity>)

    @Query("SELECT * FROM genre_table")
    fun getAllGenres(): List<GenreEntity>
}