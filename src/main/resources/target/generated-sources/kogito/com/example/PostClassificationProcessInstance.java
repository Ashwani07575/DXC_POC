package com.example;

import com.example.PostClassificationModel;

public class PostClassificationProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<PostClassificationModel> {

    public PostClassificationProcessInstance(com.example.PostClassificationProcess process, PostClassificationModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public PostClassificationProcessInstance(com.example.PostClassificationProcess process, PostClassificationModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public PostClassificationProcessInstance(com.example.PostClassificationProcess process, PostClassificationModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public PostClassificationProcessInstance(com.example.PostClassificationProcess process, PostClassificationModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public PostClassificationProcessInstance(com.example.PostClassificationProcess process, PostClassificationModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(PostClassificationModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(PostClassificationModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
