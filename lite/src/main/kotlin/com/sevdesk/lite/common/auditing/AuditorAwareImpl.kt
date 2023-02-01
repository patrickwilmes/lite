package com.sevdesk.lite.common.auditing

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

class AuditorAwareImpl : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> =
        Optional.of(SecurityContextHolder.getContext().authentication.name)

}
