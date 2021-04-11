package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.androidseminar.databinding.ActivityHomeBinding
import org.sopt.androidseminar.databinding.ActivitySignupBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeLog", "onCreate")
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeLog", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeLog", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeLog", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeLog", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeLog", "onDestroy")
    }
}