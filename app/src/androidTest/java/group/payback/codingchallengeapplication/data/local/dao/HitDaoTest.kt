package group.payback.codingchallengeapplication.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import group.payback.codingchallengeapplication.data.local.ImagesCacheDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import group.payback.codingchallengeapplication.data.local.entities.Hit
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class HitDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var hitDao: HitDao
    private lateinit var db: ImagesCacheDatabase

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ImagesCacheDatabase::class.java
        ).allowMainThreadQueries().build()
        hitDao = db.hitDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun insertHit() = runBlockingTest {
        val hit = Hit(6,1,2,3,4,5,6,"path here",1,"url",1,"",1,"","","","",1,2,3,"",1 )
        hitDao.insert(hit)
        val allHits = hitDao.getAllHits()
        assertThat(allHits).contains(hit)
    }

}