package np.com.ravikant.hamrobill.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import np.com.ravikant.hamrobill.data.local.dao.NoteDao
import np.com.ravikant.hamrobill.data.local.entity.NoteEntity

@Database(
    version = 1,
    entities = [NoteEntity::class]
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val dao: NoteDao

    companion object {
        const val name = "note_db"
    }
}