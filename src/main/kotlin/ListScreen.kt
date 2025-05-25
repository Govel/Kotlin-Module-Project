import kotlin.system.exitProcess

abstract class ListScreen<T>(
    private val title: String,
    private val isRoot: Boolean = false,
    private val items: List<T>,
    private val createItemLabel: String,
    private val onCreate: () -> Unit,
    private val onItemSelected: (T) -> Unit,
    private val onBack: () -> Unit,
    private val itemToString: (T) -> String
) : Screen {
    private fun readInt(): Int {
        while (!scanner.hasNextInt()) {
            println("Введите число.")
            scanner.next()
        }
        return scanner.nextInt()
    }

    override fun show() {
        while (true) {
            println(title)

            println("0. $createItemLabel")
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${itemToString(item)}")
            }
            println("${items.size + 1}. ${if (isRoot) "Выход" else "Назад"}")
            println("Введите номер: ")

            val input = readInt()
            when (input) {
                0 -> {
                    onCreate()
                    return
                }

                items.size + 1 -> {
                    if (isRoot) {
                        println("Выход из приложения...")
                        exitProcess(0)
                    }
                    onBack()
                    return
                }

                in 1..items.size -> {
                    onItemSelected(items[input - 1])
                    return
                }

                else -> println("Неверный ввод. Попробуйте еще раз.")
            }
        }
    }
}
