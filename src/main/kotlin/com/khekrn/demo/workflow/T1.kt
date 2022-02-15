package com.khekrn.demo.workflow

import com.cs.beam.engine.workflow.context.TaskContext
import com.cs.beam.engine.workflow.context.WorkflowContext
import com.cs.beam.engine.workflow.task.ServiceTask
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component("T1")
class T1 : ServiceTask{

    private val logger = LoggerFactory.getLogger(T1::class.java)

    override suspend fun execute(workflowContext: WorkflowContext, taskContext: TaskContext) {
        logger.info("In T1: execute")
        delay(1000)
        logger.info("Workflow and Task = ${workflowContext.getProcessId()}, ${taskContext.getProcessId()}")

        workflowContext.setVariable("T1Status", "success")

        taskContext.appendLog("dummy", "post", "request", "response")
        taskContext.appendLog("dummy", "post", "request", "response")
        logger.info("Return from T1: execute")
    }
}