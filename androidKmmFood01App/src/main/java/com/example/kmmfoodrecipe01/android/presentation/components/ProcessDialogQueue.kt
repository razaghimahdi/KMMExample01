package com.example.kmmfoodrecipe01.android.presentation.components

import androidx.compose.runtime.Composable
import com.example.kmmfoodrecipe01.domain.model.GenericMessageInfo
import com.example.kmmfoodrecipe01.domain.util.Queue
import com.example.kmmfoodrecipe01.android.presentation.components.GenericDialog

@Composable
fun ProcessDialogQueue(
    dialogQueue: Queue<GenericMessageInfo>?,
    onRemoveHeadMessageFromQueue: () -> Unit,
) {
    dialogQueue?.peek()?.let { dialogInfo ->
        GenericDialog(
            onDismiss = dialogInfo.onDismiss,
            title = dialogInfo.title,
            description = dialogInfo.description,
            positiveAction = dialogInfo.positiveAction,
            negativeAction = dialogInfo.negativeAction,
            onRemoveHeadFromQueue = onRemoveHeadMessageFromQueue
        )
    }
}