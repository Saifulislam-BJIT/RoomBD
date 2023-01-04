package com.saiful.roomdata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.saiful.roomdata.R
import com.saiful.roomdata.fragment.ListFragmentDirections
import com.saiful.roomdata.ui.model.User
import com.saiful.roomdata.viewModel.UserViewModel
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter(
    private val context: Context, private val userViewModel: UserViewModel
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList = emptyList<User>()

    class UserViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentData = userList[position]
        holder.itemView.firstName_tv.text = "Firstname: ${currentData.firstName.toString()}"
        holder.itemView.lastName_tv.text = "Lastnaeme: ${currentData.lastName.toString()}"
        holder.itemView.age_tv.text = "Age: ${currentData.age.toString()}"

        holder.itemView.update_button.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentData)
            holder.itemView.findNavController().navigate(action)
        }

        holder.itemView.delete_button.setOnClickListener {
            userViewModel.deleteUser(currentData)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}