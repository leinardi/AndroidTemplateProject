/*
 * Copyright 2024 Roberto Leinardi.
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImagePainter.State
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageScope
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade
import com.leinardi.forlago.library.ui.component.placeholder.placeholder

@Suppress("ModifierReused", "ModifierNotUsedAtRoot")
@Composable
fun CoilImage(
    url: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    crossfade: Boolean = true,
    loading: @Composable (SubcomposeAsyncImageScope.(State.Loading) -> Unit)? = {
        Box(
            modifier = Modifier
                .matchParentSize()
                .placeholder(true),
        ) {}
    },
    error: @Composable (SubcomposeAsyncImageScope.(State.Error) -> Unit)? = null,
    onSuccess: ((State.Success) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    allowHardwareBitmaps: Boolean = true,
    placeholder: Boolean = false,
) {
    if (placeholder) {
        Box(modifier = modifier.placeholder(true)) {}
    } else {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .allowHardware(allowHardwareBitmaps)
                .data(url)
                .crossfade(crossfade)
                .build(),
            loading = loading,
            error = error,
            onSuccess = onSuccess,
            contentDescription = contentDescription,
            modifier = modifier,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
        )
    }
}
