package org.sopt.androidseminar1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidseminar1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding :ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        initBtn()
    }

    private fun initBtn() {
        binding.btnSignUp.setOnClickListener {
            if (!binding.etName.text.isEmpty() && !binding.etId.text.isEmpty() && !binding.etPw.text.isEmpty()
            ) {
                intent
                    .putExtra("id", binding.etId.text)
                    .putExtra("pw", binding.etPw.text)
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
