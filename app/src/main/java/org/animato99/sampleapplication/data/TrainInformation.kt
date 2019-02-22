package org.animato99.sampleapplication.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class TrainInformation(
        @JsonProperty("@context")
        private val context: String,
        @JsonProperty("@id")
        private val id: String,
        @JsonProperty("@type")
        private val type: String,
        @JsonProperty("dc:date")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        private val date: Date,
        @JsonProperty("dct:valid")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        private val valid: Date,
        @JsonProperty("odpt:operator")
        private val operator: String,
        @JsonProperty("odpt:timeOfOrigin")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        private val timeOfOrigin: Date,
        @JsonProperty("odpt:railway")
        private val railway: String,
        @JsonProperty("odpt:trainInformationStatus")
        private val trainInformationStatus: String?,
        @JsonProperty("odpt:trainInformationText")
        private val trainInformationText: String
)