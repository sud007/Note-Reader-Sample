package win.ca.demo.myapplication.data.api.manager

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import win.ca.demo.myapplication.data.api.service.NoteService
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NoteApiManager @Inject constructor(private val retrofit: Retrofit) {

    @Singleton
    @Provides
    fun getService(): NoteService {
        return retrofit.create(NoteService::class.java)
    }
}