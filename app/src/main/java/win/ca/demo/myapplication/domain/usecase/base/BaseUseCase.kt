package win.ca.demo.myapplication.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import win.ca.demo.myapplication.data.api.model.response.base.Failure
import win.ca.demo.myapplication.data.arch.Either

/**
 * Created by Sudhanshu Singh on 29/01/22.
 */
abstract class BaseUseCase<out T, in P> {
    abstract suspend fun callApi(request: P?): Either<Failure, T>

    open operator fun invoke(
        scope: CoroutineScope,
        request: P?,
        onResult: (Either<Failure, T>) -> Unit = {}
    ) {
        val job = scope.async { callApi(request) }
        scope.launch { onResult(job.await()) }
    }
}