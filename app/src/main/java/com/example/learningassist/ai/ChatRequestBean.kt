package com.example.learningassist.ai

data class ChatRequestBean(
    val model: String,
    val messages: List<Message>
)

data class Message(
    val content: String
) 