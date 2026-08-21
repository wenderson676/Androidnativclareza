package com.wenderson676.clarezaapkandroidv1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.wenderson676.clarezaapkandroidv1.models.*

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(AppState(monthlyData = emptyMap(), goals = emptyList(), assets = emptyList()))
    val state: StateFlow<AppState> = _state

    // Example: initialize or migrate data
    init {
        // load persisted state from DataStore (to be implemented)
    }

    fun addTransaction(monthId: String, transaction: Transaction) {
        viewModelScope.launch {
            val current = _state.value
            val month = current.monthlyData[monthId]
            val newMonth = month?.copy(transactions = listOf(transaction) + (month.transactions ?: emptyList())) ?: MonthlyData(monthId = monthId, transactions = listOf(transaction))
            val newMap = current.monthlyData.toMutableMap().also { it[monthId] = newMonth }
            _state.value = current.copy(monthlyData = newMap)
            // persist changes
        }
    }

    // TODO: implement updateTransaction, deleteTransaction, and other store functions mirroring the web app behavior
}
