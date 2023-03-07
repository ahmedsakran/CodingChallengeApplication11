package group.payback.codingchallengeapplication.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import group.payback.codingchallengeapplication.data.local.ImagesCacheDatabase
import group.payback.codingchallengeapplication.data.local.dao.HitDao
import group.payback.codingchallengeapplication.data.local.dao.SearchDao
import group.payback.codingchallengeapplication.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        ImagesCacheDatabase::class.java,
        Constants.DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideHitSearchCrossRefDao(database: ImagesCacheDatabase) = database.hitSearchCrossRefDao()

    @Singleton
    @Provides
    fun provideSearchDao(database: ImagesCacheDatabase) = database.searchDao()

    @Singleton
    @Provides
    fun provideHitDao(database: ImagesCacheDatabase) = database.hitDao()

}