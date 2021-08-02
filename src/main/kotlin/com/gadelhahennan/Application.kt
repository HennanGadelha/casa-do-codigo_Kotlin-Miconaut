package com.gadelhahennan

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.gadelhahennan")
		.start()
}

