class CreateNoteScreen(
    private val archive: Archive,
    private val pop: () -> Unit
) : Screen {
    fun readNonEmpty(context: String): String {
        while (true) {
            println(context)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) return input
            println("Поле не может быть пустым. Попробуйте снова")
        }
    }

    override fun show() {
        scanner.nextLine()
        val title = readNonEmpty("Введите заголовок заметки:")
        val content = readNonEmpty("Введите текст заметки:")
        archive.notes.add(Note(title, content))
        println("Заметка $title добавлена")
        pop()
    }
}
