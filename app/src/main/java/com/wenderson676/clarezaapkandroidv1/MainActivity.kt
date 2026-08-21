package com.wenderson676.clarezaapkandroidv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wenderson676.clarezaapkandroidv1.ui.theme.ClarezaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClarezaTheme {
                val vm: MainViewModel = viewModel()
                AppContent(vm)
            }
        }
    }
}

@Composable
fun AppContent(vm: MainViewModel) {
    var currentTab by remember { mutableStateOf("dashboard") }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Clareza") }) },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(selected = currentTab=="dashboard", onClick = { currentTab = "dashboard" }, icon = { Icon(Icons.Default.Home, contentDescription = null) }, label = { Text("Início") })
                BottomNavigationItem(selected = currentTab=="transactions", onClick = { currentTab = "transactions" }, icon = { Icon(Icons.Default.List, contentDescription = null) }, label = { Text("Extrato") })
                BottomNavigationItem(selected = currentTab=="comparison", onClick = { currentTab = "comparison" }, icon = { Icon(Icons.Default.BarChart, contentDescription = null) }, label = { Text("Análise") })
            }
        }
    ) { innerPadding ->
        when (currentTab) {
            "dashboard" -> DashboardScreen(vm)
            "transactions" -> TransactionsScreen(vm)
            "comparison" -> ComparisonScreen(vm)
        }
    }
}

@Composable
fun DashboardScreen(vm: MainViewModel) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("Dashboard - tela inicial (a portar)")
    }
}

@Composable
fun TransactionsScreen(vm: MainViewModel) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("Extrato - tela de transações (a portar)")
    }
}

@Composable
fun ComparisonScreen(vm: MainViewModel) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("Análise - comparação (a portar)")
    }
}
