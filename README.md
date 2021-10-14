# Android-Jaehoon

![github_조재훈_ver1-27](https://user-images.githubusercontent.com/70698151/135754585-6c96b950-9a63-4996-a3ff-5bfb63070ebc.png)

<hr/>

# Week 1

## Level 1

- SignInActivity
  - '로그인 버튼' 클릭 시 모든 EditText가 입력되어 있는 지 확인
  
    ```
     if(!binding.etId.text.toString().isEmpty() && !binding.etPw.text.toString().isEmpty()) {   
        ...  
     }
    ```
     
  - 비밀번호 EditText inputType 속성

    ```
      android:inputType="textPassword"
    ```
 
  - 모든 입력이 되었을 때 로그인 버튼 클릭 시 HomeActivity로 이동

    ```
      val intent = Intent(this, HomeActivity::class.java)
      startActivity(intent)
    ```
    
  - 회원가입 버튼 클릭 시 SignUpActivity로 이동

    ```
      val intent = Intent(this, SignUpActivity::class.java)
      activityResultLauncher.launch(intent)
    ```
    
- SignUpActivity
  - '회원가입 완료' 버튼 클릭 시 모든 EditText가 입력되어 있는 지 확인
    
    ```
      if(!etName.text.toString().isEmpty()
      && !etId.text.toString().isEmpty() && !etPw.text.toString().isEmpty()) {
        ...
      }
    ```
   
  - 비밀번호 EditText inputType 속성

    ```
      android:inputType="textPassword"
    ```
   
- HomeActivity
  - ConstraintLayout 내에 LinearLayout를 사용하여 TextView를 정렬 (수정 예정)
    ```
      
    ```

## Level 2

- 화면 이동


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





## Level 3

- DataBinding
