package com.example.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stopwatch.ui.theme.ComposeTheme
import java.util.Timer
import java.util.TimerTask

// MainActivity 클래스 정의
class MainActivity : ComponentActivity(), View.OnClickListener {

    // 변수 초기화
    private var isRunning = false  // 스톱워치가 작동 중인지 여부
    private var timer: Timer? = null  // 타이머 객체
    private var time = 0  // 시간 값을 저장할 변수

    // UI 요소 선언
    private lateinit var btn_start: Button
    private lateinit var btn_refresh: Button
    private lateinit var tv_millisecond: TextView
    private lateinit var tv_second: TextView
    private lateinit var tv_minute: TextView

    // 메인 스레드에서 UI 업데이트를 위해 Handler 사용
    private val handler = Handler(Looper.getMainLooper())

    // 액티비티 생성 시 호출되는 메서드
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI 요소 연결
        btn_start = findViewById(R.id.btn_start)
        btn_refresh = findViewById(R.id.btn_refresh)
        tv_millisecond = findViewById(R.id.tv_millisecond)
        tv_second = findViewById(R.id.tv_second)
        tv_minute = findViewById(R.id.tv_minute)

        // 버튼 클릭 리스너 설정
        btn_start.setOnClickListener(this)
        btn_refresh.setOnClickListener(this)
    }

    // 클릭 이벤트 처리 메서드
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_start -> {
                if (isRunning) {
                    pause()  // 스톱워치 일시정지
                } else {
                    start()  // 스톱워치 시작
                }
            }
            R.id.btn_refresh -> {
                refresh()  // 스톱워치 초기화
            }
        }
    }

    // 스톱워치 시작 메서드
    private fun start() {
        isRunning = true
        btn_start.text = "Pause"  // 버튼 텍스트 변경
        timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                time++  // 시간 증가
                handler.post {
                    updateUI()  // UI 업데이트
                }
            }
        }, 0, 10) // 10 밀리초 간격으로 실행
    }

    // 스톱워치 일시정지 메서드
    private fun pause() {
        isRunning = false
        btn_start.text = "Start"  // 버튼 텍스트 변경
        timer?.cancel()  // 타이머 중지
    }

    // 스톱워치 초기화 메서드
    private fun refresh() {
        isRunning = false
        timer?.cancel()  // 타이머 중지
        time = 0  // 시간 초기화
        btn_start.text = "Start"  // 버튼 텍스트 변경
        updateUI()  // UI 업데이트
    }

    // UI 업데이트 메서드
    private fun updateUI() {
        val milliseconds = time % 100  // 밀리초 계산
        val seconds = (time / 100) % 60  // 초 계산
        val minutes = (time / 6000)  // 분 계산

        // TextView에 시간 값 설정
        tv_millisecond.text = String.format("%02d", milliseconds)
        tv_second.text = String.format("%02d", seconds)
        tv_minute.text = String.format("%02d", minutes)
    }

    // Compose UI에서 사용될 함수
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    // Compose UI 미리보기 함수
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeTheme {
            Greeting("Android")
        }
    }
}
