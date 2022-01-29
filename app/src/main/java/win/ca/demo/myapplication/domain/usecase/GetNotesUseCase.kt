package win.ca.demo.myapplication.domain.usecase

import win.ca.demo.myapplication.data.repo.NotesRepository
import win.ca.demo.myapplication.data.api.model.response.NoteResponse

class GetNotesUseCase(private val repository: NotesRepository) {

    suspend fun fetchNotes(): NoteResponse? {
        return repository.fetchNotes()
    }
}