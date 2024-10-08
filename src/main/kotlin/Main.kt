import java.util.Scanner

fun main(args: Array<String>) {
    val mainMenu = MainMenu("архивов")
    mainMenu.start()
}

fun createArchive(): Archive {
    val inputTitle = readString("Введите название архива","Название не должно быть пустым" )

    println("Архив \"$inputTitle\" создан")
    return Archive(inputTitle)
}

fun createNote(): Note {
    val inputTitle = readString ("Введите название заметки","Название не должно быть пустым")
    val inputText = readString ("Введите текст заметки","Текст заметки не должен быть пустым")

    println("Заметка \"$inputTitle\" создана")
    return Note(inputTitle, inputText)
}

fun readString(prompt:String, error:String ): String {
    val scanner = Scanner(System.`in`)
    while (true) {
        println(prompt)
        val input = scanner.nextLine().trim()
        if (input.isBlank())
            println(error)
        else
            return input
    }
}
