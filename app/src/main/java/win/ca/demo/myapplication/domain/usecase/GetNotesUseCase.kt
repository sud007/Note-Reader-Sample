package win.ca.demo.myapplication.domain.usecase

import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import win.ca.demo.myapplication.data.api.model.response.base.ApiResponse
import win.ca.demo.myapplication.data.api.model.response.base.Failure
import win.ca.demo.myapplication.data.arch.Either
import win.ca.demo.myapplication.data.repo.NotesRepository
import win.ca.demo.myapplication.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val repository: NotesRepository) : BaseUseCase<NoteResponse?, Any>() {

    override suspend fun callApi(request: Any?): Either<Failure, NoteResponse?> {
        return when (val response = repository.fetchNotes()) {
            is ApiResponse.Success -> Either.Right(response.data)
            is ApiResponse.Error -> Either.Left(response.errors[0])
            else -> Either.Left(Failure.NoResponse)
        }

    }
}