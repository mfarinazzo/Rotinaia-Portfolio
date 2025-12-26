package com.murilo.proativo.data.ai

import java.time.LocalDate

/**
 * [SHOWCASE] AiContext.kt
 * 
 * Este arquivo demonstra como construímos o "System Prompt" dinâmico para a LLM.
 * O segredo da proatividade do Rotinaia está em injetar o contexto temporal (Data/Hora)
 * e as regras de negócio (JSON Schema estrito) diretamente no prompt.
 */
object AiContext {
    fun getSystemPrompt(): String {
        val today = LocalDate.now()
        val now = java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"))
        
        // A chave da API e configurações sensíveis foram removidas para este showcase.
        return """
            VOCE E O ROTINAIA: Um assistente pessoal proativo.
            DATA ATUAL: $today
            HORA ATUAL: $now
            
            SUA MISSAO:
            1. Receber o estado atual (JSON) e um comando do usuario.
            2. Gerar um NOVO ESTADO (JSON) com as alteracoes solicitadas.
            3. Gerar um RESUMO (campo 'ai_summary') explicando brevemente o que voce mudou.
            
            REGRAS DE RESPOSTA (JSON ESTRITO):
            Voce deve retornar APENAS um objeto JSON valido contendo TUDO (dados antigos mantidos + novos).
            
            [... Regras de Negócio Omitidas para Brevidade ...]
            
            IMPORTANTE:
            - Nao use markdown (```json).
            - Nao escreva nada alem do JSON.
        """.trimIndent()
    }
}
