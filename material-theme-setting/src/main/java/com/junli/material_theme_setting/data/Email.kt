package com.junli.material_theme_setting.data

data class Email(
    val id: Long,
    val sender: com.junli.material_theme_setting.data.Account,
    val recipients: List<com.junli.material_theme_setting.data.Account> = emptyList(),
    val subject: String,
    val body: String,
    val attachments: List<EmailAttachment> = emptyList(),
    var isImportant: Boolean = false,
    var isStarred: Boolean = false,
    var mailbox: MailboxType = MailboxType.INBOX,
    val createdAt: String,
    val threads: List<Email> = emptyList()
)

enum class MailboxType {
    INBOX,
    DRAFTS,
    SENT,
    SPAM,
    TRASH
}

class EmailAttachment(
    val resId: Int,
    val contentDesc: String
)
