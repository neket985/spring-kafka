package com.example.springkafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class SampleConsumer(
) {

    @KafkaListener(topics = ["\${app.topic}"])
    fun consume(data: SampleDto) {
        println("received: $data")
    }
}