package com.suradi.renunganharianapi.repository

import com.suradi.renunganharianapi.entity.Devotional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DevotionalRepository : JpaRepository<Devotional, Int> {

    @Query("""
        SELECT d FROM Devotional d
        WHERE d.month < :currentMonth
           OR (d.month = :currentMonth AND d.day < :currentDay)
        ORDER BY d.month DESC, d.day DESC
    """)
    fun findPreviousDevotionals(
        @Param("currentMonth") currentMonth: Int,
        @Param("currentDay") currentDay: Int
    ): List<Devotional>
}