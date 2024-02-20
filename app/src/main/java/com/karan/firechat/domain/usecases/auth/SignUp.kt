package com.karan.firechat.domain.usecases.auth

import com.karan.firechat.domain.repository.AuthRepository

class SignUp (private val authRepository: AuthRepository) {

    fun signUp(email : String , pass : String) =
        authRepository.signUp(email , pass)
}