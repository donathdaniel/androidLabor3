package com.example.lab3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)

        button.setOnClickListener {
            if(editText.text.isEmpty()){
                Toast.makeText(applicationContext, "You did not give a name!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(applicationContext, "Your name: ${editText.text}", Toast.LENGTH_SHORT).show();
            }
        }
    }
}