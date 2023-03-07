package group.payback.codingchallengeapplication.data.local.dao

import com.google.common.truth.Truth.assertThat
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import group.payback.codingchallengeapplication.data.local.ImagesCacheDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.junit.runner.RunWith
import org.junit.Test

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class SearchDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var searchDao: SearchDao
    private lateinit var db: ImagesCacheDatabase

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ImagesCacheDatabase::class.java
        ).allowMainThreadQueries().build()
        searchDao = db.searchDao()
    }

    @Test
    fun insertSearch() = runBlockingTest {
        val wordQuery = "yellow"
        val insertedItem = searchDao.insertSearch(wordQuery)
        val result = searchDao.getSearchItemByWord(wordQuery)
        assertThat(result.searchID).isEqualTo(insertedItem.toInt())
    }

    @After
    fun teardown() {
        db.close()
    }

}