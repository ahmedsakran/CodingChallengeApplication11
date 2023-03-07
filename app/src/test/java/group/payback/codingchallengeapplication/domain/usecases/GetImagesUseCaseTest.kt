package group.payback.codingchallengeapplication.domain.usecases

import com.google.common.truth.Truth.assertThat
import group.payback.codingchallengeapplication.data.repositories.FakeImagesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetImagesUseCaseTest {

    private lateinit var getImagesUseCase: GetImagesUseCaseImpl
    private lateinit var fakeImagesRepository: FakeImagesRepository

    @Before
    fun setUp(){
        fakeImagesRepository = FakeImagesRepository()
        getImagesUseCase = GetImagesUseCaseImpl(fakeImagesRepository)
    }

    @Test
    fun `Get Images List, correct Images list return` (): Unit = runBlocking{
        val images = getImagesUseCase("Green").first()
        assertThat((images.data?.hits?.get(0)?.largeImageURL.equals("path here1 Of Green Search"))).isTrue()
    }

    @Test
    fun `Get Images List, incorrect Images list return` (): Unit = runBlocking{
        val images = getImagesUseCase("Green").first()
        assertThat((images.data?.hits?.get(0)?.largeImageURL.equals("Wrong large Image URL"))).isFalse()
    }

}