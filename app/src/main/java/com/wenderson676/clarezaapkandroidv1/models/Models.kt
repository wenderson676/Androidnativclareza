package com.wenderson676.clarezaapkandroidv1.models

import kotlinx.serialization.Serializable

enum class TransactionType { income, expense, transfer_to_savings, transfer_from_savings, transfer_between_accounts }

enum class BudgetMode { P50_30_20, P80_10_10, P90_5_5, P70_0_30, P50_20_30 }

@Serializable
data class Account(
    val id: String,
    val name: String,
    val icon: String,
    val isMain: Boolean? = null,
    val type: String,
    val initialBalance: Double? = 0.0
)

@Serializable
data class Debt(
    val id: String,
    val name: String,
    val totalAmount: Double,
    val monthlyPayment: Double,
    val interestRate: Double,
    val isLate: Boolean,
    val creditor: String,
    val type: String
)

@Serializable
data class Transaction(
    val id: String,
    val date: String, // ISO YYYY-MM-DD
    val description: String,
    val amount: Double,
    val type: TransactionType,
    val category: String,
    val bucket: String,
    val notes: String? = null,
    val isPending: Boolean? = false,
    val account: String? = null,
    val toAccount: String? = null
)

@Serializable
data class MonthlyData(
    val monthId: String,
    val transactions: List<Transaction> = emptyList(),
    val devotionalNote: String? = null
)

@Serializable
data class Goal(
    val id: String,
    val title: String,
    val targetAmount: Double,
    val currentAmount: Double
)

@Serializable
data class Asset(
    val id: String,
    val name: String,
    val value: Double,
    val type: String
)

@Serializable
data class AppState(
    val monthlyData: Map<String, MonthlyData> = emptyMap(),
    val goals: List<Goal> = emptyList(),
    val assets: List<Asset> = emptyList(),
    val userName: String? = null,
    val budgetMode: String? = null,
    val debts: List<Debt>? = null,
    val dashboardCardOrder: List<String>? = null,
    val accounts: List<Account>? = null,
    val customCategories: Map<String, List<String>>? = null
)
