//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

package Longest_Palindromic_SubString

import utils.Array2D
import utils.maxByOrNull

fun main() {
	println("Longest Palindromic SubString via DP")
	while (true) {
		val inp = readLine()!!
		println(LPSubStr_DP(inp))
	}
}

fun LPSubStr_DP(X: String): String {
	val lookup = Array2D<String?>(rows = X.length + 1, cols = X.length + 1) { _, _ -> null }
	var max = ""

	(0 until X.length).reversed().forEach { i ->
		val x = X[i]
		(i until X.length).forEach { j ->
			val y = X[j]
			lookup[i][j] = when {
				i == j -> x.toString()
				x == y && lookup[i + 1][j - 1] != null -> x + lookup[i + 1][j - 1]!! + x
				else -> null
			}
			if (lookup[i][j] != null && lookup[i][j]!!.length > max.length)
				max = lookup[i][j]!!
		}
	}
	return max
}
