package win.ca.demo.myapplication.data.api.manager

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import win.ca.demo.myapplication.data.api.service.NoteService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiProvider {

    @Provides
    fun getService(retrofit: Retrofit): NoteService {
        return retrofit.create(NoteService::class.java)
    }
}