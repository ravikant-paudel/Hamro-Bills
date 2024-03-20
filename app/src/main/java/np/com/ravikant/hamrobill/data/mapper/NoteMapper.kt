package np.com.ravikant.hamrobill.data.mapper

import np.com.ravikant.hamrobill.data.local.entity.NoteEntity
import np.com.ravikant.hamrobill.domain.model.Note

fun NoteEntity.asExternalModel(): Note = Note(
    id, title, content
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id, title, content
)