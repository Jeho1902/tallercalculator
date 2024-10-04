package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CalculatorUI()
            }
        }
    }
}

@Composable
fun CalculatorUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pantalla de la calculadora
        Text(
            text = "0",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.End
        )

        // Botones
        val buttonRows = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", "C", "=", "+")
        )

        // Creacion de las filas de botones
        buttonRows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { symbol ->
                    CalculatorButton(symbol = symbol)
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(symbol: String) {
    Button(
        onClick = { /* Sin funcionalidad */ },
        modifier = Modifier
            .size(72.dp)
            .padding(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = when {
                symbol.matches(Regex("[0-9]")) -> MaterialTheme.colorScheme.primary
                symbol == "C" -> MaterialTheme.colorScheme.error
                else -> MaterialTheme.colorScheme.secondary
            }
        )
    ) {
        Text(
            text = symbol,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        CalculatorUI()
    }
}