package com.saiful.roomdata.repository

import androidx.lifecycle.LiveData
import com.saiful.roomdata.ui.model.User
import com.saiful.roomdata.ui.model.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllUser: LiveData<List<User>> = userDao.readAllUser()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun userUpdate(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}