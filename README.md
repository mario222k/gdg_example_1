# gdg_example_1
Example for an bad library. By clearing history

I uploaded first an hacky variant that forwards all user input to an webservice.
Then I deployed v1.0 and reverted all hack code.
Afterwards I force pushed on master and all the badass code is gone. But still exists in the artifact

## Implementation`
Add repo to project build.gradle
```
    maven { url 'https://jitpack.io' }
```

Add library to the app build.gradle
```
    implementation 'com.github.mario222k:gdg_example_1:1.0'
```

Call the Fragment
```
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
```