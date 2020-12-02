//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Common_SubSequence

import utils.Array2D
import utils.maxByOrNull

fun main() {
	println("Longest Common SubSequence via DP : lookup holds answer")
	while (true) {
		val X = readLine()!! // ABCBDAB
		val Y = readLine()!! // BDCABA
		val res = LCSubSeq_DP(X, Y)
		println(res)
	}
}

fun LCSubSeq_DP(X: String, Y: String): String {
	val lookup = Array2D(rows = X.length + 1, cols = Y.length + 1) { _, _ -> "" }
	(1..X.length).forEach { i ->
		val x = X[i - 1]
		(1..Y.length).forEach { j ->
			val y = Y[j - 1]
			lookup[i][j] = if (x == y)
				lookup[i - 1][j - 1] + x
			else
				maxByOrNull(lookup[i][j - 1], lookup[i - 1][j]) { it.length }!!
		}
	}
	return lookup[X.length][Y.length]
}
