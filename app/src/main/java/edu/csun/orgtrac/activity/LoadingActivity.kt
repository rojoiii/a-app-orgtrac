package edu.csun.orgtrac.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.contentful.vault.SyncCallback
import com.contentful.vault.SyncConfig
import com.contentful.vault.SyncResult
import com.contentful.vault.Vault
import com.pawegio.kandroid.alert
import com.pawegio.kandroid.toast
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import javax.inject.Inject

class LoadingActivity : AppCompatActivity() {
    @Inject lateinit var vault: Vault
    @Inject lateinit var syncConfig: SyncConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        component.inject(this)

        updateLoadingPage()
        syncAppData()
    }

    private fun updateLoadingPage() {
    }

    private fun syncAppData() {
        vault.requestSync(syncConfig, object : SyncCallback() {
            override fun onResult(result: SyncResult?) {
                if (result != null) {
                    toast("We Synced!")
                } else {
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
            }
        })
    }
}
