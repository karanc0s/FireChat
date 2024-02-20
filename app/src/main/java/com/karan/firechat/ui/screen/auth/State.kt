package com.karan.firechat.ui.screen.auth

sealed interface AuthScreenState{

    data object Initial : AuthScreenState
    data object Loading : AuthScreenState

    data class Success<T>(val data : T) : AuthScreenState

    data class Error(val message : String) : AuthScreenState


}