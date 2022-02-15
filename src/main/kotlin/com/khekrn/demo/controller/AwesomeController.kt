package com.khekrn.demo.controller

import com.cs.beam.engine.workflow.runtime.impl.BeamRuntimeService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1")
class AwesomeController(private val runtime: BeamRuntimeService) {

    private val logger = LoggerFactory.getLogger(AwesomeController::class.java)

    @PostMapping("/process")
    suspend fun process(@RequestBody data: String): ResponseEntity<String> {
        logger.info("In process")

        val workflowResponse = runtime.startWorkflowInstance("ConditionWorkflow")

        logger.info("Return from process")
        return ResponseEntity.ok(workflowResponse.response)
    }
}