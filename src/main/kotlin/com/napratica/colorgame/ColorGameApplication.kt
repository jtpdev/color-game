package com.napratica.colorgame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ColorGameApplication

fun main(args: Array<String>) {
	runApplication<ColorGameApplication>(*args)
}
