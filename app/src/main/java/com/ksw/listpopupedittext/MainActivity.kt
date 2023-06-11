package com.ksw.listpopupedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksw.listpopupedittext.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewBind : ActivityMainBinding
    private val petNames = listOf("大橘","狸花","三花","奶牛","柯基","金毛")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind= ActivityMainBinding.inflate(layoutInflater);
        setContentView(viewBind.root)
        viewBind.listPetName.setItems(petNames)

    }
}