package com.example.learningassist.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class TtsManager(private val context: Context) {
    private var textToSpeech: TextToSpeech? = null
    
    fun initTts(onInitListener: TextToSpeech.OnInitListener) {
        textToSpeech = TextToSpeech(context, onInitListener)
    }
    
    fun speak(text: String) {
        textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
    
    fun shutdown() {
        textToSpeech?.shutdown()
    }
} 