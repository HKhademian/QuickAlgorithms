//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

package Longest_Palindromic_Subsequence

import utils.maxByOrNull

fun main() {
	println("Longest Palindromic Subsequence via Recursive")
	while (true) {
		val inp = readLine()!!
		println(LPSubSeq_Req(inp, 0, inp.length - 1))
	}
}

fun LPSubSeq_Req(X: String, i: Int, j: Int): String = when {
	i > j -> ""
	i == j -> X[i].toString()
	X[i] == X[j] -> X[j] + LPSubSeq_Req(X, i + 1, j - 1) + X[j]
	else -> maxByOrNull(
		LPSubSeq_Req(X, i + 1, j),
		LPSubSeq_Req(X, i, j - 1),
	) { it.length }!!
}
