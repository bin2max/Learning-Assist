package com.example.learningassist.repository

import com.example.learningassist.Data.QuestionDao
import com.example.learningassist.Data.QuestionEntity

class QuestionRepository(private val questionDao: QuestionDao) {
    suspend fun insertQuestion(question: QuestionEntity) {
        questionDao.insertQuestion(question)
    }
    
    suspend fun getAllQuestions(): List<QuestionEntity> {
        return questionDao.getAllQuestions()
    }
} 