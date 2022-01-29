package win.ca.demo.myapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import win.ca.demo.myapplication.domain.usecase.GetNotesUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(
   application: Application,
   private val useCase: GetNotesUseCase) : AndroidViewModel(application) {

   fun  fetchNotes() {
      viewModelScope.launch {

      }
   }

}