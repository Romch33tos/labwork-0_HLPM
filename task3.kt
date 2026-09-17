fun main(commandLineArguments: Array<String>) {
  val allWords = commandLineArguments
    .flatMap { argument -> argument.split(Regex("\\s+")) }
    .filter { word -> word.isNotEmpty() }

  val uniqueSortedWords = allWords.distinct().sorted()

  for (word in uniqueSortedWords) {
    println(word)
  }
}
