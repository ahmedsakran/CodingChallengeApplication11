package group.payback.codingchallengeapplication.data.repositories

import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ImageDetailsRepository {
    fun getImageDetails(imageID: Int): Flow<NetworkResult<Hit>>
}