package com.example.iwords


import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*
import java.lang.Void


@SuppressLint("LogConditional")
 class SplashActivity : AppCompatActivity() {
     val TAG = "appLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

            val sdb = StartDb()
            sdb.execute()



    }



    @SuppressLint("StaticFieldLeak")
    internal inner class StartDb : AsyncTask<Void, Int, Void?>() {

        override fun onPreExecute() {
            if (Word.listAll(Word().javaClass).size != Words().rus.size) {
                Word.deleteAll(Word().javaClass)
            }
            super.onPreExecute()
            progressBarLine.progress = 0

        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            Log.d(TAG,"WTF  from apdate ${values[0]}")
            progressBarLine.progress = values[0]!!


        }

        override fun doInBackground(vararg voids: Void): Void? {
            dooingDB()
            Log.d(TAG,"WTF  rrr / ttt")
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            val intent = Intent(this@SplashActivity, MainActivity().javaClass)
            startActivity(intent)
            finish()
        }




        @Throws(InterruptedException::class)
        private fun dooingDB() {
            val words = Words()
            var counter = 0
            if (Word.listAll(Word().javaClass).size != Words().rus.size) {
            for (i in 0 until words.rus.size){
                            publishProgress(++counter)

                            Log.d(TAG,"doing var width id $counter ")
                            val word = Word(words.rus[i],words.eng[i],words.translations[i],0)
                            word.save()
            }
        }}
    }
}

