fun main(commandLineArguments: Array<String>) {
  val sourceText = if (commandLineArguments.isEmpty()) {
    readFromStandardInput()
  } else {
    commandLineArguments.joinToString(separator = " ")
  }

  val allWords = sourceText
    .split(Regex("\\s+"))
    .filter { word -> word.isNotEmpty() }

  val wordToOccurrenceCount = allWords.groupingBy { word -> word }.eachCount()

  val entriesSortedByFrequencyThenAlphabet = wordToOccurrenceCount.entries.sortedWith(
    compareByDescending<Map.Entry<String, Int>> { entry -> entry.value }
      .thenBy { entry -> entry.key }
  )

  for ((word, occurrenceCount) in entriesSortedByFrequencyThenAlphabet) {
    println("$word $occurrenceCount")
  }
}

fun readFromStandardInput(): String {
  return System.`in`.bufferedReader().readText()
}
