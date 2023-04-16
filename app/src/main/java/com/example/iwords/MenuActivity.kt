package com.example.iwords

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        buttonList.setOnClickListener {
            val intent = Intent(this@MenuActivity, WordsListActivity::class.java)
            startActivity(intent)
        }
        buttonTrue.setOnClickListener {
            val intent2 = Intent(this@MenuActivity,TrueMenuActivity::class.java)
            startActivity(intent2)
        }
        setBtn.setOnClickListener {
            val  intent3 = Intent(this@MenuActivity,SetActivity::class.java)
            startActivity(intent3)
        }
    }
}
