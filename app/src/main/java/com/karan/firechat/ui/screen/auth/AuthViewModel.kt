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

    private val _screenState = MutableStateFlow<AuthScreenState>(AuthScreenState.Initial)
    val state = _screenState.asStateFlow()

    // d

    init {
        Log.e("TAG", "signIn: ", )
    }

    var emailText = mutableStateOf("")
    var passText = mutableStateOf("")

    fun signIn(email : String , pass : String){
        Log.e("TAG", "signIn: ", )
        viewModelScope.launch {
            authUseCases.signIn.signIn(email, pass).collect{result ->
                when(result){
                    Result.Loading -> {
                        _screenState.value = AuthScreenState.Loading
                    }
                    is Result.Error -> {
                        _screenState.value = AuthScreenState.Error(result.error)
                    }
                    is Result.Success -> {
                        _screenState.value = AuthScreenState.Success(data = true)
                    }
                }
            }
        }
    }
    fun signUp(email : String , pass : String){
        viewModelScope.launch {
            authUseCases.signUp.signUp(email, pass).collect{result ->
                when(result){
                    Result.Loading -> {
                        _screenState.value = AuthScreenState.Loading
                    }
                    is Result.Error -> {
                        _screenState.value = AuthScreenState.Error(result.error)
                    }
                    is Result.Success -> {
                        _screenState.value = AuthScreenState.Success(data = true)
                    }
                }
            }
        }
    }
    fun isUserAuthenticated(email : String , pass : String){
        viewModelScope.launch {
            authUseCases.isUserAuthenticated.isUserAuthenticated(email, pass).collect{result ->
                when(result){
                    Result.Loading -> {
                        _screenState.value = AuthScreenState.Loading
                    }
                    is Result.Error -> {
                        _screenState.value = AuthScreenState.Error(result.error)
                    }
                    is Result.Success -> {
                        _screenState.value = AuthScreenState.Success(data = true)
                    }
                }
            }
        }
    }



}