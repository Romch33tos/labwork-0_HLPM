fun main(commandLineArguments: Array<String>) {
  for (argument in commandLineArguments) {
    val words = argument.split(Regex("\\s+"))
    for (word in words) {
      if (word.isNotEmpty()) {
        println(word)
      }
    }
  }
}
