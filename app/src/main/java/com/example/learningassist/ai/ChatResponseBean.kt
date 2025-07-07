package com.example.learningassist.ai

data class ChatResponseBean(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
) 