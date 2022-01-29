package win.ca.demo.myapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import win.ca.demo.myapplication.data.api.model.response.NoteResponse
import win.ca.demo.myapplication.data.api.model.response.base.Failure
import win.ca.demo.myapplication.data.api.model.response.base.ResponseState
import win.ca.demo.myapplication.domain.usecase.GetNotesUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val useCase: GetNotesUseCase
) : AndroidViewModel(application) {

    private val _notesListLiveData =
        MutableLiveData<ResponseState<NoteResponse?>?>(ResponseState.Initial)
    val notesListLiveData: LiveData<ResponseState<NoteResponse?>?>
        get() = _notesListLiveData

    init {
        fetchNotes()
    }

    private fun fetchNotes() {
        useCase.invoke(
            viewModelScope,
            null
        ) { it.either(::handleFailure, ::handleSuccess) }
    }

    private fun handleSuccess(response: NoteResponse?) {
        _notesListLiveData.postValue(ResponseState.Success(response))
    }

    private fun handleFailure(apiError: Failure) {
        _notesListLiveData.postValue(ResponseState.Error(apiError))
    }

}