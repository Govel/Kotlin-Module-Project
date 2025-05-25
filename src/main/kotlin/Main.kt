import java.util.Scanner
val scanner = Scanner(System.`in`)

class Main {
    private val archive = mutableListOf<Archive>()
    private val screenStack = ArrayDeque<Screen>()

    fun start() {
        screenStack.add(ArchiveListScreen(archive, ::pushScreen, ::popScreen))
        while (screenStack.isNotEmpty()) {
            screenStack.last().show()
        }
    }
    private fun pushScreen(screen: Screen) {
        screenStack.add(screen)
    }
    private fun popScreen() {
        if (screenStack.isNotEmpty()) {
            screenStack.removeLast()
        }
    }
}

fun main() {
    Main().start()
}



