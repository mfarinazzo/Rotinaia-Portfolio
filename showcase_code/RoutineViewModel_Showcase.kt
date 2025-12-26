package com.murilo.proativo.ui.routine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.json.JSONObject

/**
 * [SHOWCASE] RoutineViewModel.kt (Trecho)
 * 
 * Demonstração da lógica de integração com a IA.
 * O fluxo consiste em:
 * 1. Exportar o estado atual do banco de dados para JSON.
 * 2. Enviar o JSON + Transcrição de Voz para a LLM.
 * 3. Receber o novo JSON proposto.
 * 4. Apresentar o resumo para o usuário aprovar ou refinar.
 */
class RoutineViewModel : ViewModel() {

    // ... (Outros métodos e injeções omitidos)

    private fun processWithAi(msg: VoiceMessageEntity) {
        _uiState.value = _uiState.value.copy(isAiLoading = true)
        
        viewModelScope.launch {
            try {
                // LÓGICA DE REFINAMENTO:
                // Se já existe uma proposta pendente (pendingAiJson), usamos ela como base.
                // Isso permite que o usuário diga "Não, mude para as 14h" e a IA corrija a proposta anterior.
                val currentJson = _uiState.value.pendingAiJson ?: jsonManager.exportRoutineToJson()
                
                val responseJson = geminiService.sendMessage(currentJson, msg.transcription)
                
                if (responseJson != null) {
                    val root = JSONObject(responseJson)
                    val summary = root.optString("ai_summary", "Mudanças aplicadas.")
                    
                    // O estado é atualizado com a proposta, mas NÃO é salvo no banco ainda.
                    // O usuário precisa confirmar na UI.
                    _uiState.value = _uiState.value.copy(
                        isAiLoading = false,
                        pendingAiJson = responseJson,
                        aiSummary = summary
                    )
                }
            } catch (e: Exception) {
                // Tratamento de erro
            }
        }
    }
}
