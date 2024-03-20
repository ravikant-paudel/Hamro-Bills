package np.com.ravikant.hamrobill.domain.repository

import kotlinx.coroutines.flow.Flow
import np.com.ravikant.hamrobill.domain.model.Note

interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun updateNote(note: Note)
}