package group.payback.codingchallengeapplication.di.repositoriesmodules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import group.payback.codingchallengeapplication.data.local.LocalDataSource
import group.payback.codingchallengeapplication.data.remote.RemoteDataSource
import group.payback.codingchallengeapplication.data.repositories.ImageDetailsRepository
import group.payback.codingchallengeapplication.data.repositories.ImageDetailsRepositoryImpl
import group.payback.codingchallengeapplication.data.repositories.ImagesRepository
import group.payback.codingchallengeapplication.data.repositories.ImagesRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImagesRepoModule {
    @Singleton
    @Provides
    fun provideImagesRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): ImagesRepository {
        return ImagesRepositoryImpl(remoteDataSource, localDataSource)
    }
    @Singleton
    @Provides
    fun provideImageDetailsRepository(localDataSource: LocalDataSource): ImageDetailsRepository {
        return ImageDetailsRepositoryImpl(localDataSource)
    }
}