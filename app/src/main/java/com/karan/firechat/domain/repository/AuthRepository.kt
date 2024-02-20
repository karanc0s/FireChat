package com.karan.firechat.domain.repository

import com.karan.firechat.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun isUserAuthenticated(email : String , pass: String) : Flow<Result<Boolean>>
    fun signIn(email : String , pass : String) : Flow<Result<Boolean>>
    fun signUp(email: String , pass : String) : Flow<Result<Boolean>>
}