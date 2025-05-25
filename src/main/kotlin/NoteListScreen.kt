class NoteListScreen(
    private val archive: Archive,
    private val push: (Screen) -> Unit,
    private val pop: () -> Unit
) : ListScreen<Note>(
    title = "Заметки архива: ${archive.name}",
    items = archive.notes,
    createItemLabel = "Создать заметку",
    onCreate = { push(CreateNoteScreen(archive, pop)) },
    onItemSelected = { note -> push(ViewNoteScreen(note, pop)) },
    onBack = { pop() },
    itemToString = { it.title }
)