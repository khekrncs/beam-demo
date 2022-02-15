package com.khekrn.demo.workflow

import com.cs.beam.engine.workflow.executor.service.WorkflowExecutorService
import com.cs.beam.engine.workflow.runtime.config.BeamEngineConfig
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Component
class WorkflowBeamConfiguration(private val workflowExecutorService: WorkflowExecutorService) {


    @PostConstruct
    fun initialize() {
        val resourceSet = setOf<Resource>(
            ClassPathResource("workflows/sample.json"),
            ClassPathResource("workflows/withconditions.json")
        )
        val beamEngineConfig = BeamEngineConfig(resourceSet, 1)
        workflowExecutorService.initiate(beamEngineConfig)
    }

    @PreDestroy
    fun shutDown() {
        workflowExecutorService.shutDown()
    }
}