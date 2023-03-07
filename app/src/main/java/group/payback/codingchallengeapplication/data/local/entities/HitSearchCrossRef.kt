package group.payback.codingchallengeapplication.data.local.entities

import androidx.room.Entity

@Entity(primaryKeys = ["searchID", "id"])
data class HitSearchCrossRef(
    var searchID: Int,
    var id: Int,
)
