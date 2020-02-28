package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myUser:MyName = MyName("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        binding.myUser = myUser //binds the layout-> myName to line 18 here
        binding.doneButton.setOnClickListener { submitForm() }
        //binding.nicknameText.setOnClickListener { updateNickname() }
    }

    private fun submitForm() {
        binding.apply {
            myUser?.name = binding.nameEdit.text.toString()
            myUser?.nickname = binding.nicknameEdit.text.toString()
            myUser?.age = binding.ageEdit.text.toString().toInt()
            myUser?.birthday = binding.birthdayEdit.text.toString()
            myUser?.number = binding.phoneEdit.text.toString()
            myUser?.email = binding.emailEdit.text.toString()
            myUser?.dream = binding.dreamEdit.text.toString()
            myUser?.crush = binding.crushEdit.text.toString()
            invalidateAll()         //para mag reflect yung pagbabago ng variable sa UI
            binding.nicknameTextShown.visibility = View.VISIBLE
            binding.nameTextShown.visibility = View.VISIBLE
            binding.ageTextShown.visibility = View.VISIBLE
            binding.bioScroll.visibility = View.GONE
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
        }

    }

//    private fun updateNickname(){
//
//        binding.nicknameEdit.visibility = View.VISIBLE
//        binding.doneButton.visibility = View.GONE
//        done_button.visibility = View.VISIBLE
//        binding.nicknameEdit.requestFocus()
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.showSoftInput(binding.nicknameText, 0)
//
//
//
//
//
//
//    }
}
