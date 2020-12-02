//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-subsequence/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Common_SubSequence

import utils.Array2D
import utils.maxByOrNull

fun main() {
	println("Longest Common SubSequence via DP:\n2 lookups holds length and path -> 0:both 1:x 2:y")
	while (true) {
		val X = readLine()!! // ABCBDAB
		val Y = readLine()!! // BDCABA
		val res = LCSubSeq_DP_Path(X, Y)
		println(res)
	}
}

fun LCSubSeq_DP_Path(X: String, Y: String): String {
	val lookup = Array2D(rows = X.length + 1, cols = Y.length + 1) { _, _ -> Pair(0, 0) }
	(1..X.length).forEach { i ->
		val x = X[i - 1]
		(1..Y.length).forEach { j ->
			val y = Y[j - 1]

			lookup[i][j] = if (x == y) Pair(lookup[i - 1][j - 1].first, 0)
			else maxByOrNull(
				Pair(lookup[i][j - 1].first, 1),
				Pair(lookup[i - 1][j].first, 2),
			) { it.first }!!
		}
	}
	var (i, j) = X.length to Y.length
	var ans = ""
	while (i > 0 && j > 0) {
		when (lookup[i--][j--].second) {
			0 -> ans = X[i] + ans
			1 -> i++
			2 -> j++
		}
	}
	return ans
}
