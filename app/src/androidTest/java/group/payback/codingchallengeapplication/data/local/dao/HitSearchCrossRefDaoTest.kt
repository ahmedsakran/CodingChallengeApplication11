package group.payback.codingchallengeapplication.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import group.payback.codingchallengeapplication.data.local.ImagesCacheDatabase
import group.payback.codingchallengeapplication.data.local.entities.Hit
import group.payback.codingchallengeapplication.data.local.entities.HitSearchCrossRef
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class HitSearchCrossRefDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var searchDao: SearchDao
    private lateinit var hitDao: HitDao
    private lateinit var hitSearchCrossRefDao: HitSearchCrossRefDao
    private lateinit var db: ImagesCacheDatabase

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ImagesCacheDatabase::class.java
        ).allowMainThreadQueries().build()
        searchDao = db.searchDao()
        hitDao = db.hitDao()
        hitSearchCrossRefDao = db.hitSearchCrossRefDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun insertHitSearchCrossRef() = runBlockingTest {

        //region Insert Search Row
        val wordQuery = "yellow"
        val insertedItem = searchDao.insertSearch(wordQuery)
        //endregion

        //region Insert Hit Rows
        val hitObj_1 = Hit(
            1,
            1,
            2,
            3,
            4,
            5,
            6,
            "path here1",
            1,
            "url",
            1,
            "",
            1,
            "",
            "",
            "",
            "",
            1,
            2,
            3,
            "",
            1
        )
        hitDao.insert(hitObj_1)
        val hitObj_2 = Hit(
            2,
            1,
            2,
            5,
            4,
            5,
            6,
            "path here2",
            1,
            "url",
            1,
            "",
            1,
            "",
            "",
            "",
            "",
            1,
            2,
            3,
            "",
            1
        )
        hitDao.insert(hitObj_2)
        val hitObj_3 = Hit(
            3,
            1,
            2,
            9,
            4,
            5,
            6,
            "path here3",
            1,
            "url",
            1,
            "",
            1,
            "",
            "",
            "",
            "",
            1,
            2,
            3,
            "",
            1
        )
        hitDao.insert(hitObj_3)
        val hitObj_4 = Hit(
            4,
            1,
            2,
            1,
            4,
            5,
            6,
            "path here4",
            1,
            "url",
            1,
            "",
            1,
            "",
            "",
            "",
            "",
            1,
            2,
            3,
            "",
            1
        )
        hitDao.insert(hitObj_4)
        val hitObj_5 = Hit(
            5,
            1,
            2,
            4,
            4,
            5,
            6,
            "path here5",
            1,
            "url",
            1,
            "",
            1,
            "",
            "",
            "",
            "",
            1,
            2,
            3,
            "",
            1
        )
        hitDao.insert(hitObj_5)
        //endregion

        //region Create HitSearchCrossRef Rows
        var hitSearchCrossRefObj_1 = HitSearchCrossRef(insertedItem.toInt(), hitObj_1.id)
        var hitSearchCrossRefObj_2 = HitSearchCrossRef(insertedItem.toInt(), hitObj_2.id)
        var hitSearchCrossRefObj_3 = HitSearchCrossRef(insertedItem.toInt(), hitObj_3.id)
        var hitSearchCrossRefObj_4 = HitSearchCrossRef(insertedItem.toInt(), hitObj_4.id)
        var hitSearchCrossRefObj_5 = HitSearchCrossRef(insertedItem.toInt(), hitObj_5.id)
        //endregion

        val listToInsert = listOf<HitSearchCrossRef>(
            hitSearchCrossRefObj_1,
            hitSearchCrossRefObj_2,
            hitSearchCrossRefObj_3,
            hitSearchCrossRefObj_4,
            hitSearchCrossRefObj_5
        )

        val newInsertedList = hitSearchCrossRefDao.insertList(listToInsert)
        val allHitSearchCrossRefList = hitSearchCrossRefDao.getAllHitSearchCrossRef()
        Truth.assertThat(allHitSearchCrossRefList.size).isEqualTo(newInsertedList.size)

    }

}