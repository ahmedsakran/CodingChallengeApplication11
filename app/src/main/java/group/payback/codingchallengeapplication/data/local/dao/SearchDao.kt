package group.payback.codingchallengeapplication.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import group.payback.codingchallengeapplication.data.local.base.BaseDao
import group.payback.codingchallengeapplication.data.local.entities.Hit
import group.payback.codingchallengeapplication.data.local.entities.Search
import group.payback.codingchallengeapplication.data.local.entities.SearchWithHits

@Dao
interface SearchDao : BaseDao<Search> {

    @Transaction
    @Query("INSERT INTO Search(wordQuery) VALUES(:word)")
    fun insertSearch(word: String): Long

    @Query("SELECT * FROM Search WHERE wordQuery LIKE '%' || :word || '%' ORDER BY searchID DESC LIMIT 1")
    fun getSearchItemByWord(word: String): Search

}