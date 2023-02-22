import java.io.File

fun main() {
    val allElfPairAssignments = parseInputToElfPairAssignments()
    var countOfFullyContainingAssignments = 0
    var countOfPartlyContainingAssignments = 0

    allElfPairAssignments.forEach { elfPairAssignment ->
        if (elfPairAssignment.oneAssignmentFullyContainsOtherAssignment()) {
            countOfFullyContainingAssignments += 1
        }
        if (elfPairAssignment.oneAssignmentPartlyContainsOtherAssignment()) {
            countOfPartlyContainingAssignments += 1
        }
    }

    println("Anzahl an Assignment Pairs mit vollständiger Überschneidung: $countOfFullyContainingAssignments")
    println("Anzahl an Assignment Pairs mit teilweiser Überschneidung: $countOfPartlyContainingAssignments")
}

fun parseInputToElfPairAssignments(): List<ElfPairAssignment> {
    val elfPairAssignments = mutableListOf<ElfPairAssignment>()
    val file = File("src/main/resources/input.txt")

    file.forEachLine { line ->
        val parts = line.split(",")
        val sectionRangeFirstElf = parts[0].split("-").map { it.toInt() }
        val sectionRangeSecondElf = parts[1].split("-").map { it.toInt() }
        val assignmentsElfOne = createIntegerList(sectionRangeFirstElf[0], sectionRangeFirstElf[1])
        val assignmentsElfTwo = createIntegerList(sectionRangeSecondElf[0], sectionRangeSecondElf[1])
        elfPairAssignments.add(ElfPairAssignment(Pair(assignmentsElfOne, assignmentsElfTwo)))
    }

    return elfPairAssignments
}

fun createIntegerList(start: Int, end: Int): List<Int> {
    val integerList = mutableListOf<Int>()
    for (i in start..end) {
        integerList.add(i)
    }
    return integerList
}