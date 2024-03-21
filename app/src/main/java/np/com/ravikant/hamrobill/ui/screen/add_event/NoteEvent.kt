package np.com.ravikant.hamrobill.ui.screen.add_event

sealed interface NoteEvent {
    data class TitleChange(val value: String): NoteEvent
    data class ContentChange(val value: String): NoteEvent
    data object Save : NoteEvent
//    data object NavigateBack : NoteEvent
    data object DeleteNote : NoteEvent
}