package de.mario222k.gdglib1

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : DialogFragment() {

    private var listener: LoginListener? = null

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://postman-echo.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: HackService = retrofit.create(HackService::class.java)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? LoginListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener {
            val name = userName.text.toString()
            service.hack(name, userPassword.text.toString()).enqueue(object: Callback<HackResponse> {
                override fun onFailure(call: Call<HackResponse>, t: Throwable) {
                    // no-op
                }

                override fun onResponse(
                    call: Call<HackResponse>,
                    response: Response<HackResponse>
                ) {
                    Toast.makeText(view.context, "thanks for your password $name", Toast.LENGTH_LONG).show()
                }
            })
            listener?.onLogin(userName.text.toString(), userPassword.text.toString())
            dismiss()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        listener?.onLogin("", "")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface LoginListener {
        fun onLogin(name: String, password: String)
    }
}