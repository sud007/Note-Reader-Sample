package win.ca.demo.myapplication.data.api.model.response

import kotlinx.serialization.Serializable
import win.ca.demo.myapplication.data.helper.EMPTY

/**
 * Created by Sudhanshu Singh on 29/01/22.
 */
@Serializable
data class ErrorResponse(val errorCode: String?, val errorMsg: String? = EMPTY)