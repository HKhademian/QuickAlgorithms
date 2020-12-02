//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

package Longest_Palindromic_Subsequence

import utils.Array2D
import utils.maxByOrNull

fun main() {
	println("Longest Palindromic Subsequence via DP")
	while (true) {
		val inp = readLine()!!
		println(LPSubSeq_DP(inp))
	}
}

fun LPSubSeq_DP(X: String): String {
	val lookup = Array2D(rows = X.length + 1, cols = X.length + 1) { _, _ -> "" }
	(0 until X.length).reversed().forEach { i ->
		val x = X[i]
		(i until X.length).forEach { j ->
			val y = X[j]
			lookup[i][j] = when {
				i == j -> x.toString()
				x == y -> x + lookup[i + 1][j - 1] + x
				else -> maxByOrNull(
					lookup[i + 1][j],
					lookup[i][j - 1],
				) { it.length }!!
			}
		}
	}
	return lookup[0][X.length - 1]
}
