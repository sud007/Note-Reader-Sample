package win.ca.demo.myapplication.data.api.model.response.base

/**
 * Created by Sudhanshu Singh on 29/01/22.
 */
sealed class ResponseState<out T> {
    object Loading : ResponseState<Nothing>()
    object Initial : ResponseState<Nothing>()
    data class Error(val failure: Failure) : ResponseState<Nothing>()
    data class Success<T>(val item: T) : ResponseState<T>()
}