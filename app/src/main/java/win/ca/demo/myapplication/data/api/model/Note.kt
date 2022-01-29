package win.ca.demo.myapplication.data.api.model

import com.google.gson.annotations.SerializedName

data class Note(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String?,
    @SerializedName("from")
    val author: String?,
    @SerializedName("note")
    val detail: String?,
)
