//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/shortest-common-supersequence-introduction-scs-length/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Shortest_Common_SuperSequence

import utils.minByOrNull

fun main() {
	println("Shortest Common SuperSequence via Recursive")
	while (true) {
		val X = readLine()!! // ABCBDAB
		val Y = readLine()!! // BDCABA
		val res = SCSupSeq_Rec(X, Y)
		println(res)
	}
}

fun SCSupSeq_Rec(X: String, Y: String): String = when {
	X.isEmpty() -> Y
	Y.isEmpty() -> X
	X.last() == Y.last() -> SCSupSeq_Rec(X.dropLast(1), Y.dropLast(1)) + X.last()
	else -> minByOrNull(
		SCSupSeq_Rec(X.dropLast(1), Y) + X.last(),
		SCSupSeq_Rec(X, Y.dropLast(1)) + Y.last(),
	) { it.length }!!
}
