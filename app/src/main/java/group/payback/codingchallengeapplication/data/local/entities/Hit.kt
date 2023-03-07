package group.payback.codingchallengeapplication.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import group.payback.codingchallengeapplication.data.remote.dto.HitDTO
import group.payback.codingchallengeapplication.domain.models.Hit

@Entity
data class Hit(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val collections: Int,
    val comments: Int,
    val downloads: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val type: String,
    val user: String,
    val userImageURL: String,
    val user_id: Int,
    val views: Int,
    val webformatHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int
)
