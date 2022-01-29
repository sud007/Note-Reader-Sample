package win.ca.demo.myapplication.data.api.service


import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET
import win.ca.demo.myapplication.data.api.NOTES
import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import javax.inject.Singleton


interface NoteService {
    @Singleton
    @Provides
    @GET(NOTES)
    fun fetchNotes(): Call<NoteResponse>?
}