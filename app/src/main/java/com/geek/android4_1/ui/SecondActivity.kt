package com.geek.android4_1.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geek.android4_1.R
import com.geek.android4_1.databinding.ActivitySecondBinding
import com.geek.android4_1.utils.Keys

class SecondActivity : AppCompatActivity() {
    private lateinit var ui: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(ui.root)
        setToolbarTitle()
        checkIntent()
        setupListener()
    }

    private fun setToolbarTitle() {
        this.title = getString(R.string.second_activity)
    }

    private fun setupListener() {
        ui.btnSend.setOnClickListener {
            if (!ui.edtText.text.isNullOrEmpty())
                send()
        }
    }

    private fun send() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Keys.TEXT_KEY, ui.edtText.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun checkIntent() {
        val text: String? = intent.getStringExtra(Keys.TEXT_KEY)
        ui.edtText.setText(text)
    }
}