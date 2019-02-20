package org.animato99.sampleapplication.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.key.ZonedDateTimeKeyDeserializer
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@JsonIgnoreProperties(ignoreUnknown = true)
class TrainInformation(
        @JsonProperty("@context")
        private val context: String,
        @JsonProperty("@id")
        private val id: String,
        @JsonProperty("@type")
        private val type: String,
        @JsonProperty("dc:date")
        @JsonDeserialize(using = InstantDeserializer::class)
        private val date: ZonedDateTime,
        @JsonProperty("dct:valid")
        @JsonDeserialize(using = InstantDeserializer::class)
        private val valid: ZonedDateTime,
        @JsonProperty("odpt:operator")
        private val operator: String,
        @JsonProperty("odpt:timeOfOrigin")
        @JsonDeserialize(using = InstantDeserializer::class)
        private val timeOfOrigin: ZonedDateTime,
        @JsonProperty("odpt:railway")
        private val railway: String,
        @JsonProperty("odpt:trainInformationStatus")
        private val trainInformationStatus: String,
        @JsonProperty("odpt:trainInformationText")
        private val trainInformationText: String
)