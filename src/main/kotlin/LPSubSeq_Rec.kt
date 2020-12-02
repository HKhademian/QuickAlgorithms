//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Palindromic_SubSequence

import utils.maxByOrNull

fun main() {
	println("Longest Palindromic SubSequence via Recursive")
	while (true) {
		val X = readLine()!!
		val res = LPSubSeq_Req(X, 0, X.length - 1)
		println(res)
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
