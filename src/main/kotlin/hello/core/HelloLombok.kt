package hello.core

// @Getter
// @Setter
class HelloLombok {

    var name: String = ""
    var age: Int = 0

}

fun main() {
    val helloLombok = HelloLombok()
    helloLombok.name = "dsfads"

    println("helloLombok = $helloLombok")
}
