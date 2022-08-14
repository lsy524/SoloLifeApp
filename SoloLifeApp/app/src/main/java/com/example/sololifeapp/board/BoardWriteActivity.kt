package com.example.sololifeapp.board

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.sololifeapp.R
import com.example.sololifeapp.databinding.ActivityBoardWriteBinding
import com.example.sololifeapp.model.BoardModel
import com.example.sololifeapp.util.FBAuth
import com.example.sololifeapp.util.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        // 화면 터치 시 키보드를 숨기는 코드
//        binding.root.setOnTouchListener { _, _ ->
//            hideKeyboard()
//        }

        onClick(binding.writeBtn)

    }

    // 키보드를 숨기는 메서드
//    private fun hideKeyboard() : Boolean{
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(this.currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
//
//        return false
//    }

    private fun onClick(v: View) {
        when(v.id) {
            // 게시글 작성 완료 버튼 클릭 시 발생하는 메서드
            R.id.writeBtn -> binding.writeBtn.setOnClickListener {
                val title = binding.titleArea.text.toString() // 입력한 글 제목
                val content = binding.contentArea.text.toString() // 입력한 글 내용
                val uid = FBAuth.getUid() // 글을 작성한 사용자 uid
                val time = FBAuth.getTime() // 글을 작성한 시간


                /* board => FBRef.boardRef
                    - key(자동으로 추가되는 고유한 값) => push()
                        - boardModel(title, content, uid, time)
                * */
                // 데이터베이스에 데이터 추가 코드
                FBRef.boardRef
                    .push()
                    .setValue(BoardModel(title, content, uid, time)) // 제목, 내용, 작성자 uid, 작성 시간

                Toast.makeText(this, "게시글이 작성되었습니다.", Toast.LENGTH_SHORT).show()

                finish()
            }
        }
    }


}