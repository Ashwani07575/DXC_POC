package com.example;

import com.example.ScreeningModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("screening")
@io.quarkus.runtime.Startup()
public class ScreeningProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.ScreeningModel> {

    public ScreeningProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler(), new org.kie.kogito.handlers.ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler());
    }

    @jakarta.inject.Inject()
    public ScreeningProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler externalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler, org.kie.kogito.handlers.ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler externalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler) {
        super(app, java.util.Arrays.asList(externalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler, externalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler), correlations);
        activate();
    }

    public ScreeningProcess() {
    }

    @Override()
    public com.example.ScreeningProcessInstance createInstance(com.example.ScreeningModel value) {
        return new com.example.ScreeningProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.ScreeningProcessInstance createInstance(java.lang.String businessKey, com.example.ScreeningModel value) {
        return new com.example.ScreeningProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.ScreeningProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.ScreeningModel value) {
        return new com.example.ScreeningProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.ScreeningModel createModel() {
        return new com.example.ScreeningModel();
    }

    public com.example.ScreeningProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.ScreeningModel) value);
    }

    public com.example.ScreeningProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.ScreeningModel) value);
    }

    public com.example.ScreeningProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ScreeningProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.ScreeningProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ScreeningProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("screening", true);
        factory.variable("resultS1", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("resultS1", "resultS1", "ItemSubjectRef", "_resultS1Item"));
        factory.variable("resultS2", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("resultS2", "resultS2", "ItemSubjectRef", "_resultS2Item"));
        factory.variable("person", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("person", "person", "ItemSubjectRef", "_personItem"));
        factory.variable("overall", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("overall", "overall", "ItemSubjectRef", "_overallItem"));
        factory.variable("src", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("src", "src", "ItemSubjectRef", "_srcItem"));
        factory.name("screening");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AC9F64F3-1204-4BB0-B569-C7B51561D74A"));
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.name("Transforming Data");
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("UniqueId", "_AC9F64F3-1204-4BB0-B569-C7B51561D74A");
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("elementname", "Transforming Data");
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("NodeType", "ScriptTask");
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("x", 663);
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("width", 154);
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("y", 382);
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.metaData("height", 102);
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.action(kcontext -> {
            java.lang.String src = (java.lang.String) kcontext.getVariable("src");
            System.out.println("Entering Transforming Data...");
            kcontext.setVariable("src", "S1");
        });
        actionNode_AC9F64F3_1204_4BB0_B569_C7B51561D74A.done();
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5 = factory.joinNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1ECAA328-3EAA-485B-B159-12DF6AA24AF5"));
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.name("After API call");
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.type(1);
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.metaData("UniqueId", "_1ECAA328-3EAA-485B-B159-12DF6AA24AF5");
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.metaData("elementname", "After API call");
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.metaData("x", 533);
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.metaData("width", 56);
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.metaData("y", 405);
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.metaData("height", 56);
        joinNode_1ECAA328_3EAA_485B_B159_12DF6AA24AF5.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7 = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D494041A-E608-498F-AFAE-0EB082E7FEB7"));
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.name("REST Service Call S2");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workName("com.example.travels.services.ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workParameter("Interface", "com.example.travels.services.ExternalApiService");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workParameter("NodeName", "REST Service Call S2");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workParameter("Operation", "fetchS2Data");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workParameter("implementation", "Java");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workParameter("interfaceImplementationRef", "com.example.travels.services.ExternalApiService");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.workParameter("operationImplementationRef", "fetchS2Data");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_D494041A-E608-498F-AFAE-0EB082E7FEB7_resultS2OutputX", "resultS2", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("resultS2", "resultS2", "java.lang.Object", null), null, null));
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.done();
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("UniqueId", "_D494041A-E608-498F-AFAE-0EB082E7FEB7");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("Implementation", "Java");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("elementname", "REST Service Call S2");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("Type", "Service Task");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("OperationRef", "_D494041A-E608-498F-AFAE-0EB082E7FEB7_ServiceOperation");
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("x", 289);
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("width", 154);
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("y", 473);
        workItemNode_D494041A_E608_498F_AFAE_0EB082E7FEB7.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348 = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_942FF689-8903-41A7-9D5E-B2FB76B19348"));
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.name("REST Service Call S1");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workName("com.example.travels.services.ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workParameter("Interface", "com.example.travels.services.ExternalApiService");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workParameter("NodeName", "REST Service Call S1");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workParameter("Operation", "fetchS1Data");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workParameter("implementation", "Java");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workParameter("interfaceImplementationRef", "com.example.travels.services.ExternalApiService");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.workParameter("operationImplementationRef", "fetchS1Data");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_942FF689-8903-41A7-9D5E-B2FB76B19348_resultS1OutputX", "resultS1", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("resultS1", "resultS1", "java.lang.Object", null), null, null));
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.done();
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("UniqueId", "_942FF689-8903-41A7-9D5E-B2FB76B19348");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("Implementation", "Java");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("elementname", "REST Service Call S1");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("Type", "Service Task");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("OperationRef", "_942FF689-8903-41A7-9D5E-B2FB76B19348_ServiceOperation");
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("x", 289);
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("width", 154);
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("y", 299);
        workItemNode_942FF689_8903_41A7_9D5E_B2FB76B19348.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1A0593B0-FF74-4BDC-916D-55E39E570B22"));
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.name("Before API call");
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.type(1);
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.metaData("UniqueId", "_1A0593B0-FF74-4BDC-916D-55E39E570B22");
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.metaData("elementname", "Before API call");
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.metaData("x", 153);
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.metaData("width", 56);
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.metaData("y", 405);
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.metaData("height", 56);
        splitNode_1A0593B0_FF74_4BDC_916D_55E39E570B22.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D9F28C5A-3447-4005-BBEE-BC46B9A8417D"));
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.name("End");
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.terminate(false);
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.metaData("UniqueId", "_D9F28C5A-3447-4005-BBEE-BC46B9A8417D");
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.metaData("x", 1420);
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.metaData("width", 56);
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.metaData("y", 215);
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.metaData("height", 56);
        endNode_D9F28C5A_3447_4005_BBEE_BC46B9A8417D.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF"));
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.name("Officer Feedback");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.workParameter("ActorId", "jdoe");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.workParameter("Comment", "Screening Feedback");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.workParameter("NodeName", "Officer Feedback");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.workParameter("Skippable", "false");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.workParameter("TaskName", "Officer_Feedback_Screening");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("cde2256a-8b1f-4941-a046-dbe6cebd4f03", "EXPRESSION (Officer_Feedback_Screening)", "java.lang.Object", "Officer_Feedback_Screening"), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("overall", "overall", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_OverallInputX", "Overall", "String", null), null, null));
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d56d91fc-f367-4fd7-a96b-031b6cc4da4d", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_CommentInputX", "Comment", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("50f165b7-3a65-4e68-b49d-af6d11756c8c", "EXPRESSION (Screening Feedback)", "java.lang.Object", "Screening Feedback"), new org.jbpm.workflow.core.impl.DataDefinition("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF_CommentInputX", "Comment", "Object", null))), null));
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.done();
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.metaData("UniqueId", "_8224575C-D745-4BE5-AAE4-80FD71B8D5CF");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.metaData("elementname", "Officer Feedback");
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.metaData("x", 1131);
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.metaData("width", 154);
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.metaData("y", 192);
        humanTaskNode_8224575C_D745_4BE5_AAE4_80FD71B8D5CF.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DFE551A0-7296-47BD-A1AF-696B1FACE3B6"));
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.name("End");
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.terminate(false);
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.metaData("UniqueId", "_DFE551A0-7296-47BD-A1AF-696B1FACE3B6");
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.metaData("x", 1420);
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.metaData("width", 56);
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.metaData("y", 405);
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.metaData("height", 56);
        endNode_DFE551A0_7296_47BD_A1AF_696B1FACE3B6.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053"));
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.name("Officer Feedback Not Matched");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.workParameter("ActorId", "jdoe");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.workParameter("NodeName", "Officer Feedback Not Matched");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.workParameter("Skippable", "false");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.workParameter("TaskName", "Officer_Feedback_Not_Matched_Screening");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("91fcae56-a86e-4085-ab7c-3c0f93f5bae2", "EXPRESSION (Officer_Feedback_Not_Matched_Screening)", "java.lang.Object", "Officer_Feedback_Not_Matched_Screening"), new org.jbpm.workflow.core.impl.DataDefinition("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053_outputInputX", "output", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("27650de4-9c78-4781-a89d-35d20cff0667", "EXPRESSION (Something went wrong, please re-run again. (Screening))", "java.lang.Object", "Something went wrong, please re-run again. (Screening)"), new org.jbpm.workflow.core.impl.DataDefinition("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053_outputInputX", "output", "String", null))), null));
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("a09135ea-83e6-4fb7-8cf7-d7b63c7b41d4", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.done();
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.metaData("UniqueId", "_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.metaData("elementname", "Officer Feedback Not Matched");
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.metaData("x", 1131);
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.metaData("width", 154);
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.metaData("y", 382);
        humanTaskNode_7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E"));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.name("Screening Logic");
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.decision("https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A", "Screening Logic", null, () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A", "Screening Logic");
        });
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_fileNameInputX", "fileName", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("55d788af-bf80-4921-a057-0cb3c3118177", "EXPRESSION (dmn/screeningLogic.dmn)", "java.lang.Object", "dmn/screeningLogic.dmn"), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_fileNameInputX", "fileName", "java.lang.String", null))), null));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("fc1503e4-bfaf-427b-9cf6-e465d78734b0", "EXPRESSION (https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A)", "java.lang.Object", "https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A"), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_decisionInputX", "decision", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("overall", "overall", "java.lang.String", null), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_decisionInputX", "decision", "java.lang.String", null))), null));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("53915e55-437f-431a-bb7d-d89b9430192e", "EXPRESSION (Screening Logic)", "java.lang.Object", "Screening Logic"), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("src", "src", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_srcInputX", "src", "String", null), null, null));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E_overallOutputX", "overall", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("overall", "overall", "java.lang.String", null), null, null));
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.metaData("UniqueId", "_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E");
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.metaData("elementname", "Screening Logic");
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.metaData("x", 842);
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.metaData("width", 154);
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.metaData("y", 192);
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.metaData("height", 102);
        ruleSetNode_F1350AA5_E820_4B4D_B6DA_C9DA8810AD9E.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C6675F3D-DDF1-47D6-B329-E74333217A4F"));
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.name("Exclusive 1");
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.type(2);
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("UniqueId", "_C6675F3D-DDF1-47D6-B329-E74333217A4F");
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("elementname", "Exclusive 1");
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("x", 891);
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("width", 56);
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("y", 405);
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("Default", "_EBBB73E8-0A5A-4610-8E03-1D5047FBF4A2");
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.metaData("height", 56);
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053"), "_1BBB7EA2-42E5-4331-BCA5-CC750B9C8CEE", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Object person = (java.lang.Object) kcontext.getVariable("person");
            return person != null;
        }, 0, false);
        splitNode_C6675F3D_DDF1_47D6_B329_E74333217A4F.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_5888F973_7351_4043_BCBE_0B682F6BE278 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5888F973-7351-4043-BCBE-0B682F6BE278"));
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.name("Start");
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.interrupting(true);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("UniqueId", "_5888F973-7351-4043-BCBE-0B682F6BE278");
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("x", 17);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("width", 56);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("y", 405);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("height", 56);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.done();
        org.jbpm.ruleflow.core.factory.EventSubProcessNodeFactory<?> eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B = factory.eventSubProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21B1044B-A1F6-4744-8A2D-AF3A2D2A379B"));
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.name("Error Handling");
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.metaData("UniqueId", "_21B1044B-A1F6-4744-8A2D-AF3A2D2A379B");
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.metaData("elementname", "Error Handling");
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.metaData("x", 516);
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.metaData("width", 653);
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.metaData("y", 701);
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.metaData("height", 253);
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.keepActive(true);
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.event("Error-jang.lang.Throwable");
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.autoComplete(true);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_12B73924_40BE_44BE_946C_C1B63DD69255 = eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_12B73924-40BE-44BE-946C-C1B63DD69255"));
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.name("End");
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.terminate(false);
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.metaData("UniqueId", "_12B73924-40BE-44BE-946C-C1B63DD69255");
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.metaData("x", 456);
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.metaData("width", 56);
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.metaData("y", 96);
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.metaData("height", 56);
        endNode_12B73924_40BE_44BE_946C_C1B63DD69255.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1 = eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_04FBB718-10FD-4853-ADC0-BC12A84501B1"));
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.name("Task");
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("UniqueId", "_04FBB718-10FD-4853-ADC0-BC12A84501B1");
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("elementname", "Task");
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("NodeType", "ScriptTask");
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("x", 222);
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("width", 154);
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("y", 73);
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.metaData("height", 102);
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.action(kcontext -> {
            System.out.println("Error Handling (Screening) ...");
        });
        actionNode_04FBB718_10FD_4853_ADC0_BC12A84501B1.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A = eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AFAB3C3E-B11A-4A79-BCFD-A51D1D3BEA8A"));
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.name("Start");
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.interrupting(true);
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("FaultCode", "jang.lang.Throwable");
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("UniqueId", "_AFAB3C3E-B11A-4A79-BCFD-A51D1D3BEA8A");
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("TriggerType", "Signal");
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("x", 86);
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("width", 56);
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("y", 96);
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("TriggerRef", "jang.lang.Throwable");
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("MessageType", "jang.lang.Throwable");
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.metaData("height", 56);
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.done();
        startNode_AFAB3C3E_B11A_4A79_BCFD_A51D1D3BEA8A.trigger("jang.lang.Throwable", java.util.Arrays.asList());
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_04FBB718-10FD-4853-ADC0-BC12A84501B1"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_12B73924-40BE-44BE-946C-C1B63DD69255"), "_76CEBCD5-B440-4373-A157-481EC8DF44C6");
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AFAB3C3E-B11A-4A79-BCFD-A51D1D3BEA8A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_04FBB718-10FD-4853-ADC0-BC12A84501B1"), "_3D92559C-EFF3-41B0-8BF3-33CE0999980E");
        eventSubProcessNode_21B1044B_A1F6_4744_8A2D_AF3A2D2A379B.done();
        factory.errorExceptionHandler("Error-jang.lang.Throwable", "jang.lang.Throwable", null);
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1ECAA328-3EAA-485B-B159-12DF6AA24AF5"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AC9F64F3-1204-4BB0-B569-C7B51561D74A"), "_DB8C5156-4327-4DA1-B6A3-15F226686930");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D494041A-E608-498F-AFAE-0EB082E7FEB7"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1ECAA328-3EAA-485B-B159-12DF6AA24AF5"), "_6D8DE299-8825-4339-BF80-7BBDEA9A57F0");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_942FF689-8903-41A7-9D5E-B2FB76B19348"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1ECAA328-3EAA-485B-B159-12DF6AA24AF5"), "_13A35988-4EC1-4A39-AE26-F9947ABC3DDE");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1A0593B0-FF74-4BDC-916D-55E39E570B22"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D494041A-E608-498F-AFAE-0EB082E7FEB7"), "_B96E762B-DA11-4A4B-A415-EFFEEE23102E");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1A0593B0-FF74-4BDC-916D-55E39E570B22"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_942FF689-8903-41A7-9D5E-B2FB76B19348"), "_926B23A5-344F-4EA8-B62E-E9468C271692");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5888F973-7351-4043-BCBE-0B682F6BE278"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1A0593B0-FF74-4BDC-916D-55E39E570B22"), "_F890EEFF-2C72-4507-BA45-6638434B7CC4");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D9F28C5A-3447-4005-BBEE-BC46B9A8417D"), "_110AF110-E299-4F9D-8629-799D2B714B7D");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8224575C-D745-4BE5-AAE4-80FD71B8D5CF"), "_41D2D45C-B9A8-4EC4-B006-C2474E6EC2DC");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DFE551A0-7296-47BD-A1AF-696B1FACE3B6"), "_11B626BB-98BF-4EB1-8973-36AE6C9E5051");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C6675F3D-DDF1-47D6-B329-E74333217A4F"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053"), "_1BBB7EA2-42E5-4331-BCA5-CC750B9C8CEE");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C6675F3D-DDF1-47D6-B329-E74333217A4F"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F1350AA5-E820-4B4D-B6DA-C9DA8810AD9E"), "_EBBB73E8-0A5A-4610-8E03-1D5047FBF4A2");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AC9F64F3-1204-4BB0-B569-C7B51561D74A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C6675F3D-DDF1-47D6-B329-E74333217A4F"), "_0F0646AA-ED27-4921-A451-6AECBF26C87E");
        factory.validate();
        return factory.getProcess();
    }
}
