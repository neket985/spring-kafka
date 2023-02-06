package com.example.springkafka

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class SampleProducer(
    private val template: KafkaTemplate<String, SampleDto>,
    @Value("\${app.topic}")
    private val topicName: String
) {
    @PostConstruct
    fun init(){
        produceRandom()
    }

    fun produceRandom() = SampleDto(Random.nextInt(), "sample-name").let {
        template.send(topicName, it.id.toString(), it)
    }
}