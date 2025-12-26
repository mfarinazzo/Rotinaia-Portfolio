package com.murilo.proativo.domain

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * [SHOWCASE] RoutineRepository.kt
 * 
 * Contrato do Repositório (Clean Architecture).
 * Define as operações disponíveis para a camada de domínio, abstraindo a fonte de dados (Room/API).
 * 
 * Princípios aplicados:
 * - Interface Segregation (embora aqui esteja agrupado por contexto do app)
 * - Dependency Inversion (UseCases dependem desta interface, não da implementação)
 * - Uso de Flow para programação reativa
 */
interface RoutineRepository {
    
    // --- Gestão de Tarefas ---
    suspend fun upsertTask(task: RoutineTask)
    suspend fun deleteTask(id: String)
    fun getTasksForDate(date: LocalDate): Flow<List<RoutineTask>>
    
    // --- Gestão Financeira ---
    // O app trata finanças como parte da rotina
    fun getTransactionsByRange(startDate: LocalDate, endDate: LocalDate): Flow<List<TransactionEntity>>
    suspend fun upsertTransaction(transaction: TransactionEntity)
    
    // --- Estratégia Financeira ---
    // Metas e configurações de trabalho vs. estudo
    fun getFinanceStrategy(): Flow<FinanceStrategyEntity?>
    suspend fun upsertFinanceStrategy(strategy: FinanceStrategyEntity)
}
