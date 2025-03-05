package com.example.macy

class UserRepository(private val userDao: UserDao) {
    suspend fun signUp(user: User) = userDao.insert(user)
    suspend fun signIn(email: String, passwordHash: String): User? {
        return userDao.getUserByEmail(email)?.takeIf { it.passwordHash == passwordHash }
    }
    suspend fun updateUser(user: User) = userDao.update(user)
}