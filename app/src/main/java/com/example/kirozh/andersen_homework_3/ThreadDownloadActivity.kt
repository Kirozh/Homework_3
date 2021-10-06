package com.example.kirozh.andersen_homework_3


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL

/**
 * @author Kirill Ozhigin on 06.10.2021
 */
class ThreadDownloadActivity: AppCompatActivity() {
    private lateinit var inputUrlEditText: EditText
    private lateinit var downloadedImageView: ImageView
    private lateinit var loadButton: Button
    private lateinit var inputStream: InputStream
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputUrlEditText = findViewById(R.id.inputUrlEditText)
        downloadedImageView = findViewById(R.id.urlImageView)
        loadButton = findViewById(R.id.downloadButton)

        loadButton.setOnClickListener {
            object: Thread() {
                override fun run() {
                    try{

                        val url = URL(inputUrlEditText.text.toString())
                        inputStream = BufferedInputStream(url.openStream(), 8000)

                        val drawable: Drawable =
                            Drawable.createFromStream(inputStream, "pic.png")
                        runOnUiThread {
                            downloadedImageView.setImageDrawable(drawable)
                        }
                        inputStream.close()
                    }
                    catch (e: MalformedURLException) {
                        Log.d("malformedurlexception", e.printStackTrace().toString())
                    }
                    catch (e: URISyntaxException) {
                        Log.d("urisyntaxexception", e.printStackTrace().toString())
                    }
                    catch (e: IOException) {
                        Log.d("ioexception", e.printStackTrace().toString())
                    }
                }
            }
            .start()

            }

        }

}