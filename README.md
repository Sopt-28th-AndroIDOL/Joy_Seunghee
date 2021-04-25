# Joy_Seunghee

### 레포지터리 이름이 너무 긴경우 뒤에 ...이 나오도록 처리


        android:ellipsize="end"
        android:maxLines="1"
        
### 홈에서 more버튼 누르면 화면 이동

        private fun initButtonClickEvent() {
            binding.more.setOnClickListener {
                val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
                startActivity(intent)
            }
        }
        

### 소감

시험기간이라 제대로 복습도 못해서 이해도가 떨어진 상태에서 코드만 쫓다보니까 더 답도 없는 코드가 되가는 것 같다.... 
시험끝나면 다시 1,2차 세미나 내용 복습하면서 과제 수정해야겠다!!,,,,
