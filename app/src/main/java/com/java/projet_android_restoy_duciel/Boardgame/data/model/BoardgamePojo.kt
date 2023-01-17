package fr.upjv.ccm.tp1.model

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.java.projet_android_restoy_duciel.Boardgame.domain.model.BoardgameDomain
import java.lang.reflect.Type

sealed class MyObjectForRecyclerView()


data class BGList(
    @SerializedName("games") var games: ArrayList<Boardgame>,
    @SerializedName("count") var count: Int
)

data class Boardgame(
    @SerializedName("name")
    val name : String,

    @SerializedName("price")
    val price : Double,

    @SerializedName("description")
    val desc: String,

    @SerializedName("thumb_url")
    val image: String,

    @SerializedName("primary_publisher")
    @JsonAdapter(PublisherSerializer::class)
    val category: String

):MyObjectForRecyclerView()

@Entity(tableName = "boardgame_object_table")
data class BoardgameRoom(
    val name : String,
    val price : Double,
    val desc: String,
    val category: String,
    val date_added: Long,
    val image: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
class PublisherSerializer : JsonDeserializer<String?> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): String {
        if (json.asJsonObject["name"] == null){
            return "Non renseigné"
        }
        return json.asJsonObject["name"].asString
    }
}