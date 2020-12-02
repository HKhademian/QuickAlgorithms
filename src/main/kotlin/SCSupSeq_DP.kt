//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/shortest-common-supersequence-introduction-scs-length/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Shortest_Common_SuperSequence

import utils.Array2D
import utils.minByOrNull

fun main() {
	println("Shortest Common SuperSequence via DP")
	while (true) {
		val X = readLine()!! // ABCBDAB
		val Y = readLine()!! // BDCABA
		val res = SCSupSeq_DP(X, Y)
		println(res)
	}
}

fun SCSupSeq_DP(X: String, Y: String): String {
	val lookup = Array2D(rows = X.length + 1, cols = Y.length + 1) { _, _ -> "" }
	(0..X.length).forEach { i ->
		(0..Y.length).forEach { j ->
			lookup[i][j] = when {
				i == 0 -> Y.substring(0 until j)
				j == 0 -> X.substring(0 until i)
				X[i - 1] == Y[j - 1] -> lookup[i - 1][j - 1] + X[i - 1]
				else -> minByOrNull(
					lookup[i - 1][j] + X[i - 1],
					lookup[i][j - 1] + Y[j - 1],
				) { it.length }!!
			}
		}
	}
	return lookup[X.length][Y.length]
}
