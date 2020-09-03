package com.it.roomdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.it.roomdemo.data.LoginInfo
import com.it.roomdemo.databinding.FragmentLoginBinding
import com.it.roomdemo.viewmodel.LoginViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private val loginModel: LoginViewModel = LoginViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val databind = FragmentLoginBinding.inflate(layoutInflater, container, false)
        databind.loginmodel = loginModel
        databind.loginInfo = LoginInfo()
        return databind.root
    }


}