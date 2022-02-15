package com.khekrn.demo.workflow

import com.cs.beam.engine.workflow.context.TaskContext
import com.cs.beam.engine.workflow.context.WorkflowContext
import com.cs.beam.engine.workflow.task.ServiceTask
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component("T3")
class T3 : ServiceTask{

    private val logger = LoggerFactory.getLogger(T3::class.java)

    private val data = "{\n" +
            "\t\"response\": \"Workflow is success\"\n" +
            "}"

    override suspend fun execute(workflowContext: WorkflowContext, taskContext: TaskContext) {
        logger.info("In T3: execute")
        delay(200)
        logger.info("Workflow and Task = ${workflowContext.getProcessId()}, ${taskContext.getProcessId()}")

        taskContext.appendLog("dummy", "post", "request", "response")
        taskContext.appendLog("dummy", "post", "request", "response")
        workflowContext.setVariable("T3Status", "success")
        workflowContext.setVariable("output", data)
        logger.info("Return from T3: execute")
    }
}