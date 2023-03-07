package group.payback.codingchallengeapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import group.payback.codingchallengeapplication.data.local.base.BaseDao
import group.payback.codingchallengeapplication.data.local.entities.Hit
import group.payback.codingchallengeapplication.data.local.entities.SearchWithHits


@Dao
interface HitDao : BaseDao<Hit> {

    @Query("SELECT * FROM Hit WHERE id = :imageID LIMIT 1")
    fun getImageDetailsByID(imageID: Int): Hit

    @Transaction
    @Query("SELECT * FROM Search WHERE wordQuery LIKE '%' || :word || '%'")
    fun getSearchWithHits(word: String): SearchWithHits

    @Query("SELECT * FROM Hit ")
    fun getAllHits(): List<Hit>
}