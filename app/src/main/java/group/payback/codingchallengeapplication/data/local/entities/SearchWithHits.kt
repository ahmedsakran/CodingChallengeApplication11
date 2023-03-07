package group.payback.codingchallengeapplication.data.local.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import group.payback.codingchallengeapplication.domain.models.ImagesResponse

data class SearchWithHits(
    @Embedded val search: Search,
    @Relation(
        parentColumn = "searchID",
        entityColumn = "id",
        associateBy = Junction(HitSearchCrossRef::class)
    )
    val hits: List<Hit>
)
