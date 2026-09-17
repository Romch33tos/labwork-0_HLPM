fun main(commandLineArguments: Array<String>) {
  val allWords = commandLineArguments
    .flatMap { argument -> argument.split(Regex("\\s+")) }
    .filter { word -> word.isNotEmpty() }

  val wordCounts = allWords.groupingBy { word -> word }.eachCount()

  val sortedWords = wordCounts.keys.sorted()

  for (word in sortedWords) {
    val count = wordCounts.getValue(word)
    println("$word $count")
  }
}
