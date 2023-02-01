package com.sevdesk.lite.common.auditing

import java.time.LocalDateTime
import java.time.OffsetDateTime

interface Auditable {
    var createdBy: String
    var lastModifiedAt: LocalDateTime
}
