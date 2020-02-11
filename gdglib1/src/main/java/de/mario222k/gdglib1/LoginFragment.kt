package de.mario222k.gdglib1

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : DialogFragment() {

    private var listener: LoginListener? = null

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