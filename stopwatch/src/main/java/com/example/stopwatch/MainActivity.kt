//package com.example.stopwatch
//
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import androidx.activity.ComponentActivity
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.stopwatch.ui.theme.ComposeTheme
//import java.util.Timer
//
//class MainActivity : ComponentActivity() {
//
//    var isRunning = false
//    var timer : Timer? = null   // timer 변수 생성
//    var time = 0                // time 변수 생성
//
//    private lateinit var btn_start: Button
//    private lateinit var btn_refresh: Button
//    private lateinit var tv_millisecond: TextView
//    private lateinit var tv_second: TextView
//    private lateinit var tv_minute: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btn_start = findViewById(R.id.btn_start)
//        btn_refresh = findViewById(R.id.btn_refresh)
//        tv_millisecond = findViewById(R.id.tv_millisecond)
//        tv_second = findViewById(R.id.tv_second)
//        tv_minute = findViewById(R.id.tv_minute)
//
//        btn_start.setOnClickListener(this)
//        btn_refresh.setOnClickListener(this)
//    }
//
//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.btn_start -> {
//                if(isRunning){
//                    pause()
//                }else{
//                    start()
//                }
//            }
//            R.id.btn_refresh -> {
//                refresh()
//            }
//        }
//}
//
//    private fun start() {
//        TODO("Not yet implemented")
//
//    }
//
//    private fun pause() {
//        TODO("Not yet implemented")
//    }
//
//    private fun refresh() {
//        TODO("Not yet implemented")
//    }
//
//
//    @Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeTheme {
//        Greeting("Android")
//    }
//}