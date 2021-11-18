package org.sopt.androidseminar1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidseminar1.databinding.ActivitySignInBinding
import org.sopt.androidseminar1.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                val id = it.data?.getStringExtra("id")
                val pw = it.data?.getStringExtra("pw")
                binding.etId.setText(id)
                binding.etPw.setText(pw)
                Toast.makeText(this@SignInActivity,id + pw, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initBtn() {
        binding.btnLogIn.setOnClickListener {
            initNetwork()
//            if(!binding.etId.text.isEmpty() && !binding.etPw.text.isEmpty()) {
//
//                Toast.makeText(this, "${binding.etId.text}님 환영합니다", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
//            }
        }

        binding.tvSignUp2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }

    private fun initNetwork(){
        val requestLoginData = RequestLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.loginService.postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful){
                    val data=response.body()?.data

                    Toast.makeText(this@SignInActivity,"${data?.name}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                }else{
                    Toast.makeText(this@SignInActivity,"로그인에 실패하셨습니다", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest","error:$t")
            }
        })
    }
}