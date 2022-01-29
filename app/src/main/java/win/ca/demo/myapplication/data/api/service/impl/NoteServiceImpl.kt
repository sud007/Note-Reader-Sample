package win.ca.demo.myapplication.data.api.service.impl

import retrofit2.Call
import win.ca.demo.myapplication.data.api.manager.NoteApiManager
import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import win.ca.demo.myapplication.data.api.service.NoteService
import javax.inject.Inject

class NoteServiceImpl @Inject constructor(private val manager: NoteApiManager) : NoteService {
    override fun fetchNotes(): Call<NoteResponse>? {
        return manager.getService().fetchNotes()
    }
}