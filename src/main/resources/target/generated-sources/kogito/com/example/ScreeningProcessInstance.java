package com.example;

import com.example.ScreeningModel;

public class ScreeningProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ScreeningModel> {

    public ScreeningProcessInstance(com.example.ScreeningProcess process, ScreeningModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ScreeningProcessInstance(com.example.ScreeningProcess process, ScreeningModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ScreeningProcessInstance(com.example.ScreeningProcess process, ScreeningModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ScreeningProcessInstance(com.example.ScreeningProcess process, ScreeningModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ScreeningProcessInstance(com.example.ScreeningProcess process, ScreeningModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ScreeningModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ScreeningModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
