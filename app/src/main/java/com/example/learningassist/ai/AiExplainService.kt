package com.example.learningassist.ai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import com.example.learningassist.Data.QuestionEntity
import com.example.learningassist.ai.ChatRequestBean
import com.example.learningassist.ai.Message

class AiExplainService {
    suspend fun getExplanation(question: QuestionEntity): String? = withContext(Dispatchers.IO) {
        val prompt = buildPrompt(question)
        val request = ChatRequestBean(
            model = "deepseek-chat",
            messages = listOf(Message(content = prompt))
        )
        val response = RetrofitManager.api.chatCompletion(request).awaitResponse()
        if (response.isSuccessful) {
            response.body()?.choices?.firstOrNull()?.message?.content
        } else {
            null
        }
    }

    private fun buildPrompt(question: QuestionEntity): String {
        return buildString {
            append("请为以下题目生成详细讲解：\n")
            append("题型：").append(question.type).append("\n")
            append("题目：").append(question.description).append("\n")
            if (!question.optionA.isNullOrBlank()) append("A. ").append(question.optionA).append("\n")
            if (!question.optionB.isNullOrBlank()) append("B. ").append(question.optionB).append("\n")
            if (!question.optionC.isNullOrBlank()) append("C. ").append(question.optionC).append("\n")
            if (!question.optionD.isNullOrBlank()) append("D. ").append(question.optionD).append("\n")
            append("答案：").append(question.answer).append("\n")
        }
    }
} 