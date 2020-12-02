//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Common_SubSequence

import utils.maxByOrNull

fun main() {
	println("Longest Common Subsequence via Recursive")
	while (true) {
		val X = readLine()!! // ABCBDAB
		val Y = readLine()!! // BDCABA
		val res = LCSubSeq_Req(X, Y)
		println(res)
	}
}

fun LCSubSeq_Req(X: String, Y: String): String = when {
	X.isEmpty() || Y.isEmpty() -> ""
	X.last() == Y.last() -> LCSubSeq_Req(X.dropLast(1), Y.dropLast(1)) + X.last()
	else -> maxByOrNull(
		LCSubSeq_Req(X.dropLast(1), Y),
		LCSubSeq_Req(X, Y.dropLast(1)),
	) { it.length }!!
}
