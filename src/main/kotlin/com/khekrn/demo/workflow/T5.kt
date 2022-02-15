package com.khekrn.demo.workflow

import com.cs.beam.engine.workflow.context.TaskContext
import com.cs.beam.engine.workflow.context.WorkflowContext
import com.cs.beam.engine.workflow.task.ServiceTask
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component("T5")
class T5 : ServiceTask {

    private val logger = LoggerFactory.getLogger(T5::class.java)

    override suspend fun execute(workflowContext: WorkflowContext, taskContext: TaskContext) {
        logger.info("In T5: execute")
        delay(1000)
        logger.info("Workflow and Task = ${workflowContext.getProcessId()}, ${taskContext.getProcessId()}")

        taskContext.appendLog("dummy", "post", "request", "response")
        taskContext.appendLog("dummy", "post", "request", "response")
        workflowContext.setVariable("T5Status", "success")
        logger.info("Return from T5: execute")
    }
}