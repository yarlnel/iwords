package com.example.iwords

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_set.*

class SetActivity : AppCompatActivity() {
var bol = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set)

    /*    if (bol) {
            btnEng.setText("RUS")
        }else{
            btnEng.setText("ENG")
        }
        btnEng.setOnClickListener {
            val sharp = getPreferences(Context.MODE_PRIVATE)
            val ed = sharp.edit()
            if (bol) {
                bol=false
                ed.putBoolean("ENG", false)
                ed.apply()
            }else{
                bol=true
                ed.putBoolean("ENG",true)
                ed.apply()
            }
            val intent = Intent(this@SetActivity,MainActivity::class.java)
            startActivity(intent)
*/
  //      }
    }
}
