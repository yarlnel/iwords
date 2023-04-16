package com.example.iwords;

import com.orm.SugarRecord;

public class Word extends SugarRecord<Word> {
    String rus;
    String eng;
    String translations;
    int indexe;
    public Word(){}
    public Word(String rus, String eng,String translations, int indexe){
        this.eng = eng;
        this.rus = rus;
        this.indexe = indexe;
        this.translations = translations;
    }

}
