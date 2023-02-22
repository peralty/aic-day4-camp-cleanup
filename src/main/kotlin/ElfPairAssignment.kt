data class ElfPairAssignment(
    val assignments: Pair<List<Int>, List<Int>>
) {
    fun oneAssignmentFullyContainsOtherAssignment(): Boolean {
        return assignments.second.containsAll(assignments.first) || assignments.first.containsAll(assignments.second)
    }

    fun oneAssignmentPartlyContainsOtherAssignment(): Boolean {
        return assignments.first.any { it in assignments.second }
    }
}
