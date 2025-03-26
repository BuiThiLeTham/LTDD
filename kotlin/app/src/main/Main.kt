fun main() {
    // Nhập số thứ nhất
    print("Nhập số a: ")
    val a = readLine()?.toDoubleOrNull() ?: 0.0

    // Nhập số thứ hai
    print("Nhập số b: ")
    val b = readLine()?.toDoubleOrNull() ?: 0.0

    // Tính tổng
    val sum = a + b

    // In kết quả
    println("Tổng của $a và $b là: $sum")
}
