package com.karan.firechat.ui.screen.auth

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karan.firechat.domain.usecases.auth.AuthUseCases
import com.karan.firechat.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
) : ViewModel() {


    init {
        Log.e("TAG", "signIn: ", )
    }


    fun signIn(email : String , pass : String , onSuccess : (Boolean)->Unit , onFailure : (String)->Unit){
        Log.e("TAG", "signIn: ", )
        viewModelScope.launch {
            authUseCases.signIn.signIn(email, pass).collect{result ->
                when(result){
                    Result.Loading -> {}
                    is Result.Error -> {
                        onFailure(result.error)
                    }
                    is Result.Success -> {
                        onSuccess(result.data)
                    }
                }
            }
        }
    }
    fun signUp(email : String , pass : String,onSuccess : (Boolean)->Unit , onFailure : (String)->Unit){
        viewModelScope.launch {
            authUseCases.signUp.signUp(email, pass).collect{result ->
                when(result){
                    Result.Loading -> {}
                    is Result.Error -> {
                        onFailure(result.error)
                    }
                    is Result.Success -> {
                        onSuccess(result.data)
                    }
                }
            }
        }
    }
    fun isUserAuthenticated(email : String , pass : String,onSuccess : (Boolean)->Unit , onFailure : (String)->Unit){
        viewModelScope.launch {
            authUseCases.isUserAuthenticated.isUserAuthenticated(email, pass).collect{result ->
                when(result){
                    Result.Loading -> {}
                    is Result.Error -> {
                        onFailure(result.error)
                    }
                    is Result.Success -> {
                        onSuccess(result.data)
                    }
                }
            }
        }
    }



}