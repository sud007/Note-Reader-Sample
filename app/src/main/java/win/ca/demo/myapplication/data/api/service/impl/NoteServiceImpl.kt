package win.ca.demo.myapplication.data.api.service.impl

import retrofit2.Call
import retrofit2.Retrofit
import win.ca.demo.myapplication.data.api.manager.ApiProvider
import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import win.ca.demo.myapplication.data.api.service.NoteService
import javax.inject.Inject

class NoteServiceImpl @Inject constructor(
    private val retrofit: Retrofit,
    private val manager: ApiProvider
) : NoteService {
    override  fun fetchNotes(): Call<NoteResponse>? {
        return manager.getService(retrofit).fetchNotes()
    }
}