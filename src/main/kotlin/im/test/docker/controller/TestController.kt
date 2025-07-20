package im.test.docker.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController(
    @Value("\${custom.env}") val env: String,
    private val jdbcTemplate: JdbcTemplate
) {

    @GetMapping("/test")
    fun test(): String {
        val counts = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tenant", Long::class.java)
        return "Current Profile: $env / $counts"
    }
}