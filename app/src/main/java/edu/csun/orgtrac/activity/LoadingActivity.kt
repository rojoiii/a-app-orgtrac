package edu.csun.orgtrac.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.alert
import com.squareup.picasso.Picasso
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_loading.loading_image
import kotlinx.android.synthetic.main.activity_loading.loading_message
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoadingActivity : AppCompatActivity() {
    @Inject lateinit var dataManager: DataManager
    @Inject lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        syncAppData()
    }

    private fun syncAppData() {
        updateLoadingPage()
        dataManager.translateData()
            .timeout(10, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { myData ->
                    startActivity(LandingActivity.newIntent(this))
                    finish()
                },
                { throwable ->
                    alert(
                        title = getString(R.string.sync_error_title),
                        message = getString(R.string.sync_error_msg)
                    ) {
                        positiveButton(getString(R.string.sync_error_retry), f = {
                            syncAppData()
                        })
                        negativeButton(getString(R.string.sync_error_exit), f = {
                            finish()
                        })
                        cancellable(false)
                    }.show()
                }
            )
    }

    private fun updateLoadingPage() {
        dataManager.loadingPage?.let {
            title = it.title
            loading_message.text = it.message
            picasso
                .load(it.image)
                .into(loading_image)
        }
    }
}
