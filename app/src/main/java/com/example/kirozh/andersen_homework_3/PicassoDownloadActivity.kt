package com.example.kirozh.andersen_homework_3

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * @author Kirill Ozhigin on 06.10.2021
 */
class PicassoDownloadActivity: AppCompatActivity() {
    private lateinit var inputUrlEditText: EditText
    private lateinit var downloadedImageView: ImageView
    private lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputUrlEditText = findViewById(R.id.inputUrlEditText)
        downloadedImageView = findViewById(R.id.urlImageView)
        loadButton = findViewById(R.id.downloadButton)

        loadButton.setOnClickListener {
            val inputLink = inputUrlEditText.text.toString()

            val uri = Uri.parse(inputLink)
            val picassoBuilder = Picasso.Builder(this)
            picassoBuilder.listener{_, _, exception ->  exception.printStackTrace()}

            picassoBuilder
                .build()
                .load(uri)
                .into(downloadedImageView, object: Callback {
                    override fun onSuccess() {

                    }

                    override fun onError() {
                        Toast.makeText(this@PicassoDownloadActivity,
                            "Cannot download",
                            Toast.LENGTH_LONG).show()

                    }
                })

        }
    }
}