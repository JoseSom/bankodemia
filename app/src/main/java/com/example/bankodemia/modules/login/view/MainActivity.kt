package com.example.bankodemia.modules.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankodemia.databinding.ActivityMainBinding
import com.example.bankodemia.core.util.transitionFragment
import com.example.bankodemia.modules.createaccount.view.CreateAccountFragment
import com.example.bankodemia.modules.login.view.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            mainBtnLogin.setOnClickListener {
                transitionFragment(fragmentClass = LoginFragment(), supportFragmentManager)
            }

            mainBtnCreateAccount.setOnClickListener {
                transitionFragment(fragmentClass = CreateAccountFragment(), supportFragmentManager)
            }
        }
    }
}