package com.example;

import com.example.ClassificationModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("classification")
@io.quarkus.runtime.Startup()
public class ClassificationProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.ClassificationModel> {

    public ClassificationProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler(), new org.kie.kogito.handlers.ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler());
    }

    @jakarta.inject.Inject()
    public ClassificationProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler externalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler, org.kie.kogito.handlers.ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler externalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler) {
        super(app, java.util.Arrays.asList(externalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler, externalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler), correlations);
        activate();
    }

    public ClassificationProcess() {
    }

    @Override()
    public com.example.ClassificationProcessInstance createInstance(com.example.ClassificationModel value) {
        return new com.example.ClassificationProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.ClassificationProcessInstance createInstance(java.lang.String businessKey, com.example.ClassificationModel value) {
        return new com.example.ClassificationProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.ClassificationProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.ClassificationModel value) {
        return new com.example.ClassificationProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.ClassificationModel createModel() {
        return new com.example.ClassificationModel();
    }

    public com.example.ClassificationProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.ClassificationModel) value);
    }

    public com.example.ClassificationProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.ClassificationModel) value);
    }

    public com.example.ClassificationProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ClassificationProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.ClassificationProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ClassificationProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("classification", true);
        factory.variable("person", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("person", "person", "ItemSubjectRef", "_personItem"));
        factory.variable("resultR1", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("resultR1", "resultR1", "ItemSubjectRef", "_resultR1Item"));
        factory.variable("resultV1", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("resultV1", "resultV1", "ItemSubjectRef", "_resultV1Item"));
        factory.variable("p_type", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("p_type", "p_type", "ItemSubjectRef", "_p_typeItem"));
        factory.variable("src", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("src", "src", "ItemSubjectRef", "_srcItem"));
        factory.variable("reclass", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("reclass", "reclass", "ItemSubjectRef", "_reclassItem"));
        factory.variable("name", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("name", "name", "ItemSubjectRef", "_nameItem"));
        factory.name("classification");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF = factory.joinNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0991322B-3B71-4753-8FF3-293C37DF1CDF"));
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.name("After API call");
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.type(1);
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.metaData("UniqueId", "_0991322B-3B71-4753-8FF3-293C37DF1CDF");
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.metaData("elementname", "After API call");
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.metaData("x", 574);
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.metaData("width", 56);
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.metaData("y", 415);
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.metaData("height", 56);
        joinNode_0991322B_3B71_4753_8FF3_293C37DF1CDF.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878 = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D0330E23-0A2F-4996-B694-FD2C0456A878"));
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.name("REST Service Call V1");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workName("com.example.travels.services.ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workParameter("Interface", "com.example.travels.services.ExternalApiService");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workParameter("NodeName", "REST Service Call V1");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workParameter("Operation", "fetchV1Data");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workParameter("implementation", "Java");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workParameter("interfaceImplementationRef", "com.example.travels.services.ExternalApiService");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.workParameter("operationImplementationRef", "fetchV1Data");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_D0330E23-0A2F-4996-B694-FD2C0456A878_resultV1OutputX", "resultV1", "Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("resultV1", "resultV1", "java.lang.Object", null), null, null));
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.done();
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("UniqueId", "_D0330E23-0A2F-4996-B694-FD2C0456A878");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("Implementation", "Java");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("elementname", "REST Service Call V1");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("Type", "Service Task");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("OperationRef", "_D0330E23-0A2F-4996-B694-FD2C0456A878_ServiceOperation");
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("x", 303);
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("width", 154);
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("y", 474);
        workItemNode_D0330E23_0A2F_4996_B694_FD2C0456A878.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EF0E37D3-169D-4590-8E85-F10E2E775A4A"));
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.name("REST Service Call R1");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workName("com.example.travels.services.ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workParameter("Interface", "com.example.travels.services.ExternalApiService");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workParameter("NodeName", "REST Service Call R1");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workParameter("Operation", "fetchR1Data");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workParameter("implementation", "Java");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workParameter("interfaceImplementationRef", "com.example.travels.services.ExternalApiService");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.workParameter("operationImplementationRef", "fetchR1Data");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_EF0E37D3-169D-4590-8E85-F10E2E775A4A_resultR1OutputX", "resultR1", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("resultR1", "resultR1", "java.lang.Object", null), null, null));
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.done();
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("UniqueId", "_EF0E37D3-169D-4590-8E85-F10E2E775A4A");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("Implementation", "Java");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("elementname", "REST Service Call R1");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("Type", "Service Task");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("OperationRef", "_EF0E37D3-169D-4590-8E85-F10E2E775A4A_ServiceOperation");
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("x", 303);
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("width", 154);
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("y", 302);
        workItemNode_EF0E37D3_169D_4590_8E85_F10E2E775A4A.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21BD53F9-D5EA-435B-A424-7D66E1765C93"));
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.name("Before API call");
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.type(1);
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.metaData("UniqueId", "_21BD53F9-D5EA-435B-A424-7D66E1765C93");
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.metaData("elementname", "Before API call");
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.metaData("x", 174);
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.metaData("width", 56);
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.metaData("y", 415);
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.metaData("height", 56);
        splitNode_21BD53F9_D5EA_435B_A424_7D66E1765C93.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A"));
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.name("Officer Feedback (Not Matched)");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.workParameter("ActorId", "jdoe");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.workParameter("NodeName", "Officer Feedback (Not Matched)");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.workParameter("Skippable", "false");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.workParameter("TaskName", "Officer_Feedback_Not_Matched_Classification");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("486ad244-b6ad-4cf0-8a9f-d9f7a78a0777", "EXPRESSION (Officer_Feedback_Not_Matched_Classification)", "java.lang.Object", "Officer_Feedback_Not_Matched_Classification"), new org.jbpm.workflow.core.impl.DataDefinition("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A_outputInputX", "output", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d2a875d5-2afe-4c27-abc1-6a4c7f6d7a7b", "EXPRESSION (Something went wrong, please try again.)", "java.lang.Object", "Something went wrong, please try again."), new org.jbpm.workflow.core.impl.DataDefinition("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A_outputInputX", "output", "String", null))), null));
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("82eb56ba-4f22-4126-9000-ae6f7cfa4bb7", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.done();
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.metaData("UniqueId", "_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.metaData("elementname", "Officer Feedback (Not Matched)");
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.metaData("x", 1207);
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.metaData("width", 154);
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.metaData("y", 392);
        humanTaskNode_7C253F1B_C1ED_49A9_8B5A_271A7D8A813A.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4B04002B-6E21-47A0-89BF-D46FCA1F4275"));
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.name("End");
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.terminate(false);
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.metaData("UniqueId", "_4B04002B-6E21-47A0-89BF-D46FCA1F4275");
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.metaData("x", 1521);
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.metaData("width", 56);
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.metaData("y", 415);
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.metaData("height", 56);
        endNode_4B04002B_6E21_47A0_89BF_D46FCA1F4275.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_88F66A52-610D-4127-97CA-88D7A42FB028"));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.name("Officer Feedback");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.workParameter("ActorId", "jdoe");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.workParameter("Comment", "Classification Feedback");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.workParameter("NodeName", "Officer Feedback");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.workParameter("Skippable", "false");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.workParameter("TaskName", "Officer_Feedback_Classification");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("971404ce-ef2f-4193-875c-20e84578a1e3", "EXPRESSION (Officer_Feedback_Classification)", "java.lang.Object", "Officer_Feedback_Classification"), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_nameInputX", "name", "String", null), null, null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("p_type", "p_type", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_p_typeInputX", "p_type", "String", null), null, null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_ClassifyInputX", "Classify", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("5aaf309d-2d95-4a3a-bf47-c0adeaddf32e", "EXPRESSION (Done)", "java.lang.Object", "Done"), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_ClassifyInputX", "Classify", "String", null))), null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_ScreeningInputX", "Screening", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("c6087328-5375-4140-8428-87906e54cc7d", "EXPRESSION (Not Done)", "java.lang.Object", "Not Done"), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_ScreeningInputX", "Screening", "String", null))), null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("686ea318-8f6c-42ee-a535-3c35463e35ca", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_CommentInputX", "Comment", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("a115c7df-650e-43f9-8665-f8f638a9c490", "EXPRESSION (Classification Feedback)", "java.lang.Object", "Classification Feedback"), new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_CommentInputX", "Comment", "Object", null))), null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_88F66A52-610D-4127-97CA-88D7A42FB028_reclassOutputX", "reclass", "Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("reclass", "reclass", "java.lang.Boolean", null), null, null));
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.done();
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.metaData("UniqueId", "_88F66A52-610D-4127-97CA-88D7A42FB028");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.metaData("elementname", "Officer Feedback");
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.metaData("x", 1207);
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.metaData("width", 154);
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.metaData("y", 139);
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.metaData("height", 102);
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.onActionScript("onEntry", "java", "System.out.println(\"Entering Officer Feedback User Task ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Entering Officer Feedback User Task ...");
        });
        humanTaskNode_88F66A52_610D_4127_97CA_88D7A42FB028.onActionScript("onExit", "java", "System.out.println(\"Exit Officer Feedback User Task ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Exit Officer Feedback User Task ...");
        });
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3EE6791C-9A54-47E7-8D17-1E4900158C30"));
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.name("End");
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.terminate(false);
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.metaData("UniqueId", "_3EE6791C-9A54-47E7-8D17-1E4900158C30");
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.metaData("x", 1521);
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.metaData("width", 56);
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.metaData("y", 162);
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.metaData("height", 56);
        endNode_3EE6791C_9A54_47E7_8D17_1E4900158C30.done();
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85 = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85"));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.name("Classification Logic");
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.decision("https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A", "Classification Logic", "Status", () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A", "Classification Logic");
        });
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_fileNameInputX", "fileName", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d4e69105-9bf8-487a-8d15-c00c0bde1151", "EXPRESSION (dmn/classificationLogic.dmn)", "java.lang.Object", "dmn/classificationLogic.dmn"), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_fileNameInputX", "fileName", "java.lang.String", null))), null));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("945bb6a1-5a11-4210-a460-9928606231b8", "EXPRESSION (https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A)", "java.lang.Object", "https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A"), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_decisionInputX", "decision", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("6c39753f-b936-4da3-9b0a-dfe5a8a1757c", "EXPRESSION (Status)", "java.lang.Object", "Status"), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_decisionInputX", "decision", "java.lang.String", null))), null));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("e7b597c3-b0a1-41d5-a3a3-12a2806d7702", "EXPRESSION (Classification Logic)", "java.lang.Object", "Classification Logic"), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("src", "src", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_Highest-PriorityInputX", "Highest Priority", "String", null), null, null));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85_P-typeOutputX", "P type", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("p_type", "p_type", "java.lang.String", null), null, null));
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.metaData("UniqueId", "_6135ACB7-D667-404C-A0C4-7EAC06EF5E85");
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.metaData("elementname", "Classification Logic");
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.metaData("x", 942);
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.metaData("width", 154);
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.metaData("y", 139);
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.metaData("height", 102);
        ruleSetNode_6135ACB7_D667_404C_A0C4_7EAC06EF5E85.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DDAE8D1E-7FCB-494A-9743-20A2F25372DA"));
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.name("Exclusive 1");
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.type(2);
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("UniqueId", "_DDAE8D1E-7FCB-494A-9743-20A2F25372DA");
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("elementname", "Exclusive 1");
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("x", 991);
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("width", 56);
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("y", 415);
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("Default", "_5CF05D12-A9B5-4A37-A60A-03EDFA7DFC50");
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.metaData("height", 56);
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A"), "_C8A9B793-8BD3-4457-8F4B-35A4230AA5D1", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String name = (java.lang.String) kcontext.getVariable("name");
            return name.isEmpty();
        }, 0, false);
        splitNode_DDAE8D1E_7FCB_494A_9743_20A2F25372DA.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4DD39C25-58D7-4865-9263-6B2E3B3E859A"));
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.name("Transforming Data");
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("UniqueId", "_4DD39C25-58D7-4865-9263-6B2E3B3E859A");
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("elementname", "Transforming Data");
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("NodeType", "ScriptTask");
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("x", 740);
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("width", 154);
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("y", 392);
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("customAutoStart", "true");
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.metaData("height", 102);
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.action(kcontext -> {
            java.lang.Object resultR1 = (java.lang.Object) kcontext.getVariable("resultR1");
            java.lang.Object resultV1 = (java.lang.Object) kcontext.getVariable("resultV1");
            java.lang.String src = (java.lang.String) kcontext.getVariable("src");
            java.lang.Boolean reclass = (java.lang.Boolean) kcontext.getVariable("reclass");
            java.lang.String name = (java.lang.String) kcontext.getVariable("name");
            System.out.println("Entering Transforming Data...");
            System.out.println(resultR1);
            System.out.println(resultV1);
            if (!name.isEmpty()) {
                kcontext.setVariable("src", "v");
                kcontext.setVariable("reclass", false);
            }
        });
        actionNode_4DD39C25_58D7_4865_9263_6B2E3B3E859A.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_5888F973_7351_4043_BCBE_0B682F6BE278 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5888F973-7351-4043-BCBE-0B682F6BE278"));
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.name("Start");
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.interrupting(true);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("UniqueId", "_5888F973-7351-4043-BCBE-0B682F6BE278");
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("x", 38);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("width", 56);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("y", 415);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.metaData("height", 56);
        startNode_5888F973_7351_4043_BCBE_0B682F6BE278.done();
        org.jbpm.ruleflow.core.factory.EventSubProcessNodeFactory<?> eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE = factory.eventSubProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F7C17C97-D245-4ADC-A7DA-0935C646A1BE"));
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.name("Error Handling");
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.metaData("UniqueId", "_F7C17C97-D245-4ADC-A7DA-0935C646A1BE");
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.metaData("elementname", "Error Handling");
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.metaData("x", 448);
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.metaData("width", 653);
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.metaData("y", 726);
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.metaData("height", 253);
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.keepActive(true);
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.event("Error-jang.lang.Throwable");
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.autoComplete(true);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894 = eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_E11DFCFF-4660-41BA-957C-DFAD38C27894"));
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.name("Task");
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("UniqueId", "_E11DFCFF-4660-41BA-957C-DFAD38C27894");
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("elementname", "Task");
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("NodeType", "ScriptTask");
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("x", 213);
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("width", 167);
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("y", 88);
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.metaData("height", 99);
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.action(kcontext -> {
            System.out.println("Error Handling (Classification) ...");
        });
        actionNode_E11DFCFF_4660_41BA_957C_DFAD38C27894.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E = eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_47BBE4F7-B0D1-4CB8-9E1D-147363065F8E"));
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.name("End");
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.terminate(false);
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.metaData("UniqueId", "_47BBE4F7-B0D1-4CB8-9E1D-147363065F8E");
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.metaData("x", 454);
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.metaData("width", 56);
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.metaData("y", 110);
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.metaData("height", 56);
        endNode_47BBE4F7_B0D1_4CB8_9E1D_147363065F8E.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_2B63AD86_ED31_4731_847B_E4FE059896D4 = eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_2B63AD86-ED31-4731-847B-E4FE059896D4"));
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.name("Start");
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.interrupting(true);
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("FaultCode", "jang.lang.Throwable");
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("UniqueId", "_2B63AD86-ED31-4731-847B-E4FE059896D4");
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("TriggerType", "Signal");
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("x", 84);
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("width", 56);
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("y", 110);
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("TriggerRef", "jang.lang.Throwable");
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("MessageType", "jang.lang.Throwable");
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.metaData("height", 56);
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.done();
        startNode_2B63AD86_ED31_4731_847B_E4FE059896D4.trigger("jang.lang.Throwable", java.util.Arrays.asList());
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_2B63AD86-ED31-4731-847B-E4FE059896D4"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_E11DFCFF-4660-41BA-957C-DFAD38C27894"), "_150924A4-AB75-4E50-87AB-21569E29650A");
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_E11DFCFF-4660-41BA-957C-DFAD38C27894"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_47BBE4F7-B0D1-4CB8-9E1D-147363065F8E"), "_F95D8001-6245-48E8-9844-3E3B8B3F1E15");
        eventSubProcessNode_F7C17C97_D245_4ADC_A7DA_0935C646A1BE.done();
        factory.errorExceptionHandler("Error-jang.lang.Throwable", "jang.lang.Throwable", null);
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D0330E23-0A2F-4996-B694-FD2C0456A878"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0991322B-3B71-4753-8FF3-293C37DF1CDF"), "_8C143243-D706-4BF0-9C0B-E5C835CAC7E9");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EF0E37D3-169D-4590-8E85-F10E2E775A4A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0991322B-3B71-4753-8FF3-293C37DF1CDF"), "_1ADF0E2E-833A-45CD-9D2C-2D508F972989");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21BD53F9-D5EA-435B-A424-7D66E1765C93"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D0330E23-0A2F-4996-B694-FD2C0456A878"), "_4C3F0F34-07A0-4BC4-A629-4169010EC0C9");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21BD53F9-D5EA-435B-A424-7D66E1765C93"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EF0E37D3-169D-4590-8E85-F10E2E775A4A"), "_B0F6E9D5-709C-4327-9E86-585332326742");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5888F973-7351-4043-BCBE-0B682F6BE278"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_21BD53F9-D5EA-435B-A424-7D66E1765C93"), "_499198AD-134C-426B-A72E-8C4CCD9442C9");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DDAE8D1E-7FCB-494A-9743-20A2F25372DA"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A"), "_C8A9B793-8BD3-4457-8F4B-35A4230AA5D1");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4B04002B-6E21-47A0-89BF-D46FCA1F4275"), "_3F07723A-C48A-41ED-96B9-A78D4F4D1D41");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_88F66A52-610D-4127-97CA-88D7A42FB028"), "_E5173164-DE90-4864-B8DF-1A32F5C25F01");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_88F66A52-610D-4127-97CA-88D7A42FB028"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3EE6791C-9A54-47E7-8D17-1E4900158C30"), "_F205EB06-3627-4E7A-9A20-16D70F1DEDA6");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DDAE8D1E-7FCB-494A-9743-20A2F25372DA"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_6135ACB7-D667-404C-A0C4-7EAC06EF5E85"), "_5CF05D12-A9B5-4A37-A60A-03EDFA7DFC50");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4DD39C25-58D7-4865-9263-6B2E3B3E859A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DDAE8D1E-7FCB-494A-9743-20A2F25372DA"), "_D26179CE-F125-418A-AB09-3E33DC7130BD");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0991322B-3B71-4753-8FF3-293C37DF1CDF"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4DD39C25-58D7-4865-9263-6B2E3B3E859A"), "_8E28AB48-BFA2-4DCD-A4B6-86596B2989C4");
        factory.validate();
        return factory.getProcess();
    }
}
