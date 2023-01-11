package com.example.permission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.shape.ShapeAppearanceModel.builder
import java.util.stream.DoubleStream.builder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.clickbtn)
        var text = findViewById<TextView>(R.id.textview)
        var img = findViewById<ImageView>(R.id.app)
        var txt  = findViewById<TextView>(R.id.text)
        var edit = findViewById<EditText>(R.id.edit)
        var button2 = findViewById<Button>(R.id.btn2)


        button2.setOnClickListener{
            val text = edit.text.toString()
            Toast.makeText(applicationContext,"given text is :"+text , Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener{

            val builder = AlertDialog.Builder(this)
                .setTitle("Are you want to allow user to take picture?")
                .setPositiveButton("Allow"){dialog,which ->


                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)

                }
                .setNegativeButton("Not"){
                    dialog,which -> {
                        Toast.makeText(applicationContext,"Not allowed to take picture",Toast.LENGTH_SHORT).show()
                }
                }

                .create()
             builder.show()
        }
    }
}