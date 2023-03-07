package group.payback.codingchallengeapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import group.payback.codingchallengeapplication.data.local.dao.HitDao
import group.payback.codingchallengeapplication.data.local.dao.HitSearchCrossRefDao
import group.payback.codingchallengeapplication.data.local.dao.SearchDao
import group.payback.codingchallengeapplication.data.local.entities.Hit
import group.payback.codingchallengeapplication.data.local.entities.HitSearchCrossRef
import group.payback.codingchallengeapplication.data.local.entities.Search

@Database(
    entities = [
        HitSearchCrossRef::class,
        Search::class,
        Hit::class
],
    version = 1,
    exportSchema = true
)
abstract class ImagesCacheDatabase : RoomDatabase() {
    abstract fun hitSearchCrossRefDao(): HitSearchCrossRefDao
    abstract fun searchDao(): SearchDao
    abstract fun hitDao(): HitDao
}