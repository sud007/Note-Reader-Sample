package win.ca.demo.myapplication.data.api.service


import retrofit2.Call
import retrofit2.http.GET
import win.ca.demo.myapplication.data.api.NOTES
import win.ca.demo.myapplication.data.api.model.response.NoteResponse


interface NoteService {

    @GET(NOTES)
     fun fetchNotes(): Call<NoteResponse>?
}