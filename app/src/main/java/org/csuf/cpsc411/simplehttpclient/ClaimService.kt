package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity

class ClaimService (val ctx : Context) {

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "the add Service response: ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            TODO("Not yet implemented")
        }
    }

    fun addClaim(cObj : Claim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.86.177:8080/ClaimService/add"
        // 1. convert cObj to JSON string
        val jsonStr = Gson().toJson(cObj)
        // 2. send post request
        val cJsonString = Gson().toJson(cObj)
        val entity = StringEntity(cJsonString)
        // ctx is Android application context object
        client.post(ctx, requestUrl, entity, "application/json", addServiceRespHandler())
    }

}