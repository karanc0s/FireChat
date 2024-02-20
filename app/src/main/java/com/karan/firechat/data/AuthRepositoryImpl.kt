package com.karan.firechat.data

import com.google.firebase.auth.FirebaseAuth
import com.karan.firechat.domain.repository.AuthRepository
import com.karan.firechat.utils.Result
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await


class AuthRepositoryImpl(private val firebaseAuth: FirebaseAuth): AuthRepository {
    override fun isUserAuthenticated(email: String, pass: String): Flow<Result<Boolean>> = flow {
        emit(Result.Loading)

        try {
            if(firebaseAuth.currentUser != null){
                emit(Result.Success<Boolean>(data = true))
            }else{
                emit(Result.Success<Boolean>(data = false))
            }
        }catch (e : Exception){
            emit(Result.Error(error = e.message ?: "Error"))
        }
    }

    override fun signIn(email: String, pass: String): Flow<Result<Boolean>> = callbackFlow{
        this@callbackFlow.trySendBlocking(Result.Loading)

        try {
            firebaseAuth.signInWithEmailAndPassword(email , pass).apply {
                this.await()

                if(this.isSuccessful){
                    this@callbackFlow.trySendBlocking(Result.Success<Boolean>(data = true))
                }else{
                    this@callbackFlow.trySendBlocking(Result.Success<Boolean>(data = false))
                }

            }
        }catch (e : Exception){
            this@callbackFlow.trySendBlocking(Result.Error(error = e.message ?: "Error"))

        }
        awaitClose {
            channel.close()
            cancel()
        }
    }

    override fun signUp(email: String, pass: String): Flow<Result<Boolean>> = callbackFlow {

        this@callbackFlow.trySendBlocking(Result.Loading)

        try {
            firebaseAuth.createUserWithEmailAndPassword(email , pass)
                .addOnSuccessListener {
                    this@callbackFlow.trySendBlocking(Result.Success<Boolean>(data = true))
                }
                .addOnFailureListener {
                    this@callbackFlow.trySendBlocking(Result.Success<Boolean>(data = false))
                }

        }catch (e : Exception){
            this@callbackFlow.trySendBlocking(Result.Error(error = e.message ?: "Error"))

        }

        awaitClose {
            channel.close()
            cancel()
        }
    }
}