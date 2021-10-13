package org.wagepage.wagepage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WagepageApplication

fun main(args: Array<String>) {
    runApplication<WagepageApplication>(*args)
}
