package com.saiful.roomdata.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saiful.roomdata.R
import com.saiful.roomdata.ui.model.User
import com.saiful.roomdata.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {

    lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        add_button.setOnClickListener { addUserIntoDatabase() }
    }

    private fun addUserIntoDatabase() {
        val fastName = firstname_et.text.toString()
        val lastName = lastname_et.text.toString()
        val age = age_et.text.toString()

        if (!TextUtils.isEmpty(fastName) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(age)) {
            val user = User(0, fastName, lastName, Integer.parseInt(age))
            viewModel.addUser(user)
        }
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }

}