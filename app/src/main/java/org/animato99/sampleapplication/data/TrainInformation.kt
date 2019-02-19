package org.animato99.sampleapplication.data

import java.time.ZonedDateTime

class TrainInformation(
    private val context: String,
    private val id: String,
    private val type: String,
    private val date: ZonedDateTime,
    private val valid: ZonedDateTime,
    private val operator: String,
    private val timeOfOrigin: ZonedDateTime,
    private val railway: String,
    private val trainInformationStatus: String,
    private val trainInformationText: String
)