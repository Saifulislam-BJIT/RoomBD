package com.saiful.roomdata.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.saiful.roomdata.R
import com.saiful.roomdata.ui.model.User
import com.saiful.roomdata.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*


class UpdateFragment : Fragment() {

    private val agrs by navArgs<UpdateFragmentArgs>()
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = agrs.currentUser
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]


        firstname_et_update.setText(user.firstName.toString())
        lastname_et_update.setText(user.lastName.toString())
        age_et_update.setText(user.age.toString())

        update_button.setOnClickListener {
            val id = user.id
            val firstName = firstname_et_update.text.toString()
            val lastName = lastname_et_update.text.toString()
            val age = Integer.parseInt(age_et_update.text.toString())
            val user = User(id, firstName, lastName, age)
            viewModel.updateUser(user)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
    }
}