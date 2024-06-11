import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember

fun main(){
    checkNum(1)

//    // 3. String Template
//
//    val name = "yuna"
//    val lastname = "lee"
//    // 대괄호 안은 모두 변수다
//    println("나의 이름은 ${name + lastname}입니다")
//
//    println("is this true? ${1==0}")
//    // 백슬레시 붙이면 달러 문자 기호로 인식 해줌
//    println("this is 2\$a")



}

// 1.함수

fun helloWorld() {
    println("hello world")
}

fun add(a : Int, b : Int) : Int {
    return a+b
}

// 2. val  vs  var
fun hi(){
    val a : Int = 10    // 재정의 할 수 없음
    var b : Int = 9

    var e : String  // 변수 선언할땐 어떤 타입인지 써주기
    b = 100

    val  c = 100    //Int 인지 아닌지 알아서 적용 됨
    var d = 50
    var name = "yuna"   // String 자동으로 추론 해줌

}

// 4. 조건식

fun maxBy(a : Int, b : Int) : Int {
    if (a > b){
        return a
    }else{
        return b
    }
}

fun maxBy2(a : Int, b : Int) : Int = if (a>b) a else b

fun checkNum(score : Int) : Unit {
    when(score){
        0 -> println("입력값 0")
        1 -> println("입력값 1")
        2,3 -> println("입력값 2 또는 3")
//        else -> println("I don't know")
    }

    var b : Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3 // 이땐 else 꼭 써줘야 함
    }

    println("b : ${b}")

    when(score){
        in 90..100 -> println("genius")
        in 10..80 -> println("not bad")
        else -> println("ok")
    }
}

// 코틀린의 모든 함수는 Expression ; 항상 반환값이 있음 => 없어보여도 모든 합수는 Unit 값을 반환 함
// Statement : Java 에서 void


/// 5. Array and List
// Array
// List 1. List 2. MutableList

fun array(){
    val array = arrayOf(1,2,3)  // 초기화
    val list = listOf(1,2,3)    // 초기화

    val array2 = arrayOf(1,"b", 3, 4f)
    val list2 = listOf(1,"b",11L)

    array[0] = 3
//    list[0] = 2 -> 값을 가져올 순 있지만, 값을 바꿀 순 없음
    var result = list.get(0)

    // 주소값이 바뀌는것이 아니기 때문에 val 사용 가능
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)

}


