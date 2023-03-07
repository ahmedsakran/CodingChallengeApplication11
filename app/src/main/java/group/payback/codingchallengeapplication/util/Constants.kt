package group.payback.codingchallengeapplication.util

class Constants {
    companion object {
        const val BASE_URL = "https://pixabay.com/api/"
        const val API_KEY = "33262037-3922b566c6059fcd8e6a2da6f"

        // API Query Keys
        const val QUERY_API_KEY = "key"
        const val QUERY_Searched_Word = "q"
        const val QUERY_Image_Type = "image_type"
        const val QUERY_Pretty = "pretty"

        // ROOM Database
        const val DATABASE_NAME = "Images_Cache_DB"
        const val TABLE_SearchLog = "Search_Log"
        const val TABLE_ImagesResponse = "Images_Response"
        const val TABLE_Hit = "Hit"
    }
}