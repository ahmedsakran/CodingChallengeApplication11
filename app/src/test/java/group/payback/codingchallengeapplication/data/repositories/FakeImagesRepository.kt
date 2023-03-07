package group.payback.codingchallengeapplication.data.repositories

import group.payback.codingchallengeapplication.data.local.entities.HitSearchCrossRef
import group.payback.codingchallengeapplication.data.local.entities.Search
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.models.ImagesResponse
import group.payback.codingchallengeapplication.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeImagesRepository: ImagesRepository {

    //region prepare fake data and inject to table

    //region Hit rows to insert
    val hitObj_1 : Hit = Hit(
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

    val hitObj_2 : Hit = Hit(
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

    val hitObj_3 : Hit = Hit(
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

    val hitObj_4 : Hit = Hit(
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

    val hitObj_5 : Hit = Hit(
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
    //endregion
    val hitsToInsert : List<Hit> = listOf<Hit>(hitObj_1, hitObj_2, hitObj_3, hitObj_4, hitObj_5)

    val imagesResponsesToInsert: ImagesResponse = ImagesResponse(3,5,hitsToInsert)

    //endregion

    override fun getImages(word: String): Flow<NetworkResult<ImagesResponse>> {
        return flow { emit(NetworkResult.Success(data = imagesResponsesToInsert)) }
    }
}