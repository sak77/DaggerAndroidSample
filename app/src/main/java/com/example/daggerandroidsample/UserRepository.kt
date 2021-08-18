package com.example.daggerandroidsample

import javax.inject.Inject

class UserRepository @Inject constructor (private val localDataSource: UserLocalDataSource,
private val remoteDataSource: UserRemoteDataSource) {
}