package com.saiful.roomdata.ui.model

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllUser: LiveData<List<User>> = userDao.readAllUser()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}