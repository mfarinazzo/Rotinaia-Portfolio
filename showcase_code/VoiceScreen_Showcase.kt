package com.murilo.proativo.ui.voice

import android.speech.SpeechRecognizer
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

/**
 * [SHOWCASE] VoiceScreen.kt (Trecho Simplificado)
 * 
 * Interface de Usuário com Jetpack Compose.
 * Demonstra a integração com a API de reconhecimento de fala do Android (SpeechRecognizer)
 * dentro de um ambiente declarativo.
 */
@Composable
fun VoiceScreen(
    isAiLoading: Boolean,
    onSaveMessage: (String) -> Unit
) {
    val context = LocalContext.current
    var isRecording by remember { mutableStateOf(false) }
    var transcription by remember { mutableStateOf("") }
    
    // Configuração do SpeechRecognizer (Android Nativo)
    val speechRecognizer = remember { SpeechRecognizer.createSpeechRecognizer(context) }
    
    // Efeito para gerenciar o ciclo de vida do listener
    DisposableEffect(Unit) {
        val listener = object : RecognitionListener {
            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (!matches.isNullOrEmpty()) {
                    transcription = matches[0]
                    // Callback para a ViewModel processar com a IA
                    onSaveMessage(transcription)
                }
            }
            // ... outros callbacks omitidos
        }
        speechRecognizer.setRecognitionListener(listener)
        onDispose { speechRecognizer.destroy() }
    }

    // UI Declarativa
    Box(contentAlignment = Alignment.Center) {
        if (isAiLoading) {
            CircularProgressIndicator()
        } else {
            RecordButton(
                isRecording = isRecording,
                onStartRecording = { 
                    isRecording = true
                    speechRecognizer.startListening(intent) 
                },
                onStopRecording = { 
                    isRecording = false
                    speechRecognizer.stopListening() 
                }
            )
        }
    }
}
