//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

@file:Suppress("PackageDirectoryMismatch", "FunctionName", "PackageName")

package Longest_Repeated_SubString

fun main() {
	println("Longest Repeated SubString via Recursive")
	while (true) {
		val X = readLine()!! //ATACTCGGA
		val res = LRSubStr_Req(X, 0, X.length - 1)
		println(res)
	}
}

fun LRSubStr_Req(X: String, i: Int, j: Int): String = throw NotImplementedError()

