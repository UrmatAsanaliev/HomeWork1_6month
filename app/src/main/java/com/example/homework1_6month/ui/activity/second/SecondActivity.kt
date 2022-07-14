package com.example.homework1_6month.ui.activity.second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework1_6month.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getText()
        toMainActivity()
    }

    fun toMainActivity(){
        binding.btnSave.setOnClickListener {
            val text = binding.edText.text.toString()
            if (text.isNotBlank()) {
                init(text)
            } else {
                Toast.makeText(
                    this,
                    "EditText не может быть пустым!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun getText(){
        val extras: Bundle? = intent.extras
        val title = extras?.getString("main")
        binding.edText.setText(title)
    }

    fun init(text:String){
        val intent = Intent()
        intent.putExtra("SendMessage", text)
        setResult(RESULT_OK, intent)
        finish()
    }
}