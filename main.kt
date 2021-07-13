fun main(){
    println(search (22,17))

}
fun search (a:Int, b: Int): Boolean{
    var first = a % 2 == 0
    var second = b % 2 ==1
    return first == second
}