package com.example.thanos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registrationActivity : AppCompatActivity() {

    private lateinit var teqsti1:EditText
    private lateinit var password:EditText
    private lateinit var repeatpassword:EditText
    private lateinit var ghilaki:Button
    private lateinit var ghilaki2:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()
        zimbabve()


    }

    private fun init() {
        teqsti1 = findViewById(R.id.teqsti1)
        password = findViewById(R.id.password)
        repeatpassword = findViewById(R.id.repeatpassword)
        ghilaki = findViewById(R.id.ghilaki)
        ghilaki2 = findViewById(R.id.ghilaki2)
    }

    private fun zimbabve() {
        ghilaki2.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        ghilaki.setOnClickListener {
            val email = teqsti1.text.toString()
            val paroli = password.text.toString()
            val paroli2 = password.text.toString()

            if (email.isEmpty() || paroli.isEmpty() || paroli2.isEmpty()) {
                Toast.makeText(this, "vwuxvar amxanago", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (paroli != paroli2) {
                Toast.makeText(this, "ar emtxveva ", Toast.LENGTH_SHORT).show()
            }
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,paroli)
            .addOnCompleteListener { yaryati ->
                if (yaryati.isSuccessful) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "vaax...", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }






    }