package group.payback.codingchallengeapplication.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Search(
    @PrimaryKey(autoGenerate = true)
    var searchID: Int,
    val wordQuery: String,
)