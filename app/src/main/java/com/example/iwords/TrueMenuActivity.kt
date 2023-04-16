package com.example.iwords

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_words_list_activty.*
import java.lang.reflect.Array


class TrueMenuActivity : AppCompatActivity() {
    var texte = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list_activty)
        val  db = DBH(this@TrueMenuActivity).writableDatabase
        val cursor =db.query("cont", null, null, null, null, null, null)


        if (cursor.moveToFirst()) {

            val list = ArrayList<String>()
            val indexs = arrayOfNulls<Int>(1100)
             var iname : String
          //  var iid : Int
           // var icount : Int
            do {
                //   iid = cursor.getString(cursor.getColumnIndex("id")).toInt()
                //  icount = cursor.getString(cursor.getColumnIndex("count")).toInt()
                iname = cursor.getString(cursor.getColumnIndex("name"))
                //  ids.add(iid)
                //  counts.add(icount)
                //блять я удалил важную часть от list.add()
                if (!list.contains(iname)) {
                    list.add(iname)
                }
                if(list.contains(iname)){
                     val e =list.indexOf(iname)
                     if (indexs[e]==null){
                         indexs[e]=1

                     }else indexs[e] = indexs[e]?.plus(1)
                }

            }  while (cursor.moveToNext())
                var text = ""
                for (i in 0 until list.size) {
                if (indexs[i]==null) {
                    text = "$text \n ${list[i]} "
                }else{
                    if (indexs[i]!! <= 5) {
                        text = "$text \n  ${list[i]} : ${indexs[i]}"
                        }else {
                        texte = "$texte\n${list[i]}"

                    }
                    }
                }
            getPreferences(Context.MODE_PRIVATE).edit().putString("texte",texte).apply()
                textView.text = "\n \n НЕДОВЫУЧЕНЫЕ СЛОВА : \n $text \n \n \n \n ПОЛНОСТЬЮ ВЫУЧЕНЫЕ СЛОВА :\n $texte "


        } else {
            textView.text = "На данный момент \n вы не выучили \n не одного слова!"

        }

    }



}
