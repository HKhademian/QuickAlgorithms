//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Repeated_SubSequence

import utils.Array2D
import utils.maxByOrNull

fun main() {
	println("Longest Repeated SubSequence via DP")
	while (true) {
		val X = readLine()!! //ATACTCGGA
		val res = LRSubSeq_DP(X)
		println(res)
	}
}

fun LRSubSeq_DP(X: String): String {
	val lookup = Array2D(rows = X.length + 1, cols = X.length + 1) { _, _ -> "" }
	(1..X.length).forEach { i ->
		val x = X[i - 1]
		(i..X.length).forEach { j ->
			val y = X[j - 1]
			lookup[i][j] = when {
				x == y && i != j -> lookup[i - 1][j - 1] + x
				else -> maxByOrNull(
					lookup[i - 1][j],
					lookup[i][j - 1],
				) { it.length }!!
			}
		}
	}
	return lookup[X.length][X.length]
}
