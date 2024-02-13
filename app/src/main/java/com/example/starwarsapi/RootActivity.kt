package com.example.starwarsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starwarsapi.characters.ui.fragment.CharactersFragment
import com.example.starwarsapi.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationView = binding.bottomNavigationView

        navigationView.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.rootFragmentContainerView, HomeFragment())
                        .commit()
                    return@setOnItemSelectedListener true
                }

                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.rootFragmentContainerView, CharactersFragment())
                        .commit()
                    return@setOnItemSelectedListener true
                }
            }

        }
    }
}