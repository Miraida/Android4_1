package com.geek.android4_1.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.geek.android4_1.R
import com.geek.android4_1.databinding.ActivityMainBinding
import com.geek.android4_1.utils.Keys
import com.geek.android4_1.utils.Toasts

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        setToolbarTitle()
        registerForResult()
        setupListener()
    }

    private fun registerForResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK)
                    checkData(result.data)
            }
    }

    private fun checkData(data: Intent?) {
        if (data != null) {
            val text = data.getStringExtra(Keys.TEXT_KEY)
            ui.edtText.setText(text)
        }
    }

    private fun setupListener() {
        ui.btnClick.setOnClickListener {
            if (!ui.edtText.text.isNullOrEmpty()) send()
            else Toasts.showToast(this, getString(R.string.empty_err))
        }
    }

    private fun send() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(Keys.TEXT_KEY, ui.edtText.text.toString())
        resultLauncher.launch(intent)
    }

    private fun setToolbarTitle() {
        this.title = getString(R.string.main_activity)
    }
}