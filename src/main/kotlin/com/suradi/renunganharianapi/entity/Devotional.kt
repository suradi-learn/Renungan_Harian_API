package com.suradi.renunganharianapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "devotionals")
data class Devotional(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(nullable = false)
    val title: String = "",

    @Column(name = "verse_reference", nullable = false)
    val verseReference: String = "",

    @Column(name = "verse_text", nullable = false, columnDefinition = "TEXT")
    val verseText: String = "",

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    val content: String = "",

    @Column(columnDefinition = "VARCHAR(255)")
    val closing: String? = null,

    @Column(nullable = false)
    val month: Int = 0,

    @Column(nullable = false)
    val day: Int = 0
)