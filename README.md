# Android-Jaehoon

![github_조재훈_ver1-27](https://user-images.githubusercontent.com/70698151/135754585-6c96b950-9a63-4996-a3ff-5bfb63070ebc.png)

<hr/>

# Week 1

## Level 1

- SOPTHub 로그인 페이지 만들기
  - 버튼 클릭 시 모든 EditText가 입력되어 있는 지 확인
  
  ```
     if(!binding.etId.text.toString().isEmpty() && !binding.etPw.text.toString().isEmpty()) {   
        ...  
     }
  ```
- SOPTHub 회원가입 페이지 만들기
  - 버튼 클릭 시 모든 EditText가 입력되어 있는 지 확인
    
   ```
      if(!etName.text.toString().isEmpty() && !etId.text.toString().isEmpty() && !etPw.text.toString().isEmpty()) {
        ...
      }
   ```
