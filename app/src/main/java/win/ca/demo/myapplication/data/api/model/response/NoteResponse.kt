package win.ca.demo.myapplication.data.api.model.response

import win.ca.demo.myapplication.data.api.model.Note
import win.ca.demo.myapplication.data.api.model.response.base.ApiResponse
import win.ca.demo.myapplication.data.api.model.response.base.BaseResponse

data class NoteResponse(val notes: List<Note>) : BaseResponse()
