import java.util.Scanner

open class Menu<E : Archive>(
    private val name: String,
    private val type: String,
    val createFun: () -> E
) {
    var end = false
    private var commands: MutableMap<Int, Command> = mutableMapOf()
    private val itemList: MutableList<E> = mutableListOf()

    init {
        createCommands()
    }

    open fun start() {
        end = false
        while (!end) {
            printMenu()
            val c = commands[readNumber()]
            if (c != null) {
                c.lambda.invoke()
                createCommands()
            } else println("Такого пункта нет, введите корректный номер")
        }
    }

    private fun createCommands() {
        val commandMapTitle: MutableMap<Int, Command> = mutableMapOf()
        commandMapTitle[0] = Command("Создать $type") { itemList.add(createFun()) }
        itemList.forEachIndexed { i, item ->
            commandMapTitle[i + 1] = Command("Открыть $type \"${item.title}\"") { item.start() }
        }
        commandMapTitle[itemList.size + 1] = Command("Выход") { end = true }
        commands = commandMapTitle
    }

    private fun printMenu() {
        println("\nВы находитесь в меню $name")
        println("Введите действие:")
        for (k in commands.keys) println(" $k. ${commands[k]?.name}")
    }

    fun readNumber(): Int {
        val scanner = Scanner(System.`in`)
        while (true) {
            val input = scanner.nextLine().toIntOrNull()
            if (input == null) {
                println("Введите число")
                printMenu()
            } else return input
        }
    }
}
