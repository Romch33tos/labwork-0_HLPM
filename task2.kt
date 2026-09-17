fun main(commandLineArguments: Array<String>) {
  val allWords = commandLineArguments
    .flatMap { argument -> argument.split(Regex("\\s+")) }
    .filter { word -> word.isNotEmpty() }

  val sortedWords = allWords.sorted()

  for (word in sortedWords) {
    println(word)
  }
}
