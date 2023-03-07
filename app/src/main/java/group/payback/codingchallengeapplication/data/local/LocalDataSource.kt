package group.payback.codingchallengeapplication.data.local

import group.payback.codingchallengeapplication.data.local.dao.HitDao
import group.payback.codingchallengeapplication.data.local.dao.HitSearchCrossRefDao
import group.payback.codingchallengeapplication.data.local.dao.SearchDao
import group.payback.codingchallengeapplication.data.local.entities.Hit
import group.payback.codingchallengeapplication.data.local.entities.HitSearchCrossRef
import group.payback.codingchallengeapplication.data.local.entities.Search
import group.payback.codingchallengeapplication.data.local.entities.SearchWithHits
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val searchDao: SearchDao,
    private val hitDao: HitDao,
    private val hitSearchCrossRefDao: HitSearchCrossRefDao,
) {
    fun getImagesFromDAO(word: String): SearchWithHits = hitDao.getSearchWithHits(word)

    suspend fun insertHitsToDAO(newObj: List<Hit>) {
        hitDao.insertList(newObj)
    }

    fun insertSearchToDAO(word: String):Long {
        return searchDao.insertSearch(word)
    }

    suspend fun insertHitSearchCrossRefToDAO(obj: HitSearchCrossRef) {
        hitSearchCrossRefDao.insert(obj)
    }

    fun getImageDetailsFromDAO(imageID: Int): Hit = hitDao.getImageDetailsByID(imageID)

}