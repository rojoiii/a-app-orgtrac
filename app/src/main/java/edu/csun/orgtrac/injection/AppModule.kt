package edu.csun.orgtrac.injection

import android.app.Application
import android.content.Context
import com.contentful.java.cda.CDAClient
import com.contentful.vault.SyncConfig
import com.contentful.vault.Vault
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.R
import edu.csun.orgtrac.Space
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    internal fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideVault(context: Context): Vault {
        return Vault.with(context, Space::class.java)
    }

    @Provides
    @Singleton
    fun provideCDAClient(context: Context): CDAClient {
        return CDAClient.builder()
            .setToken(context.getString(R.string.cf_cda_token))
            .setSpace(context.getString(R.string.cf_space_id))
            .build()
    }

    @Provides
    @Singleton
    fun provideSync(cdaClient: CDAClient): SyncConfig {
        return SyncConfig.builder()
            .setClient(cdaClient)
            .setInvalidate(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideDataManager(vault: Vault, syncConfig: SyncConfig): DataManager {
        return DataManager(vault, syncConfig)
    }

    @Provides
    @Singleton
    fun providePicasso(context: Context): Picasso {
        return Picasso.Builder(context)
            .downloader(
                OkHttp3Downloader(
                    OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .build()
                )
            )
            .build()
    }
}