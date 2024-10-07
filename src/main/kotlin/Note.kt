class Note(title: String, private val text: String) : Archive(title) {
    override fun start() {
        end = false
        println("Название заметки:\n $title")
        println("Текст заметки: \n $text")
        while (!end) {
            println("\nВведите 0 для выхода:")
            if (readInput() == 0) end = true
        }
    }
}
