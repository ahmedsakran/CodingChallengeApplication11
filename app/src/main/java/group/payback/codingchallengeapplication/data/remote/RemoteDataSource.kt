package group.payback.codingchallengeapplication.data.remote

import group.payback.codingchallengeapplication.util.Constants
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: ImagesListApi,
) {

    suspend fun getImagesFromAPI(word: String) = api.getImages(applyQueries(word))

    private fun applyQueries(word: String): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        //region set Query Keys
        queries[Constants.QUERY_API_KEY] = Constants.API_KEY
        queries[Constants.QUERY_Searched_Word] = word
        queries[Constants.QUERY_Image_Type] = "photo"
        queries[Constants.QUERY_Pretty] = "true"
        //endregion
        return queries
    }
}