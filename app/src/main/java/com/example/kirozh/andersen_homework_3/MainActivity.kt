package com.example.kirozh.andersen_homework_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val picassoIntent = Intent(this, PicassoDownloadActivity:: class.java)
//        startActivity(picassoIntent)
        val threadIntent = Intent(this, ThreadDownloadActivity::class.java)
        startActivity(threadIntent)
    }

}