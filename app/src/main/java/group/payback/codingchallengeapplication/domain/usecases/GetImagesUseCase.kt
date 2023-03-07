package group.payback.codingchallengeapplication.domain.usecases

import group.payback.codingchallengeapplication.domain.models.ImagesResponse
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow

interface GetImagesUseCase {
    operator fun invoke(word: String): Flow<NetworkResult<ImagesResponse>>
}