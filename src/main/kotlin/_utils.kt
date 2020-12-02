@file:Suppress("unused", "FunctionName", "PackageDirectoryMismatch")

package utils

typealias Array2D<T> = Array<Array<T>>

inline fun <reified T> Array2D(rows: Int, cols: Int, init: (row: Int, col: Int) -> T) =
	Array<Array<T>>(rows) { row -> Array<T>(cols) { col -> init(row, col) } }

fun <T, R : Comparable<R>> maxByOrNull(vararg items: T, selector: (T) -> R) =
	items.maxByOrNull(selector)

fun <T, R : Comparable<R>> minByOrNull(vararg items: T, selector: (T) -> R) =
	items.minByOrNull(selector)
