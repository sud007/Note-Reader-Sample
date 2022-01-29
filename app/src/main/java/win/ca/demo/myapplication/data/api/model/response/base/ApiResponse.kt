package win.ca.demo.myapplication.data.api.model.response.base

sealed class ApiResponse<T> {
    data class Success<T>(val data: T?) : ApiResponse<T>()
    data class Error<T>(val errors: List<Failure>) : ApiResponse<T>()
}

data class Failure(
    val code: String,
    val message: String = "Something went wrong",
    val exception: Exception? = null
) {
    companion object {
        val NoResponse = Failure(
            "0",
            "No Api response returned"
        )
    }
}

fun <T> getADefaultErrorAsSample() =
    ApiResponse.Error<T>(listOf(Failure("500", "No Api response returned", null)))