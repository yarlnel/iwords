package com.example.iwords


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity : AppCompatActivity() {

    private val TAG = "appLogs"
    private val minNumber = 30
    private var t = arrayOf("прикол","не прикол", "fsdfds","WTF")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Word.listAll(Word().javaClass).size == Words().rus.size){
            Log.d(TAG,"все а**енно")
        }
        textViewM.setOnClickListener{
           val  db = DBH(this@MainActivity).writableDatabase
           db.delete("cont",null,null)
            Word.deleteAll(Word().javaClass)
       }
        btnMenu.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(intent)
        }
        btnQuit.setOnClickListener {
            onBackPressed()
        }

        Log.d(TAG,"we in main ")
        render()

    }
    // Данный метод логирования устарел
    @SuppressLint("LogConditional")
    private fun render() {
        var resTrue = true
        Log.d(TAG,"we in render start ")
        val wordus = Word.listAll(Word().javaClass)

        val w = Words()


        var s = ""
        for (e in wordus) {
            if (e.indexe > 5) {
                val id = w.eng.indexOf(e.eng)
                s += "\n\n ${w.eng[id]}   :   ${w.rus[id]}"
                w.eng.removeAt(id)
                w.rus.removeAt(id)
                w.translations.removeAt(id)
            }
        }
        //TODO
        Log.d(TAG, "Dell words : \n $s")

        val wrus = arrayListOf<String>()
        val weng = arrayListOf<String>()
        val wtranslations = arrayListOf<String>()

        for (i in 0 until minNumber){
            val r = (0 until w.rus.size).random()
            wrus.add(w.rus[r])
            weng.add(w.eng[r])
            wtranslations.add(w.translations[r])
            w.rus.removeAt(r)
            w.eng.removeAt(r)
            w.translations.removeAt(r)
        }
        w.rus.removeAll(w.rus)
        w.eng.removeAll(w.eng)
        w.translations.removeAll(w.translations)
        w.rus.addAll(wrus)
        w.eng.addAll(weng)
        w.translations.addAll(wtranslations)

        val secretNumber  = (0 until minNumber).random()

        texer(secretNumber,w)

        textViewM.text = w.eng[secretNumber].replace(" ", "")
        textViewT.text = w.translations[secretNumber]

        Log.d(TAG,"scn main t : ${
        w.rus[secretNumber]
        }")


        val btns = arrayListOf(button, button2, button3, button4)
        val randomMai = (btns.indices).random()
        val maiBtn = btns[randomMai]

        btns.removeAt(randomMai)

        for(b in btns){
            b.text = t[btns.indexOf(b)]
            b.setOnClickListener{
                resTrue = false
                Toast.makeText(this@MainActivity,"False",Toast.LENGTH_SHORT).show()
            }
        }

        val bol: Boolean
        val checkExistence =
            this@MainActivity
                .resources
                .getIdentifier(
                    "ss${w.eng[secretNumber].replace(" ", "")}",
                    "raw",
                    this@MainActivity.packageName
                )


        bol = checkExistence != 0
        if (bol) {
            val mp = MediaPlayer.create(
                this@MainActivity,
                resources.getIdentifier(
                    "ss${
                    w.eng[secretNumber].replace(" ", "")
                    }",
                    "raw",
                    packageName
                )
            )

            mp.start()

            maiBtn.text = w.rus[secretNumber]
            btnSound.setOnClickListener {
                if (!mp.isPlaying) {
                    mp.start()
                }


            }
           if (w.rus.size <= 6) {
                Log.d(TAG, "Ну все хана у тя всего 4 слова для кнопки")
                val db = DBH(this@MainActivity).writableDatabase
                db.delete("cont", null, null)
                Word.deleteAll(Word().javaClass)
                render()
            }


                maiBtn.setOnClickListener {
                    val db = DBH(this@MainActivity).writableDatabase

                    if (resTrue) {
                        var cv = ContentValues()
                        cv.put(
                            DBH.name, "\n" +
                                    "     ${w.eng[secretNumber].replace(
                                        " ",
                                        ""
                                    )}  :  ${w.rus[secretNumber].replace(" ", "")}"

                        )
                        val wordes = Word.listAll(Word().javaClass)
                        for (j in wordes) {
                            if (j.eng == w.eng[secretNumber]) {
                                j.indexe++
                                j.save()
                                //TODO
                                Log.d(TAG, "\n\nindex : ${j.indexe} in ${j.rus} :: ${j.eng}\n\n\n")

                            }
                        }
                        db.insert("cont", null, cv)


                        mp.stop()
                    }else{
                        Log.d(TAG,"\n\n\n false result \n\n\n")
                    }
                    render()

                }

            } else {
                render()
            }


        }
    @SuppressLint("LogConditional")
    fun texer(id : Int,wds : Words){
        Log.d(TAG,"\n" +
                "\n" +
                "\ndel main ${wds.rus[id]} \n\n\n")
        wds.rus.removeAt(id)
        wds.eng.removeAt(id)
        wds.translations.removeAt(id)


        for (i in t.indices){
            val scn =(0 until wds.rus.size).random()
            t[i] = wds.rus[scn]
            Log.d(TAG,"\ndel ather ${wds.rus[scn]}")
            wds.rus.removeAt(scn)
            wds.eng.removeAt(scn)
            wds.translations.removeAt(scn)

        }
        Log.d(TAG,"\n end" +
                "\n${t[0]}" +
                "\n" +
                "${t[1]}" +
                "\n" +
                "${t[2]}" +
                "\n" +
                "${t[3]}"

        )

    }





    }



/*TODO TODO TODO TODO
 if (button.text бля ты помнешь что тето изнач вале != w.rus[secretNumber]) {
                   button.text = w.rus[(0 until w.rus.size-minNumber).random()]
                   button.setOnClickListener { Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
                   resTrue = false
                   }

               }
               if (button2.text != w.rus[secretNumber]) {
                   button2.text = w.rus[(0 until w.rus.size-minNumber).random()]
                   button2.setOnClickListener { Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
                       resTrue = false}

               }
               if (button3.text != w.rus[secretNumber]) {
                   button3.text = w.rus[(0 until w.rus.size-minNumber).random()]
                   button3.setOnClickListener { Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
                       resTrue = false}

               }
               if (button4.text != w.rus[secretNumber]) {
                   button4.text = w.rus[(0 until w.rus.size-minNumber).random()]
                   button4.setOnClickListener { Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
                       resTrue = false}

               }
*/
//TODO
//TODO
//TODO

//TODO
//TODO
//TODO
/*
                    button.text == button2.text||
                    button.text == button3.text||
                    button.text == button4.text||
                    button2.text == button.text||
                    button2.text == button3.text||
                    button2.text == button4.text||
                    button3.text == button.text||
                    button3.text == button2.text||
                    button3.text == button4.text||
                    button4.text == button.text||
                    button4.text == button3.text||
                    button4.text == button2.text
 */