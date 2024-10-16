fun main() {
    val text = readLine() ?: ""
    val answer = text.replace("c=", "x")
    .replace("c-", "x")
    .replace("dz=", "x")
    .replace("d-", "x")
    .replace("lj", "x")
    .replace("nj", "x")
    .replace("s=", "x")
    .replace("z=", "x").length

    print("$answer")
}