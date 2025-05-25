class ViewNoteScreen(
    private val note: Note,
    private val pop: () -> Unit
) : Screen {
    override fun show() {
        println("Заголовок: ${note.title}")
        println("Содержание: ")
        println(note.content)
        println()
        println("Нажмите Enter для возврата.")
        scanner.nextLine()
        scanner.nextLine()
        pop()
    }
}