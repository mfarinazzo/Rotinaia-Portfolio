package com.murilo.proativo.data

import org.json.JSONObject
import java.time.LocalDate

/**
 * [SHOWCASE] RoutineJsonManager.kt (Trecho)
 * 
 * Responsável por serializar o banco de dados (Room) para JSON (para a IA ler)
 * e desserializar o JSON da IA de volta para entidades do banco.
 * 
 * Desafio Técnico: Garantir que a IA não quebre a integridade dos dados ao gerar o JSON.
 * Solução: Uso de valores padrão (fallback) e validação de tipos durante o parsing.
 */
class RoutineJsonManager {

    // ...

    suspend fun importJsonToRoutine(jsonString: String) {
        try {
            val root = JSONObject(jsonString)

            // Exemplo de Parsing Robusto:
            // A IA as vezes esquece o campo 'title' ou usa 'description' no lugar.
            // Aqui garantimos que o app não quebre e tente inferir o dado.
            
            if (root.has("routine_tasks")) {
                val tasksArray = root.getJSONArray("routine_tasks")
                
                for (i in 0 until tasksArray.length()) {
                    val t = tasksArray.getJSONObject(i)
                    
                    // Fallback inteligente para título
                    var title = t.optString("title")
                    if (title.isBlank()) {
                        title = t.optString("description", "Nova Tarefa").take(20)
                    }

                    // ... (Criação da entidade RoutineTask)
                }
            }
            
            // ... (Lógica similar para Finanças e Agenda)
            
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
