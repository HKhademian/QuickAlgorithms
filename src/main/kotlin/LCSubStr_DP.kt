//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-common-substring-problem/
//https://en.wikipedia.org/wiki/Longest_common_substring_problem

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Common_SubString

import utils.Array2D

fun main() {
	println("Longest Common SubString via DP:\nlookup holds answer")
	while (true) {
		val X = readLine()!! // ABCBDAB
		val Y = readLine()!! // BDCABA
		val res = LCSubStr_DP(X, Y)
		println(res)
	}
}

fun LCSubStr_DP(X: String, Y: String): String {
	val lookup = Array2D(rows = X.length + 1, cols = Y.length + 1) { _, _ -> "" }
	var max = ""

	(1..X.length).forEach { i ->
		val x = X[i - 1]
		(1..Y.length).forEach { j ->
			val y = Y[j - 1]
			if (x == y) {
				lookup[i][j] = lookup[i - 1][j - 1] + x
				if (max.length < lookup[i][j].length)
					max = lookup[i][j]
			}
		}
	}
	return max
}
