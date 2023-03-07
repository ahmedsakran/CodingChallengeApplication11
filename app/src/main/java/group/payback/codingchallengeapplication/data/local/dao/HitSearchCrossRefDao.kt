package group.payback.codingchallengeapplication.data.local.dao

import androidx.room.*
import group.payback.codingchallengeapplication.data.local.base.BaseDao
import group.payback.codingchallengeapplication.data.local.entities.Hit
import group.payback.codingchallengeapplication.data.local.entities.HitSearchCrossRef

@Dao
interface HitSearchCrossRefDao : BaseDao<HitSearchCrossRef> {

    @Query("SELECT * FROM HitSearchCrossRef ")
    fun getAllHitSearchCrossRef(): List<HitSearchCrossRef>
}