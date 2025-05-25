class ArchiveListScreen(
    private val archives: MutableList<Archive>,
    private val push: (Screen) -> Unit,
    private val pop: () -> Unit
) : ListScreen<Archive>(
    title = "Список архивов:",
    isRoot = true,
    items = archives,
    createItemLabel = "Создать архив",
    onCreate = { push(CreateArchiveScreen(archives, pop))},
    onItemSelected = { archive -> push(NoteListScreen(archive, push, pop)) },
    onBack = { pop() },
    itemToString = { it.name }
)