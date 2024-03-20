package np.com.ravikant.hamrobill.data.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import np.com.ravikant.hamrobill.data.local.NoteDatabase
import np.com.ravikant.hamrobill.data.repository.NoteRepositoryImpl
import np.com.ravikant.hamrobill.domain.repository.NoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase =
        databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.name
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(dao = database.dao)
}