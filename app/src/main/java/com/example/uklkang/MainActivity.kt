package com.example.uklkang

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener{
  lateinit var edtEmail: EditText
  lateinit var edtPassword: EditText
  lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.editTextTextEmailAddress)
        edtPassword = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.button)

        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var emptyEmail: Boolean = false
        var emptyPassword: Boolean = false

        if(edtEmail.text.toString().trim().length == 0){
            edtEmail.error = "Email Tidak Boleh Kosong!"
            emptyEmail = true
        }

        if(edtPassword.text.toString().trim().length == 0){
            edtPassword.error = "Password Tidak Boleh Kosong"
            emptyPassword = true
        }

        if(!emptyEmail && !emptyPassword){
            val dataReceived = Intent(this@MainActivity, MoveActivityWithData::class.java)
            val email = edtEmail.text.toString()
            dataReceived.putExtra("String", email)
            startActivity(dataReceived)
        }
    }
}