package np.com.ravikant.hamrobill.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import np.com.ravikant.hamrobill.data.local.dao.NoteDao
import np.com.ravikant.hamrobill.data.mapper.asExternalModel
import np.com.ravikant.hamrobill.data.mapper.toEntity
import np.com.ravikant.hamrobill.domain.model.Note
import np.com.ravikant.hamrobill.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
            .map { notes ->
                notes.map {
                    it.asExternalModel()
                }
            }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.asExternalModel()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note.toEntity())
    }
}