package com.example;

import com.example.PostClassificationModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("postClassification")
@io.quarkus.runtime.Startup()
public class PostClassificationProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.PostClassificationModel> {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("classification")
    org.kie.kogito.process.Process<ClassificationModel> processclassification;

    @jakarta.inject.Inject()
    public PostClassificationProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        super(app, java.util.Arrays.asList(), correlations);
        activate();
    }

    public PostClassificationProcess() {
    }

    @Override()
    public com.example.PostClassificationProcessInstance createInstance(com.example.PostClassificationModel value) {
        return new com.example.PostClassificationProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.PostClassificationProcessInstance createInstance(java.lang.String businessKey, com.example.PostClassificationModel value) {
        return new com.example.PostClassificationProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.PostClassificationProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.PostClassificationModel value) {
        return new com.example.PostClassificationProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.PostClassificationModel createModel() {
        return new com.example.PostClassificationModel();
    }

    public com.example.PostClassificationProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.PostClassificationModel) value);
    }

    public com.example.PostClassificationProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.PostClassificationModel) value);
    }

    public com.example.PostClassificationProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.PostClassificationProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.PostClassificationProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.PostClassificationProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("postClassification", true);
        factory.variable("person", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("person", "person", "ItemSubjectRef", "_personItem"));
        factory.variable("reclass", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("reclass", "reclass", "ItemSubjectRef", "_reclassItem"));
        factory.variable("name", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("name", "name", "ItemSubjectRef", "_nameItem"));
        factory.variable("p_type", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("p_type", "p_type", "ItemSubjectRef", "_p_typeItem"));
        factory.name("Post Classification");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_61DC7D6E-B6A8-459C-820F-622A503E1ECB"));
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.name("Reclassification-process");
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.processId("classification");
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.processName("");
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.waitForCompletion(true);
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.independent(false);
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<ClassificationModel>() {

            public ClassificationModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                com.example.ClassificationModel model = new com.example.ClassificationModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<ClassificationModel> createInstance(ClassificationModel model) {
                return (org.kie.kogito.process.ProcessInstance<ClassificationModel>) app.get(org.kie.kogito.process.Processes.class).processById("classification").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, ClassificationModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                outputs.put("p_type", model.getP_type());
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("person", "person", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_61DC7D6E-B6A8-459C-820F-622A503E1ECB_personInputX", "person", "Object", null), null, null));
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_61DC7D6E-B6A8-459C-820F-622A503E1ECB_nameInputX", "name", "String", null), null, null));
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_61DC7D6E-B6A8-459C-820F-622A503E1ECB_p_typeOutputX", "p_type", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("p_type", "p_type", "java.lang.String", null), null, null));
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.metaData("UniqueId", "_61DC7D6E-B6A8-459C-820F-622A503E1ECB");
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.metaData("elementname", "Reclassification-process");
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.metaData("x", 900);
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.metaData("width", 153);
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.metaData("y", 156);
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.metaData("height", 101);
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.done();
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.onActionScript("onEntry", "java", "System.out.println(\"Entering Re-Classification Process ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Entering Re-Classification Process ...");
        });
        subProcessNode_61DC7D6E_B6A8_459C_820F_622A503E1ECB.onActionScript("onExit", "java", "System.out.println(\"Exit Re-Classification Process ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Exit Re-Classification Process ...");
        });
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3AEBB215-56C2-4F4D-AFF8-4988E059936B"));
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.name("End");
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.terminate(false);
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.metaData("UniqueId", "_3AEBB215-56C2-4F4D-AFF8-4988E059936B");
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.metaData("x", 1192);
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.metaData("width", 56);
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.metaData("y", 539);
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.metaData("height", 56);
        endNode_3AEBB215_56C2_4F4D_AFF8_4988E059936B.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5CD5DEB7-7348-426D-9D4C-6621062C0ACB"));
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.name("Reclass Failed");
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("UniqueId", "_5CD5DEB7-7348-426D-9D4C-6621062C0ACB");
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("elementname", "Reclass Failed");
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("NodeType", "ScriptTask");
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("x", 900);
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("width", 154);
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("y", 516);
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.metaData("height", 102);
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.action(kcontext -> {
        });
        actionNode_5CD5DEB7_7348_426D_9D4C_6621062C0ACB.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_13D6A0BD-35BB-4C7D-9AEC-29CE6FB0324F"));
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.name("Exclusive");
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.type(2);
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("UniqueId", "_13D6A0BD-35BB-4C7D-9AEC-29CE6FB0324F");
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("elementname", "Exclusive");
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("x", 723);
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("width", 56);
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("y", 359);
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("Default", "_6A10A228-B14A-4A23-974F-77243D94010C");
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.metaData("height", 56);
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_61DC7D6E-B6A8-459C-820F-622A503E1ECB"), "_887B9EF8-4B01-472A-AB79-39986E5A4280", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean reclass = (java.lang.Boolean) kcontext.getVariable("reclass");
            return reclass;
        }, 0, false);
        splitNode_13D6A0BD_35BB_4C7D_9AEC_29CE6FB0324F.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5EBAE1A2-5783-45E7-AACF-1BA1F9E444BA"));
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.name("End");
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.terminate(false);
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.metaData("UniqueId", "_5EBAE1A2-5783-45E7-AACF-1BA1F9E444BA");
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.metaData("x", 1192);
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.metaData("width", 56);
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.metaData("y", 179);
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.metaData("height", 56);
        endNode_5EBAE1A2_5783_45E7_AACF_1BA1F9E444BA.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_FB256D55-6B1F-4F18-8C9C-30F86A28A918"));
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.name("Reclassification checking");
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("UniqueId", "_FB256D55-6B1F-4F18-8C9C-30F86A28A918");
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("elementname", "Reclassification checking");
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("NodeType", "ScriptTask");
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("x", 489);
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("width", 154);
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("y", 336);
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.metaData("height", 102);
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.action(kcontext -> {
            System.out.println("Entering Task of Post Classification Process ...");
        });
        actionNode_FB256D55_6B1F_4F18_8C9C_30F86A28A918.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B672D939-0AAE-4DC5-9C43-5748D34DF974"));
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.name("Start");
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.interrupting(true);
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.metaData("UniqueId", "_B672D939-0AAE-4DC5-9C43-5748D34DF974");
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.metaData("x", 353);
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.metaData("width", 56);
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.metaData("y", 359);
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.metaData("height", 56);
        startNode_B672D939_0AAE_4DC5_9C43_5748D34DF974.done();
        org.jbpm.ruleflow.core.factory.EventSubProcessNodeFactory<?> eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A = factory.eventSubProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_9F8BF59B-8AA2-4F77-A673-6DF6F6C8BC6A"));
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.name("Error Handling");
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.metaData("UniqueId", "_9F8BF59B-8AA2-4F77-A673-6DF6F6C8BC6A");
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.metaData("elementname", "Error Handling");
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.metaData("x", 510);
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.metaData("width", 653);
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.metaData("y", 684);
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.metaData("height", 253);
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.keepActive(true);
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.event("Error-jang.lang.Throwable");
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.autoComplete(true);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF = eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1ECEB18C-D3C0-4C70-9463-D7D7DD2321FF"));
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.name("End");
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.terminate(false);
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.metaData("UniqueId", "_1ECEB18C-D3C0-4C70-9463-D7D7DD2321FF");
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.metaData("x", 427);
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.metaData("width", 56);
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.metaData("y", 101);
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.metaData("height", 56);
        endNode_1ECEB18C_D3C0_4C70_9463_D7D7DD2321FF.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41 = eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_99223AE7-124C-49FF-BCDE-76AF131CDA41"));
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.name("Task");
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("UniqueId", "_99223AE7-124C-49FF-BCDE-76AF131CDA41");
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("elementname", "Task");
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("NodeType", "ScriptTask");
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("x", 193);
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("width", 154);
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("y", 78);
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.metaData("height", 102);
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.action(kcontext -> {
            System.out.println("Error Handling (Post-Classification) ...");
        });
        actionNode_99223AE7_124C_49FF_BCDE_76AF131CDA41.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7 = eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A41C04A1-D262-4CF4-82F6-F9954CE25AA7"));
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.name("Start");
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.interrupting(true);
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("FaultCode", "jang.lang.Throwable");
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("UniqueId", "_A41C04A1-D262-4CF4-82F6-F9954CE25AA7");
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("TriggerType", "Signal");
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("x", 57);
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("width", 56);
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("y", 101);
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("TriggerRef", "jang.lang.Throwable");
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("MessageType", "jang.lang.Throwable");
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.metaData("height", 56);
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.done();
        startNode_A41C04A1_D262_4CF4_82F6_F9954CE25AA7.trigger("jang.lang.Throwable", java.util.Arrays.asList());
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_99223AE7-124C-49FF-BCDE-76AF131CDA41"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1ECEB18C-D3C0-4C70-9463-D7D7DD2321FF"), "_3D820822-F24B-4451-9809-C73E684657DB");
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A41C04A1-D262-4CF4-82F6-F9954CE25AA7"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_99223AE7-124C-49FF-BCDE-76AF131CDA41"), "_472BB794-99CE-41B2-8E2E-2A315587EF9E");
        eventSubProcessNode_9F8BF59B_8AA2_4F77_A673_6DF6F6C8BC6A.done();
        factory.errorExceptionHandler("Error-jang.lang.Throwable", "jang.lang.Throwable", null);
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_13D6A0BD-35BB-4C7D-9AEC-29CE6FB0324F"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_61DC7D6E-B6A8-459C-820F-622A503E1ECB"), "_887B9EF8-4B01-472A-AB79-39986E5A4280");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5CD5DEB7-7348-426D-9D4C-6621062C0ACB"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3AEBB215-56C2-4F4D-AFF8-4988E059936B"), "_A11735FF-1BE0-424C-81B5-DFD5A5EDBF5B");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_13D6A0BD-35BB-4C7D-9AEC-29CE6FB0324F"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5CD5DEB7-7348-426D-9D4C-6621062C0ACB"), "_6A10A228-B14A-4A23-974F-77243D94010C");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_FB256D55-6B1F-4F18-8C9C-30F86A28A918"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_13D6A0BD-35BB-4C7D-9AEC-29CE6FB0324F"), "_7CFB6EC1-4E5F-483B-BEC1-9350C9837CEC");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_61DC7D6E-B6A8-459C-820F-622A503E1ECB"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5EBAE1A2-5783-45E7-AACF-1BA1F9E444BA"), "_E8CE366A-17E0-4A54-BCED-F8E1DBD1E527");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B672D939-0AAE-4DC5-9C43-5748D34DF974"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_FB256D55-6B1F-4F18-8C9C-30F86A28A918"), "_7F72EEA8-5159-4FCB-A5E8-E590DA86C33A");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("classification", completionEventListener);
    }
}
