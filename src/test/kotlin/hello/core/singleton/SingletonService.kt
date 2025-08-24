package hello.core.singleton

class SingletonService private constructor() {

    companion object {
        val instance = SingletonService()
    }

    fun logic() = println("싱글톤 객체 로직 호출")

}

object SingletonObjectService {
    fun logic() = println("싱글톤 객체 로직 호출")
}
