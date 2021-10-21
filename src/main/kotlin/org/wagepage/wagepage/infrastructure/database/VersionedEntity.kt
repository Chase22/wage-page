package org.wagepage.wagepage.infrastructure.database

import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class VersionedEntity : BaseEntity() {
    @field:Version
    @field:Column(name = "version")
    var version: Long = 0
}