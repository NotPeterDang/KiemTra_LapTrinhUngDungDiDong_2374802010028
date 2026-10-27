package com.example.kiemtra_laptrinhungdungdidong_2374802010028

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1.3. Ánh xạ View bằng findViewById truyền thống (không dùng ViewBinding)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // 1.4 & 2.3 & 2.4. Xử lý sự kiện click vào Button 'Đăng nhập'
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            when {
                email.isEmpty() && password.isEmpty() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Vui lòng nhập đầy đủ Email và Mật khẩu!"
                }
                email.isEmpty() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Email không được để trống!"
                }
                password.isEmpty() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Mật khẩu không được để trống!"
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Định dạng Email không hợp lệ!"
                }
                password.length < 6 -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                }
                else -> {
                    tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                    tvStatus.text = "Xác thực thành công!"

                    // 2.3 & 2.4. Khởi tạo Explicit Intent và truyền dữ liệu Email qua putExtra()
                    val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }
}
