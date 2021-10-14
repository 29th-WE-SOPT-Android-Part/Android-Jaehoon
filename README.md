# Android-Jaehoon

![github_조재훈_ver1-27](https://user-images.githubusercontent.com/70698151/135754585-6c96b950-9a63-4996-a3ff-5bfb63070ebc.png)

<hr/>

# Week 1

## Level 1

- SignInActivity
  - '로그인 버튼' 클릭 시 모든 EditText가 입력되어 있는 지 확인
  
    ```kt
     if(!binding.etId.text.toString().isEmpty() && !binding.etPw.text.toString().isEmpty()) {   
        
        //...
        
     }
    ```
     
  - 비밀번호 EditText inputType 속성

    ```xml
      android:inputType="textPassword"
    ```
 
  - 모든 입력이 되었을 때 로그인 버튼 클릭 시 HomeActivity로 이동

    ```kt
      val intent = Intent(this, HomeActivity::class.java)
      startActivity(intent)
    ```
    
  - 회원가입 버튼 클릭 시 SignUpActivity로 이동

    ```kt
      val intent = Intent(this, SignUpActivity::class.java)
      activityResultLauncher.launch(intent)
    ```
    
- SignUpActivity
  - '회원가입 완료' 버튼 클릭 시 모든 EditText가 입력되어 있는 지 확인
    
    ```kt
      if(!etName.text.toString().isEmpty()
      && !etId.text.toString().isEmpty() && !etPw.text.toString().isEmpty()) {
        
        //...
        
      }
    ```
   
  - 비밀번호 EditText inputType 속성

    ```xml
      android:inputType="textPassword"
    ```

## Level 2

- 화면 이동
  - SignUpActivity
    ```kt
      binding.apply {
              btnSignUp.setOnClickListener {
                  if(!etName.text.toString().isEmpty() && !etId.text.toString().isEmpty() && !etPw.text.toString().isEmpty()) {
                      intent.putExtra("id", etId.text.toString())
                      intent.putExtra("pw", etPw.text.toString())
                      setResult(RESULT_OK, intent)
                      finish()
                  } else {
                      Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
                  }
              }
          }
    ```
  
  - SignInActivity

    ```KT
      class SignInActivity : AppCompatActivity() {
        private lateinit var binding : ActivitySignInBinding
        private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>

        override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivitySignInBinding.inflate(layoutInflater)
          setContentView(binding.root)

          activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
              if(it.resultCode == RESULT_OK) {
                  binding.etId.setText(it.data?.getStringExtra("id"))
                  binding.etPw.setText(it.data?.getStringExtra("pw"))
              }
          }

          //...

          binding.btnSignUp.setOnClickListener {
              val intent = Intent(this, SignUpActivity::class.java)
              activityResultLauncher.launch(intent)
          }
        }
      }
    ```

- 인텐트
  - 명시적 인텐트
    - 인텐트에 클래스 객체나 컴포넌트 이름을 지정하여 호출할 대상을 확실히 알 수 있는 경우
    - 주로 앱 내부에서 사용
    - 특정 컴포넌트나 액티비티가 명확하게 실행되어야할 경우
    
  - 암시적 인텐트
    - 인텐트의 액션과 데이터를 지정하긴 했지만, 호출할 대상이 달라질 수 있는 경우
    - 안드로이드 시스템이 인텐트를 이용해 요청한 정보를 처리할 수 있는 적절한 컴포넌트를 찾아 사용자에게 그 대상과 처리 결과를 보여줌
    - 해당 기능들을 지원하는 앱들이 있는 경우에 암시적 인텐트를 사용해서 그 앱들을 사용
    
- HomeActivity 화면 레이아웃 수정
  - nestedScrollView 사용
  
    ```xml
      <androidx.core.widget.NestedScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:fillViewport="true">

          <androidx.constraintlayout.widget.ConstraintLayout
              android:layout_width="match_parent"
              android:layout_height="match_parent">
              
              //...
              
          </androidx.constraintlayout.widget.ConstraintLayout>

      </androidx.core.widget.NestedScrollView>
    ```
  
  - constraintDimensionRatio 속성 사용
    - height를 0dp로 설정하고 layout_constraintDimensionRatio에 1을 넣어서 width와 height를 1:1비율로 조정
    
    ```xml
      <ImageView
                android:id="@+id/iv_profile"
                android:layout_width="200dp"  
                android:layout_height="0dp" 
                
                //...
                 
                app:layout_constraintDimensionRatio="1" />
    ```


## Level 3

- ViewBinding & DataBinding
  - ViewBinding과 DataBinding의 관계
  ![image](https://user-images.githubusercontent.com/58066704/137323431-9c1cce45-3cae-4088-bce5-24826adcf059.png)
  
  - 공통점
    - 상대적으로 간단하며 퍼포먼스 효율이 좋고 용량이 절약됨
    - 뷰의 직접 참조를 생성하므로 유효하지 않은 뷰 ID로 인해 NPE로부터 안전

  - ViewBinding
    - 빠른 컴파일 속도와 따로 xml 파일에 태그가 필요하지 않고 자동으로 적용되므로 사용 편의성

  - DataBinding
    - 데이터와 뷰를 연결하는 작업을 레이아웃에서 처리
    - 동적 UI 콘텐츠 선언 및 양방향 데이터 결합 지원

- 코틀린에선 setOnClickListener를 람다식으로 간결하게 표현할 수 있는 이유
  - 코틀린이 함수형 프로그래밍이 가능하기 때문
  
  ```
    함수형 프로그래밍에서는 함수를 값처럼 다루는 접근 방식을 택함으로써,
    기존처럼 클래스를 선언하고 그 클래스의 인스턴스를 함수에 넘기는 대신,
    함수를 직접 다른 함수에 전달할 수 있음.
  ```

  자바
  
    ```java
      button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //TODO
        }
      });
    ```

  코틀린
  
    ```kt
      button.setOnClickListener { 
        //TODO
      }
    ```

<hr/>
