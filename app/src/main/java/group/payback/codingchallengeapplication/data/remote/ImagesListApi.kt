package group.payback.codingchallengeapplication.data.remote

import group.payback.codingchallengeapplication.data.remote.dto.ImagesResponseDTO
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ImagesListApi {
    @GET("?")
    suspend fun getImages(@QueryMap queries: Map<String, String>): ImagesResponseDTO
}