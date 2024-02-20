package com.karan.firechat.domain.usecases.auth

data class AuthUseCases(
    val isUserAuthenticated: IsUserAuthenticated,
    val signIn: SignIn,
    val signUp: SignUp,
)
