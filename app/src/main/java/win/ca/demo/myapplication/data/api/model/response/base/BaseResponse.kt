package win.ca.demo.myapplication.data.api.model.response.base

import kotlinx.serialization.Serializable
import win.ca.demo.myapplication.data.api.model.response.ErrorResponse

@Serializable
abstract class BaseResponse {
    var success: Boolean = false
    var message: String? = ""
    var errors: List<ErrorResponse>? = null
    override fun toString(): String {
        return "Success: $success, Message : $message , Errors : $errors"
    }
}