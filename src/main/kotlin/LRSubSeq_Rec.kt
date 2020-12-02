//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Repeated_SubSequence

import utils.maxByOrNull

fun main() {
	println("Longest Repeated SubSequence via Recursive")
	while (true) {
		val X = readLine()!! //ATACTCGGA
		val res = LRSubSeq_Req(X, X.length - 1, X.length - 1)
		println(res)
	}
}

fun LRSubSeq_Req(X: String, i: Int, j: Int): String = when {
	i > j || i < 0 || j < 0 -> ""
	X[i] == X[j] && i != j -> LRSubSeq_Req(X, i - 1, j - 1) + X[i]
	else ->
		maxByOrNull(
			LRSubSeq_Req(X, i - 1, j),
			LRSubSeq_Req(X, i, j - 1),
		) { it.length }!!
}
