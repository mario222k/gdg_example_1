package de.mario222k.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.mario222k.gdglib1.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), LoginFragment.LoginListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag("LoginFragment") == null) {
            LoginFragment().show(supportFragmentManager, "LoginFragment")
        }
    }

    override fun onLogin(name: String, password: String) {
        label.text = "Hello $name"
    }
}
