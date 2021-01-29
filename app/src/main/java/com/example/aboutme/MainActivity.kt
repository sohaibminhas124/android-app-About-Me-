package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Sohaib")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.NameButton.setOnClickListener {
            addNickName(it)
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }


    }

    private fun addNickName(view: View) {
        binding.apply {
            myName?.NickName= NameEdit.text.toString()
            invalidateAll()
            NameEdit.visibility=View.GONE
            NameText1.visibility=View.VISIBLE
            NameButton.visibility=View.GONE

            //Code for auto hide keyboeard but not working here
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)


        }


    }


}
    //setContentView(R.layout.activity_main)


    //this code is for accessing data by view id
    /* val Edit_Text:EditText=findViewById(R.id.ET1)
     val Scroll_Text:TextView=findViewById(R.id.T2)
     val Click_Here: Button=findViewById(R.id.B1)
     val Text_3:TextView=findViewById(R.id.T3)
     Click_Here.setOnClickListener {
         Text_3.text= Edit_Text.text
         Text_3.visibility= View.VISIBLE*/

    /*this is one code for view data(check Lesson 2 and video 16)
    findViewById<Button>(R.id.B1).setOnClickListener {  }*/

/*
        binding.B1.setOnClickListener {
            binding.T3.text=binding.ET1.text
            binding.T3.visibility=View.VISIBLE
        }
*/




