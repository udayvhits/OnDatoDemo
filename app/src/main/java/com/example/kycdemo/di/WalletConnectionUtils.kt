package com.example.kycdemo.di

import android.app.Activity
import com.walletconnect.android.Core
import com.walletconnect.android.CoreClient
import com.walletconnect.android.internal.common.scope
import com.walletconnect.android.relay.ConnectionType
import com.walletconnect.notify.client.Notify
import com.walletconnect.notify.client.NotifyClient
import com.walletconnect.web3.wallet.client.Wallet
import com.walletconnect.web3.wallet.client.Web3Wallet
import kotlinx.coroutines.launch


object WalletConnectionUtils {

    fun initialWalletConnection(activity: Activity) {
        val RELAY_URL = "relay.walletconnect.com"
        val serverUrl = "wss://$RELAY_URL?projectId=${"824564565ad5gh"}"
        val appMetaData = Core.Model.AppMetaData(
            name = "PlutoPe Wallet",
            description = "PlutoPe Wallet Implementation",
            url = "https://www.plutope.io/",
            icons = listOf("https://plutope.app/api/images/applogo.png"),
            redirect = "kotlin-web3wallet:/request"
        )

        CoreClient.initialize(
            relayServerUrl = serverUrl,
            connectionType = ConnectionType.AUTOMATIC,
            application = activity.application,
            metaData = appMetaData
        ) { error ->
            print(error.throwable.stackTraceToString())
            scope.launch {
                // connectionStateFlow.emit(ConnectionState.Error(error.throwable.message ?: ""))
            }
        }

        val initParams = Wallet.Params.Init(core = CoreClient)


        Web3Wallet.initialize(initParams) { error ->
            print(error.throwable.stackTraceToString())
        }

        NotifyClient.initialize(
            init = Notify.Params.Init(CoreClient)
        ) { error ->
            //  Firebase.crashlytics.recordException(error.throwable)

        }


    }


}
















