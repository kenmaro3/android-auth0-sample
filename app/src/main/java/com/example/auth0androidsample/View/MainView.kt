package com.example.auth0androidsample.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth0androidsample.R
import com.example.auth0androidsample.View.Component.UserInfoRow
import com.example.auth0androidsample.View.Component.UserPicture
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.activity.viewModels
import com.example.auth0androidsample.ViewModel.MainViewModel

@Composable
fun MainView(viewModel: MainViewModel) {


    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val title = if (viewModel.userIsAuthenticated) {
            stringResource(R.string.logged_in_title)
        } else {
            if (viewModel.appJustLaunched) {
                stringResource(R.string.initial_title)
            } else {
                stringResource(R.string.logged_out_title)
            }
        }
        Title(
            text = title
        )

        if (viewModel.userIsAuthenticated) {

            UserInfoRow(
                label = stringResource(R.string.name_label),
                value = viewModel.user.name,
            )
            UserInfoRow(
                label = stringResource(R.string.email_label),
                value = viewModel.user.email,
            )
            UserPicture(
                url = viewModel.user.picture,
                description = viewModel.user.name,
            )
        }
    }

    var buttonText: String
    var onClickAction: () -> Unit
    if (viewModel.userIsAuthenticated) {
        buttonText = stringResource(R.string.log_out_button)
        onClickAction = { viewModel.logout() }
    } else {
        buttonText = stringResource(R.string.log_in_button)
        onClickAction = { viewModel.login() }
    }

    LogButton(
        text = buttonText,
        onClick = onClickAction,
    )
}

@Composable
fun Title(
    text: String,
)
{
    Text(
        text = text,
        style = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        )
    )
}

@Composable
fun LogButton(  // 1
    text: String,
    onClick: () -> Unit,
) {
    Column(  // 2
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(  // 3
            onClick = { onClick() },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
        ) {
            Text(  // 4
                text = text,
                fontSize = 20.sp,
            )
        }
    }
}