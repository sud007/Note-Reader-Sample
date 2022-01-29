package win.ca.demo.myapplication.data.api.model.response.base

open class BaseResponse(
    val success: Boolean = false,
    val error: String? = null,
    val errorCode: Int = 0
)