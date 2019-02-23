package org.animato99.sampleapplication.data.source.remote

import android.os.Handler
import android.os.Looper
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.*
import org.animato99.sampleapplication.data.TrainInformation
import org.animato99.sampleapplication.data.source.MetroDataSource
import org.animato99.sampleapplication.data.source.MetroDataSource.GetTrainInformationCallback
import java.io.IOException
import java.util.*

class MetroDataSourceRemote(
        private val httpClient: OkHttpClient
) : MetroDataSource {

    private val objectMapper : ObjectMapper by lazy { ObjectMapper() }

    override fun getTrainInformation(callback: GetTrainInformationCallback) {
        val urlBuilder: HttpUrl.Builder = HttpUrl.parse("https://api.tokyometroapp.jp/api/v2/datapoints")!!.newBuilder()

        val params = mapOf("rdf:type" to "odpt:TrainInformation",
                "acl:consumerKey" to "ecfc8dfc79e7428d1c1c18a120dc8da2ca474882d95bcebc10b6e41dca6d49e3")
        params.forEach { entry -> urlBuilder.addQueryParameter(entry.key, entry.value) }
        val request = Request.Builder().url(urlBuilder.build()).build()

        val handler = Handler(Looper.getMainLooper())
        httpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                handler.post {
                    callback.onFailure()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val res = response.body()?.string()
                val info = objectMapper.readValue<List<TrainInformation>>(res, object : TypeReference<List<TrainInformation>>() {})
                handler.post {
                    callback.onResponse(info, response.code())
                }
            }
        })
    }
}