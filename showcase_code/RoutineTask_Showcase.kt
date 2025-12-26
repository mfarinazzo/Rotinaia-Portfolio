package com.murilo.proativo.domain

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

/**
 * [SHOWCASE] RoutineTask.kt
 * 
 * Entidade de Domínio (Clean Architecture).
 * Representa o núcleo da lógica de negócios do app: uma tarefa da rotina.
 * 
 * Princípios aplicados:
 * - Imutabilidade (val)
 * - Independência de Framework (sem dependências Android)
 * - Tipagem forte (Enums para Kind e Importance)
 */
data class RoutineTask(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String? = null,
    
    // Define se é uma tarefa única ou recorrente
    val kind: TaskKind,
    
    // Nível de prioridade para o algoritmo de reagendamento
    val importance: Importance,
    
    val startTime: LocalTime,
    val durationMinutes: Int,
    
    // Campos opcionais dependendo do 'kind'
    val scheduledDate: LocalDate? = null,
    val daysOfWeek: List<DayOfWeek>? = null,
    
    val isDone: Boolean = false
)

enum class TaskKind {
    SINGLE,
    RECURRING
}

enum class Importance {
    LOW, MEDIUM, HIGH, CRITICAL
}
