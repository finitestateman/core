package hello.core.lifecycle

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy

class NetworkClient {

    var url: String? = null

    constructor() {
        println("생성자 호출 url = $url")
    }

    fun connect() {
        println("connect: $url")
    }

    fun call(message: String) {
        println("call: = $url message = $message")
    }

    fun disconnect() {
        println("close $url")
    }

    @PostConstruct
    fun init() {
        println("NetworkClient.init")
        connect()
        call("초기화 연결 메시지")
    }

    @PreDestroy
    fun close() {
        println("NetworkClient.close")
        disconnect()
    }
}