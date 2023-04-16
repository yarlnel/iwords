package com.example.iwords

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.iwords.R
import kotlinx.android.synthetic.main.activity_words_list_activty.*

class WordsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list_activty)
        val w= Words()
        var s =""
        for (i in 0..(w.eng.size-1)){
            s+="\n\n ${w.eng[i].replace(" ","")} : ${w.rus[i]}"

        }
        textView.text=s
    }
}
