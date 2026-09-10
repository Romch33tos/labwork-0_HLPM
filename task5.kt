fun main(commandLineArguments: Array<String>) {
  val allWords = commandLineArguments
    .flatMap { argument -> argument.split(Regex("\\s+")) }
    .filter { word -> word.isNotEmpty() }

  val wordToOccurrenceCount = allWords.groupingBy { word -> word }.eachCount()

  val sortedEntries = wordToOccurrenceCount.entries.sortedWith(
    compareByDescending<Map.Entry<String, Int>> { entry -> entry.value }
      .thenBy { entry -> entry.key }
  )

  for ((word, occurrenceCount) in sortedEntries) {
    println("$word $occurrenceCount")
  }
}
