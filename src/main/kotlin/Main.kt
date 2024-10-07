import java.util.Scanner

fun main(args: Array<String>) {
    val mainMenu = MainMenu("архивов")
    mainMenu.start()
}

fun createArchive():Archive {
    println("Введите название архива")
    val scanner = Scanner(System.`in`)
    val inputTitle = scanner.nextLine().trim()
    println("Архив $inputTitle создан")
    return Archive(inputTitle)
}

fun createNote() :Note {
    val scanner = Scanner(System.`in`)
    println("Введите название заметки")
    val inputTitle = scanner.nextLine().trim()
    println("Введите текст заметки")
    val inputText = scanner.nextLine().trim()
    println("Заметка $inputTitle создана")
    return  Note(inputTitle,inputText)
}