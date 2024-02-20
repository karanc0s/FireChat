package com.karan.firechat.di

import com.karan.firechat.domain.repository.AuthRepository
import com.karan.firechat.domain.usecases.auth.AuthUseCases
import com.karan.firechat.domain.usecases.auth.IsUserAuthenticated
import com.karan.firechat.domain.usecases.auth.SignIn
import com.karan.firechat.domain.usecases.auth.SignUp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesAuthUseCase(authRepository: AuthRepository) = AuthUseCases(
        isUserAuthenticated = IsUserAuthenticated(authRepository),
        signIn = SignIn(authRepository),
        signUp = SignUp(authRepository)
    )






}