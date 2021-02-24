package org.example.para.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class ParaExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(ParaException::class)
    fun handleParaException(e: ParaException) : ApiResponse {
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleExcpetion(e: Exception): ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error("알 수 없는 오류가 발생했습니다")
    }
}