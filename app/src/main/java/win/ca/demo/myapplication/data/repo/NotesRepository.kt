package win.ca.demo.myapplication.data.repo

import retrofit2.awaitResponse
import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import win.ca.demo.myapplication.data.api.model.response.base.ApiResponse
import win.ca.demo.myapplication.data.api.model.response.base.getADefaultErrorAsSample
import win.ca.demo.myapplication.data.api.service.NoteService
import javax.inject.Inject


class NotesRepository @Inject constructor(private val service: NoteService) {

    suspend fun fetchNotes(): ApiResponse<NoteResponse>? {
        val call = service.fetchNotes()
        val result = call?.awaitResponse()
        return if (result?.isSuccessful == true) {
            ApiResponse.Success(result.body())
        } else {
            getADefaultErrorAsSample()
        }
    }
}