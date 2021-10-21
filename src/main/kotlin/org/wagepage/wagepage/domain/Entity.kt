package org.wagepage.wagepage.domain

import java.util.UUID

typealias Id = UUID

interface Entity {
    val id: Id
}