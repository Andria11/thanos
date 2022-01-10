package com.example.thanos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var ynwa:EditText
    private lateinit var valhalla:EditText
    private lateinit var dastur:Button
    private lateinit var registration:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ferguson()
        masvidal()
    }
    private fun ferguson() {
        ynwa = findViewById(R.id.ynwa)
        valhalla = findViewById(R.id.valhalla)
        dastur = findViewById(R.id.dastur)
        registration = findViewById(R.id.registration)
    }
    private fun masvidal() {
        registration.setOnClickListener {
            startActivity(Intent(this, registrationActivity::class.java))
        }
        dastur.setOnClickListener {
            val email = ynwa.text.toString()
            val paroli = valhalla.text.toString()


            if (email.isEmpty() || paroli.isEmpty()) {
                Toast.makeText(this, "gaklia ragac", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email,paroli)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                    } else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                    }

                }
        }


    }
}