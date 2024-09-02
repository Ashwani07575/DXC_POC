package com.example;

import com.example.ClassificationModel;

public class ClassificationProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ClassificationModel> {

    public ClassificationProcessInstance(com.example.ClassificationProcess process, ClassificationModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ClassificationProcessInstance(com.example.ClassificationProcess process, ClassificationModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ClassificationProcessInstance(com.example.ClassificationProcess process, ClassificationModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ClassificationProcessInstance(com.example.ClassificationProcess process, ClassificationModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ClassificationProcessInstance(com.example.ClassificationProcess process, ClassificationModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ClassificationModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ClassificationModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
