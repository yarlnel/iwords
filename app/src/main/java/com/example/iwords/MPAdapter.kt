package com.example.iwords

import android.content.Context
import android.content.res.Resources
import android.media.MediaPlayer



class MPAdapter (val word: String,context: Context,res : Resources,val pack : String) {
    val mp = MediaPlayer.create(context,
            res.getIdentifier(word, "raw", pack))
}

/*"ss${w.eng[secretNumber]
                    .replace(" ","")}"*/