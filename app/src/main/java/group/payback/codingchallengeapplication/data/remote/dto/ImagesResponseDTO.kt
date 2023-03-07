package group.payback.codingchallengeapplication.data.remote.dto


data class ImagesResponseDTO(
    val total: Int,
    val totalHits: Int,
    val hits: List<HitDTO>
)