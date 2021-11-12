package org.sopt.androidseminar1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidseminar1.databinding.ActivitySignUpBinding
import org.sopt.androidseminar1.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding :ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        initBtn()
    }

    private fun initBtn() {
        binding.btnSignUp.setOnClickListener {
            initNetwork()
//            if (!binding.etName.text.isEmpty() && !binding.etId.text.isEmpty() && !binding.etPw.text.isEmpty()
//            ) {
//                intent
//                    .putExtra("id", binding.etId.text)
//                    .putExtra("pw", binding.etPw.text)
//                setResult(RESULT_OK, intent)
//                finish()
//            } else {
//                Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    private fun initNetwork(){
        val requestSignUpData = RequestSignUpData(
            email = binding.etId.text.toString(),
            name = binding.etName.text.toString(),
            password=binding.etPw.text.toString()
        )

        val call: Call<ResponseSignUpData> = ServiceCreator.signUpService.postSignUp(requestSignUpData)

        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if(response.isSuccessful){
                    val data=response.body()?.data

                    Toast.makeText(this@SignUpActivity,"${data?.name}님 회원가입 완료", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)

                    intent
                    .putExtra("id", binding.etId.text.toString())
                    .putExtra("pw", binding.etPw.text.toString())

                    setResult(RESULT_OK, intent)
                    finish()
                }else{
                    Toast.makeText(this@SignUpActivity,"회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.e("NetworkTest","error:$t")
            }
        })
    }
}
