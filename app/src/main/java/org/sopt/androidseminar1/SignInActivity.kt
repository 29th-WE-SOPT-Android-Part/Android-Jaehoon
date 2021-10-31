package org.sopt.androidseminar1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidseminar1.databinding.ActivitySignInBinding
import org.sopt.androidseminar1.home.HomeActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)

        init()
        initBtn()
    }

    private fun init() {
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                binding.etId.setText(it.data?.getStringExtra("id"))
                binding.etPw.setText(it.data?.getStringExtra("pw"))
            }
        }
    }

    private fun initBtn() {
        binding.btnLogIn.setOnClickListener {
            if(!binding.etId.text.isEmpty() && !binding.etPw.text.isEmpty()) {

                Toast.makeText(this, "${binding.etId.text}님 환영합니다", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignUp2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}