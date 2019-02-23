package org.animato99.sampleapplication.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class TrainInformation(
        @JsonProperty("@context")
        val context: String,
        @JsonProperty("@id")
        val id: String,
        @JsonProperty("@type")
        val type: String,
        @JsonProperty("dc:date")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        val date: Date,
        @JsonProperty("dct:valid")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        val valid: Date,
        @JsonProperty("odpt:operator")
        val operator: String,
        @JsonProperty("odpt:timeOfOrigin")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        val timeOfOrigin: Date,
        @JsonProperty("odpt:railway")
        val railway: String,
        @JsonProperty("odpt:trainInformationStatus")
        val trainInformationStatus: String?,
        @JsonProperty("odpt:trainInformationText")
        val trainInformationText: String
)