package org.csuf.cpsc411.simplehttpclient

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class PersonService (val ctx : CustomActivity) {

    lateinit var personList : MutableList<Person>
    var currentIndx : Int = 0

    fun next() : Person {
        currentIndx += 1
        return personList[currentIndx]
    }

    inner class GetAllServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            // JSON string
            if (responseBody != null) {
                Log.d("Person Service", "The response JSON string is ${String(responseBody)}")
                val gson = Gson()
                val personListType: Type = object : TypeToken<List<Person>>() {}.type
                personList = gson.fromJson(String(responseBody), personListType)
                //
//                ctx.refreshScreen(personList[currentIndx])
                //
                //act.runOnUiThread {
                //    cbLambdaFunction()
                //}
                Log.d("Person Service", "The Person List: ${personList}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {

        }
    }

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Person Service", "The add Service response : ${respStr}")
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

    fun addPerson(pObj : Person) {
        val client = AsyncHttpClient()
        // my ipv4 : 192.168.86.177
        val requestUrl = "http://192.168.86.117:8010/PersonService/add"
        // 1. Convert the pObj into JSON string
        val pJsonString= Gson().toJson(pObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }

    fun getAll()  {
        //var pList : List<Person> = mutableListOf()
        // Call Http
        //clientObj = clObj
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.0.112:8010/PersonService/getAll"
        //
        Log.d("Person Service", "About Sending the HTTP Request. ")
        //
        client.get(requestUrl, GetAllServiceRespHandler())
    }
}