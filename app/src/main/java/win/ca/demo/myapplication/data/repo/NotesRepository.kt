package win.ca.demo.myapplication.data.repo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import win.ca.demo.myapplication.data.api.service.NoteService
import javax.inject.Inject

class NotesRepository @Inject constructor(private val service: NoteService) {

    suspend fun fetchNotes(): NoteResponse? {
        val call = service.fetchNotes()
        var resp: NoteResponse? = null
        call?.enqueue(object : Callback<NoteResponse> {
            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
                resp = response.body()
            }

            override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
                TODO("Handle here with Error Handling layer")
            }

        })

        return resp
    }
}