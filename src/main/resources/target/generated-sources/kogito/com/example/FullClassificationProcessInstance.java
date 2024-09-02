package com.example;

import com.example.FullClassificationModel;

public class FullClassificationProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<FullClassificationModel> {

    public FullClassificationProcessInstance(com.example.FullClassificationProcess process, FullClassificationModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public FullClassificationProcessInstance(com.example.FullClassificationProcess process, FullClassificationModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public FullClassificationProcessInstance(com.example.FullClassificationProcess process, FullClassificationModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public FullClassificationProcessInstance(com.example.FullClassificationProcess process, FullClassificationModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public FullClassificationProcessInstance(com.example.FullClassificationProcess process, FullClassificationModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(FullClassificationModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(FullClassificationModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
