package com.example.compose
/*
// Java
public class Person {
    public static void sayHello() {
        System.out.println("안녕하세요~")
    }
}

public static void main() {
    System.out.println(Person.sayHello());
}
*/

// companion object:
// 하나의 객체여서 이름 붙일 수 있음
// interface 구현 가능
// 클래스, 즉 설계도에 붙어있는 객체 >> 프로세스에서 한 인스턴스만 존재 == 싱글톤


class Person {
    companion object {
        fun sayHello() {
            println("안녕하세요~")
        }

    }
}

class Person2 {
                    // 하나의 객체여서 이름 붙일 수 있음
    companion object Constant {
        const val MAX_AGE: Int = 100
    }
}


interface Movable {
    fun move()
}

class Person3 {
    companion object: Movable {
        override fun move(){
            println("움직여!!!")
        }
    }
}

class Person4 {
    companion object {
        var age: Int = 33
    }
}

fun main() {
    Person.sayHello()

    println("사람의 최대 수명: ${Person2.MAX_AGE}") // 가능~
    println(Person2.Constant.MAX_AGE) // 가능~

    Person3.move()

    println("사람4의 나이 : ${Person4.age}")
    Person4.age++
    println("1년 후의 나이 : ${Person4.age}")
}