package edu.csun.orgtrac.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.toast
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_loading.loading_message
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoadingActivity : AppCompatActivity() {
    @Inject lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        component.inject(this)
    }

    override fun onResume() {
        super.onResume()
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
                    toast(throwable.message.orEmpty())
                }
            )
    }

    private fun updateLoadingPage() {
        dataManager.loadingPage?.let {
            title = it.title
            loading_message.text = it.message
        }
    }
}
