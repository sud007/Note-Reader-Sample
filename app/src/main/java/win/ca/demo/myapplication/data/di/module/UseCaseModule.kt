package win.ca.demo.myapplication.data.di.module

import win.ca.demo.myapplication.data.repo.NotesRepository
import win.ca.demo.myapplication.domain.usecase.GetNotesUseCase

/**
 * Created by Sudhanshu Singh on 29/01/22.
 */
//@InstallIn(ViewModelComponent::class)
//@Module
abstract class UseCaseModule {
    //@Binds
    abstract fun getNotesUseCase(repo: NotesRepository): GetNotesUseCase
}