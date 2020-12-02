//https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

package Longest_Repeated_SubString

fun main() {
	println("Longest Repeated SubString via Recursive")
	while (true) {
		val inp = readLine()!! //ATACTCGGA
		println(LRSubStr_Req(inp, 0, inp.length - 1))
	}
}

fun LRSubStr_Req(X: String, i: Int, j: Int): String = throw NotImplementedError()

