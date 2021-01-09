package com.enstrurental.server.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.format.datetime.DateFormatter
import org.springframework.format.datetime.DateFormatterRegistrar
import java.time.format.DateTimeFormatter
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar
import org.springframework.format.support.DefaultFormattingConversionService
import org.springframework.format.support.FormattingConversionService


@Configuration
class DateTimeConfig {
    @Bean
    fun mvcConversionService(): FormattingConversionService {
        val conversionService = DefaultFormattingConversionService(false)
        val dateTimeRegistrar = DateTimeFormatterRegistrar()
        dateTimeRegistrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        dateTimeRegistrar.registerFormatters(conversionService)
        val dateRegistrar = DateFormatterRegistrar()
        dateRegistrar.setFormatter(DateFormatter("dd.MM.yyyy"))
        dateRegistrar.registerFormatters(conversionService)
        return conversionService
    }
}