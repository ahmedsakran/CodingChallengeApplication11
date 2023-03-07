package group.payback.codingchallengeapplication.di.usecasesmodules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import group.payback.codingchallengeapplication.domain.usecases.GetImageDetailsUseCase
import group.payback.codingchallengeapplication.domain.usecases.GetImageDetailsUseCaseImpl
import group.payback.codingchallengeapplication.domain.usecases.GetImagesUseCase
import group.payback.codingchallengeapplication.domain.usecases.GetImagesUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ImagesUseCaseModule {
    @Binds
    @Singleton
    fun provideGetImagesUseCase(getImagesUseCaseImpl: GetImagesUseCaseImpl): GetImagesUseCase

    @Binds
    @Singleton
    fun provideGetImageDetailsUseCase(getImageDetailsUseCaseImpl: GetImageDetailsUseCaseImpl): GetImageDetailsUseCase
}