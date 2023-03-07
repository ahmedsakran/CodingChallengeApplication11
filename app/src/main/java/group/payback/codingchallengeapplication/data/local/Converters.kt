package group.payback.codingchallengeapplication.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import group.payback.codingchallengeapplication.data.util.JsonParser
import group.payback.codingchallengeapplication.domain.models.ImagesResponse

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromImagesResponseJson(json: String): List<ImagesResponse> {
        return jsonParser.fromJson<ArrayList<ImagesResponse>>(
            json,
            object : TypeToken<ArrayList<ImagesResponse>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toImagesResponseJson(meanings: List<ImagesResponse>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<ImagesResponse>>(){}.type
        ) ?: "[]"
    }
}