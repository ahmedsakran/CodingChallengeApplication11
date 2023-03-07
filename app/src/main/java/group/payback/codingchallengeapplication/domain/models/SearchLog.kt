package group.payback.codingchallengeapplication.domain.models

data class SearchLog(
    val wordQuery: String,
    val logs: List<ImagesResponse>,
)