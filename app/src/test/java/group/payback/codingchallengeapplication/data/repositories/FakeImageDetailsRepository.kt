package group.payback.codingchallengeapplication.data.repositories

import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeImageDetailsRepository: ImageDetailsRepository {

    //region prepare fake data and inject to table

    val hitToInsert : Hit = Hit(
        1,
        1,
        2,
        3,
        4,
        5,
        6,
        "path here1 Of Green Search",
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

    //endregion

    override fun getImageDetails(imageID: Int): Flow<NetworkResult<Hit>> {
        return flow { emit(NetworkResult.Success(data = hitToInsert)) }
    }
}