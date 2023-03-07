package group.payback.codingchallengeapplication.data.repositories

import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.models.ImagesResponse
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ImagesRepository {
    fun getImages(word: String): Flow<NetworkResult<ImagesResponse>>
}