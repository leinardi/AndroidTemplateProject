/*
 * Copyright 2022 Roberto Leinardi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leinardi.forlago.library.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.leinardi.forlago.library.ui.theme.ForlagoTheme

@Composable
fun TopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    onNavigateUp: (() -> Unit)? = null,
    titleCentered: Boolean = false,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    actions: @Composable RowScope.() -> Unit = {},
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(MaterialTheme.colors.surface)
    Box {
        androidx.compose.material.TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.primary,
            title = {
                if (!titleCentered) {
                    Column {
                        Text(
                            text = title,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2,
                        )
                        if (!subtitle.isNullOrEmpty()) {
                            Text(
                                text = subtitle,
                                modifier = Modifier.alpha(ContentAlpha.medium),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2,
                                style = MaterialTheme.typography.subtitle1,
                            )
                        }
                    }
                }
            },
            modifier = modifier,
            navigationIcon = onNavigateUp?.let {
                {
                    IconButton(
                        onClick = it,
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                }
            },
            actions = actions,
            elevation = elevation,
        )
        if (titleCentered) {
            ProvideTextStyle(value = MaterialTheme.typography.h5) {
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.high,
                ) {
                    Text(
                        text = title,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarWithNavigationIcon() {
    ForlagoTheme {
        TopAppBar(
            title = "Page title",
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarWithSubtitle() {
    ForlagoTheme {
        TopAppBar(
            title = "Page title",
            subtitle = "Page subtitle",
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarWithAction() {
    ForlagoTheme {
        TopAppBar(
            title = "Page title",
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Share, contentDescription = "")
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarWithNavigationIconAndAction() {
    ForlagoTheme {
        TopAppBar(
            title = "Page title",
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Share, contentDescription = "")
                }
            },
            onNavigateUp = { },
        )
    }
}
