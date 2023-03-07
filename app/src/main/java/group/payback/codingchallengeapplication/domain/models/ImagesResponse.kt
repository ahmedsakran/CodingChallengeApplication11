package group.payback.codingchallengeapplication.domain.models

data class ImagesResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<Hit>,
)