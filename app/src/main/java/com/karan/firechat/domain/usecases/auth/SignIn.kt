package com.karan.firechat.domain.usecases.auth

import com.karan.firechat.domain.repository.AuthRepository

class SignIn (private val authRepository: AuthRepository){

    fun signIn(email : String , pass : String) = authRepository.signIn(email, pass)

}