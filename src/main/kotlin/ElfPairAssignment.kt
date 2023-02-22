data class ElfPairAssignment(
    val assignments: Pair<List<Int>, List<Int>>
) {
    fun oneAssignmentContainsOtherAssignment(): Boolean {
        return assignments.second.containsAll(assignments.first) || assignments.first.containsAll(assignments.second)
    }
}
