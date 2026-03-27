package com.suradi.renunganharianapi.controller

import com.suradi.renunganharianapi.entity.Devotional
import com.suradi.renunganharianapi.repository.DevotionalRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneId

@RestController
@RequestMapping("/api/devotionals")
class DevotionalController(
    private val devotionalRepository: DevotionalRepository
) {

    @GetMapping
    fun getAllDevotionals(): List<Devotional> {
        return devotionalRepository.findAll()
    }

    @GetMapping("/previous")
    fun getPreviousDevotionals(): List<Devotional> {
        val today = java.time.LocalDate.now(ZoneId.of("Asia/Jakarta"))
        return devotionalRepository.findPreviousDevotionals(
            today.monthValue,
            today.dayOfMonth
        )
    }
}






