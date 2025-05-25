class CreateArchiveScreen(
    private val archive: MutableList<Archive>,
    private val pop: () -> Unit
) : Screen {
    override fun show() {
        println("Введите название архива: ")
        scanner.nextLine()
        val name = scanner.nextLine().trim()
        if (name.isNotEmpty()) {
            archive.add(Archive(name, mutableListOf()))
            println("Архив $name создан")
        } else {
            println("Название не может быть пустым")
        }
        pop()
    }
}
