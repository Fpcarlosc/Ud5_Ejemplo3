package com.example.ud5_ejemplo3.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ud5_ejemplo3.R
import com.example.ud5_ejemplo3.modelo.AppUIState

@Composable
fun SegundaPantalla(
    appUIState: AppUIState,
    onBotonAtrasPulsado: () -> Unit,
    onBotonInicioPulsado: () -> Unit,
    modifier: Modifier = Modifier
){
    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.pantalla2),
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.weight(1F))

        Text(
            text = "${stringResource(id = R.string.numero_1)}: ${appUIState.numero1}\n${stringResource(id = R.string.numero_2)}: ${appUIState.numero2}",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.weight(1F))

        Row {
            Button(
                onClick = onBotonAtrasPulsado,
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.atras)
                )
            }
            Button(
                onClick = onBotonInicioPulsado,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.inicio)
                )
            }
        }
    }
}