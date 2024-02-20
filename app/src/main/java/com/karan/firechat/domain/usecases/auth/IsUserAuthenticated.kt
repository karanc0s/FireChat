package com.karan.firechat.domain.usecases.auth

import com.karan.firechat.domain.repository.AuthRepository

class IsUserAuthenticated (private val authRepository: AuthRepository) {

    fun isUserAuthenticated(email : String , pass : String) =
        authRepository.isUserAuthenticated(email, pass)
}