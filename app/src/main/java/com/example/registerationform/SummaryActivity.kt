package com.example.registerationform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.registerationform.databinding.ActivityMainBinding
import com.example.registerationform.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        retrieveAndDisplayUser()
        setOnClickListener()

    }

    private fun retrieveAndDisplayUser() {
        var user = intent.getSerializableExtra("User") as User
        binding.tvName.text = user.getUserName()
        binding.tvEmail.text = user.email
        binding.tvPhoneNumber.text = user.phoneNumber
    }

    private fun setOnClickListener() {
        binding.tvEmail.setOnClickListener({
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${binding.tvEmail.text}")
            startActivity(intent)
        })
        binding.tvPhoneNumber.setOnClickListener({
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${binding.tvPhoneNumber.text}")
            startActivity(intent)
        })
    }
}