package group.payback.codingchallengeapplication.data.repositories

import group.payback.codingchallengeapplication.R
import group.payback.codingchallengeapplication.data.local.LocalDataSource
import group.payback.codingchallengeapplication.data.local.ToImagesResponsedata
import group.payback.codingchallengeapplication.data.local.entities.HitSearchCrossRef
import group.payback.codingchallengeapplication.data.local.toHitDomain
import group.payback.codingchallengeapplication.data.remote.RemoteDataSource
import group.payback.codingchallengeapplication.data.remote.toImagesResponse
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.models.ImagesResponse
import group.payback.codingchallengeapplication.domain.toListHit
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ImagesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : ImagesRepository {

    override fun getImages(word: String): Flow<NetworkResult<ImagesResponse>> = flow {
        emit(NetworkResult.Loading())

        val getLocalImagesFromDAO = localDataSource.getImagesFromDAO(word)
        val empty = listOfNotNull<Any>(getLocalImagesFromDAO)
        if (getLocalImagesFromDAO != null) {
            emit(NetworkResult.Success(data = getLocalImagesFromDAO.ToImagesResponsedata()))
        } else {
            try {
                val requestImagesFromAPI =
                    remoteDataSource.getImagesFromAPI(word).toImagesResponse()

                localDataSource.insertHitsToDAO(requestImagesFromAPI.hits.map { it.toListHit() })
                var searchID = localDataSource.insertSearchToDAO(word)

                requestImagesFromAPI.hits.map {
                    localDataSource.insertHitSearchCrossRefToDAO(HitSearchCrossRef(searchID.toInt(), it.toListHit().id))
                }

                emit(NetworkResult.Success(requestImagesFromAPI))

            }catch (e: HttpException) {
                emit(
                    NetworkResult.Error(
                        message = R.string.msgInternetConnectionError.toString(), data = getLocalImagesFromDAO
                    )
                )
            }catch (e: IOException) {
                emit(
                    NetworkResult.Error(
                        message = R.string.msgError.toString(),
                        data = getLocalImagesFromDAO
                    )
                )
            }
        }

    }

}