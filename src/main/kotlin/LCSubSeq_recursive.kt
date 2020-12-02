//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

package Longest_Common_Subsequence

fun main() {
	println("Longest Common Subsequence via Recursive")
	while (true) {
		println(LCSubSeq_Req(readLine()!!, readLine()!!))
	}
}

fun LCSubSeq_Req(X: String, Y: String): String = when {
	X.isEmpty() || Y.isEmpty() -> ""
	X.last() == Y.last() -> LCSubSeq_Req(X.dropLast(1), Y.dropLast(1)) + X.last()
	else -> listOf(
		LCSubSeq_Req(X.dropLast(1), Y),
		LCSubSeq_Req(X, Y.dropLast(1)),
	).maxByOrNull { it.length }!!
}
