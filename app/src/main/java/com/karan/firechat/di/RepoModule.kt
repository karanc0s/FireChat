package com.karan.firechat.di

import com.google.firebase.auth.FirebaseAuth
import com.karan.firechat.data.AuthRepositoryImpl
import com.karan.firechat.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun providesAuthRepository(firebaseAuth: FirebaseAuth) : AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }



}