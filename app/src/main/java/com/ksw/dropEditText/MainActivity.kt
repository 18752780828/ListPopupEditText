package com.ksw.dropEditText

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksw.dropEditText.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val petNames = listOf("大橘","狸花","三花","奶牛","柯基","金毛")
    private lateinit var viewBind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind= ActivityMainBinding.inflate(layoutInflater);
        setContentView(viewBind.root)
        viewBind.listPetName.setItems(petNames)


    }
}