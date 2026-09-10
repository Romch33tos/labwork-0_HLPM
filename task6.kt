fun main(commandLineArguments: Array<String>) {
  val sourceText = if (commandLineArguments.isEmpty()) {
    readFromStandardInput()
  } else {
    commandLineArguments.joinToString(separator = " ")
  }

  val allWords = sourceText
    .split(Regex("\\s+"))
    .filter { word -> word.isNotEmpty() }
}

fun readFromStandardInput(): String {
  return System.`in`.bufferedReader().readText()
}
