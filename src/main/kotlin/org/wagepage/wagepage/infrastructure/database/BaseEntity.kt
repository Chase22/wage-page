package org.wagepage.wagepage.infrastructure.database

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@MappedSuperclass
abstract class BaseEntity {
    @field:CreatedDate
    @field:Column(columnDefinition = "timestamptz")
    var createdAt: ZonedDateTime? = null

    @field:LastModifiedDate
    @field:Column(columnDefinition = "timestamptz")
    var lastModifiedAt: ZonedDateTime? = null

    @PrePersist
    fun prePersist() {
        val now = ZonedDateTime.now()
        when (createdAt) {
            null -> createdAt = now
        }
        lastModifiedAt = now
    }

    @PreUpdate
    fun preUpdate() {
        lastModifiedAt = ZonedDateTime.now()
    }
}
