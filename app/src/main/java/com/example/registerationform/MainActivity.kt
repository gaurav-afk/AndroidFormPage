package com.example.registerationform

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.registerationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupSpinner()
        setupButton()

    }

    private fun setupSpinner() {
        var titles = arrayOf("Miss", "Mrs", "Ms", "Mr", "Mx", "Dr", "Prof")
        var titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        binding.spinnerTitle.adapter = titleAdapter
    }

    private fun setupButton() {
        binding.btnCreateAccount.setOnClickListener({
            createAccount()
        })
    }

    private fun createAccount(){
        var user = User(
            binding.spinnerTitle.selectedItem.toString(),
            binding.teFirstName.text.toString(),
            binding.teLastName.text.toString(),
            binding.teEmail.text.toString(),
            binding.tePhoneNumber.text.toString(),
            binding.tePassword.text.toString())

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }
}