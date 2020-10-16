package me.fernandesleite.exonpodcast.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.fernandesleite.exonpodcast.persistence.daos.GenreDao
import me.fernandesleite.exonpodcast.persistence.entities.GenreEntity

@Database(entities = [GenreEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val genreDao: GenreDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            val cb: Callback = object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        getInstance(context).genreDao.insertAll(
                            listOf(
                                GenreEntity("1301", "Arts"),
                                GenreEntity("1321", "Business"),
                                GenreEntity("1303", "Comedy"),
                                GenreEntity("1304", "Education"),
                                GenreEntity("1483", "Fiction"),
                                GenreEntity("1511", "Government"),
                                GenreEntity("1512", "Health & Fitness"),
                                GenreEntity("1487", "History"),
                                GenreEntity("1305", "Kids & Family"),
                                GenreEntity("1502", "Leisure"),
                                GenreEntity("1310", "Music"),
                                GenreEntity("1489", "News"),
                                GenreEntity("1314", "Religion & Spirituality"),
                                GenreEntity("1533", "Science"),
                                GenreEntity("1324", "Society & Culture"),
                                GenreEntity("1545", "Sports"),
                                GenreEntity("1309", "TV & Film"),
                                GenreEntity("1318", "Technology"),
                                GenreEntity("1488", "True Crime")
                            )
                        )
                    }
                }
            }

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).addCallback(cb).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}