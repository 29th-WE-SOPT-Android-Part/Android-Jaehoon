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
      if(!etName.text.toString().isEmpty() && !etId.text.toString().isEmpty() && !etPw.text.toString().isEmpty()) {
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


- HomeActivity 화면 레이아웃 수정





## Level 3

- DataBinding
