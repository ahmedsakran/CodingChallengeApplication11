package group.payback.codingchallengeapplication.data.repositories

import group.payback.codingchallengeapplication.R
import group.payback.codingchallengeapplication.data.local.LocalDataSource
import group.payback.codingchallengeapplication.data.local.toHitDomain
import group.payback.codingchallengeapplication.data.remote.RemoteDataSource
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class ImageDetailsRepositoryImpl (
    private val localDataSource: LocalDataSource,
) : ImageDetailsRepository {

    override fun getImageDetails(imageID: Int): Flow<NetworkResult<Hit>> = flow {
        emit(NetworkResult.Loading())
        val getImageDetailsByIDFromDAO =
            localDataSource.getImageDetailsFromDAO(imageID).toHitDomain()
        try {
            emit(NetworkResult.Success(data = getImageDetailsByIDFromDAO))
        } catch (e: IOException) {
            emit(
                NetworkResult.Error(
                    message = R.string.msgError.toString(),
                    data = getImageDetailsByIDFromDAO
                )
            )
        }

    }

}