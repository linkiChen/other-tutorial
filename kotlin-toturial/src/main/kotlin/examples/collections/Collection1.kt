package main.kotlin.examples.collections

fun main() {
    println("********************* List ********************")
    collection_list()
    println("\n********************* Set ********************")
    collection_set()
    println("\n********************* Map ********************")
    collection_map()
}

/********************* List ********************/
fun collection_list() {
    addSudoer(4)
    println("Tot sudoers: ${getSystemSudoers().size}")
    getSystemSudoers().forEach { i -> println("Some useful info on user $i") }

}

val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
// List是只读列表
val sudoers: List<Int> = systemUsers

fun addSudoer(newUsr: Int) {
    systemUsers.add(newUsr)
}

fun getSystemSudoers(): List<Int> {
    return sudoers
}

/********************* Set ********************/

fun collection_set() {
    val newLang: String = "Java"
    val issueAlreadyIn: String = "Scala"

    println("Issue $newLang ${getStatusLog(addIssue(newLang))}")
    println("Issue $issueAlreadyIn ${getStatusLog(addIssue(issueAlreadyIn))}")
}

val openIssues: MutableSet<String> = mutableSetOf("Kotlin", "Scala", "Python")

fun addIssue(lang: String): Boolean = openIssues.add(lang)

fun getStatusLog(isAdded: Boolean): String = if (isAdded) "registered correctly" else "marked as duplicate and rejected"

/********************* Map ********************/

fun collection_map() {
    accountsReport()
    updatePointsCrdit(1)
    updatePointsCrdit(1)
    updatePointsCrdit(5)
    accountsReport()
}

const val POINTS_X_PASS: Int = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
// 将可修改的map转为只读的map
val EZPassReport: Map<Int, Int> = EZPassAccounts

fun updatePointsCrdit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {
        println("Updating $accountId ...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS
    } else {
        println("Error:Trying to update a non-existing account (id:$accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach { k, v -> println("Id $k: credit $v") }
}