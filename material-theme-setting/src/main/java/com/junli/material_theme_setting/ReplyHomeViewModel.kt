package com.junli.material_theme_setting

import androidx.lifecycle.ViewModel
import com.junli.material_theme_setting.data.LocalEmailsDataProvider
import com.junli.material_theme_setting.data.ReplyHomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReplyHomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ReplyHomeUIState(loading = true))
    val uiState: StateFlow<ReplyHomeUIState> = _uiState

    init {
        initEmailList()
    }

    private fun initEmailList() {
        val emails = LocalEmailsDataProvider.allEmails
        _uiState.value = ReplyHomeUIState(
            emails = emails, selectedEmail = emails.first()
        )
    }

    fun setSelectEmail(emailId: Long) {
        val email = uiState.value.emails.find { it.id == emailId }
        _uiState.value = _uiState.value.copy(
            selectedEmail = email,
            isDetailOnlyOpen = true
        )
    }

    fun closeDetailsScreen() {
        _uiState.value = _uiState.value.copy(
            isDetailOnlyOpen = false,
            selectedEmail = _uiState.value.emails.first()
        )
    }

}
