package com.example.compose

import android.app.appsearch.BatchResultCallback
import android.view.View
import androidx.lifecycle.Lifecycle

// 람다식
fun main() {
    // 함수를 매개변수로 쓰는
    myFunc(10) {
        println("함수 호출")
    }
}

fun myFunc(a: Int, callback : () -> Unit) {
    println("함수 시작!!!")
    callback()
    println("함수 끝!!!")
}
// object 키워드 : 싱글톤 클래스 만들 수 있음, 생성된 객체 오직 하나뿐(인스턴스 생성, 상속 안 됨)
object Singleton {
    fun doSomething() {
        // 싱글톤 객체에서 수행할 작업
    }
}

val listener = object : View.OnClickListener {
    override fun onClick(view: View) {
        // 클릭 이벤트를 처리하는 코드
    }
}

// companion object는 클래스의 인스턴스가 아니라 클래스 자체에 속하는 객체
// 자바의 static 키워드를 사용하여 정의하는 정적 멤버를 대체
// companion object에서 정의한 상수는 클래스 내부에서만 사용할 수 있으며, 클래스 이름으로 접근할 수 있다.
class MyClass {
    companion object {
        const val MY_CONSTANT = 123
    }
}

// 팩토리 메서드 : 객체를 생성하는 메서드로 클래스 이름을 통해 호출
class MyClass2 private constructor(val value: Int) {
    companion object {
        fun create(value: Int): MyClass2 {
            return MyClass2(value)
        }
    }
}

class Myclass3 {
    companion object {}
}

fun Myclass3.Companion.doSomething(){
    // 확장 함수에서 수행할 작업
}

// 인터페이스 구현
interface MyInterface {
    fun doSomething() {
    }
}
class Myclass4 {
    companion object : MyInterface {
        override fun doSomething() {
            // 구현할 작업
        }
    }
}

class Customer(val name: String) {
    private var _messages: List<String>? = null

    val messages: List<String>
        get() {
            if (_messages == null) {
                _messages = loadMessages()
            }
            return _messages!!
        }

    private fun loadMessages(): List<String> {
        return mutableListOf<String>(
            "안녕", "뭐함?", "나오셈"
        ).also {
            println("메시지가 로딩됬습니다.")
        }.toList()
    }
}

