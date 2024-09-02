package com.example;

import com.example.FullClassificationModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("fullClassification")
@io.quarkus.runtime.Startup()
public class FullClassificationProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.FullClassificationModel> {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("screening")
    org.kie.kogito.process.Process<ScreeningModel> processscreening;

    @jakarta.inject.Inject()
    @jakarta.inject.Named("postClassification")
    org.kie.kogito.process.Process<PostClassificationModel> processpostClassification;

    @jakarta.inject.Inject()
    @jakarta.inject.Named("classification")
    org.kie.kogito.process.Process<ClassificationModel> processclassification;

    @jakarta.inject.Inject()
    public FullClassificationProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        super(app, java.util.Arrays.asList(), correlations);
        activate();
    }

    public FullClassificationProcess() {
    }

    @Override()
    public com.example.FullClassificationProcessInstance createInstance(com.example.FullClassificationModel value) {
        return new com.example.FullClassificationProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.FullClassificationProcessInstance createInstance(java.lang.String businessKey, com.example.FullClassificationModel value) {
        return new com.example.FullClassificationProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.FullClassificationProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.FullClassificationModel value) {
        return new com.example.FullClassificationProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.FullClassificationModel createModel() {
        return new com.example.FullClassificationModel();
    }

    public com.example.FullClassificationProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.FullClassificationModel) value);
    }

    public com.example.FullClassificationProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.FullClassificationModel) value);
    }

    public com.example.FullClassificationProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.FullClassificationProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.FullClassificationProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.FullClassificationProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("fullClassification", true);
        factory.variable("person", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("customTags", "input", "person", "person", "ItemSubjectRef", "_personItem"));
        factory.variable("reclass", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("reclass", "reclass", "ItemSubjectRef", "_reclassItem"));
        factory.variable("name", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("name", "name", "ItemSubjectRef", "_nameItem"));
        factory.variable("p_type", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("p_type", "p_type", "ItemSubjectRef", "_p_typeItem"));
        factory.name("Full Process");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_07F9C411-A3C2-4F9F-B357-74D47022595D"));
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.name("Screening process");
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.processId("screening");
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.processName("");
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.waitForCompletion(true);
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.independent(false);
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<ScreeningModel>() {

            public ScreeningModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                com.example.ScreeningModel model = new com.example.ScreeningModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<ScreeningModel> createInstance(ScreeningModel model) {
                return (org.kie.kogito.process.ProcessInstance<ScreeningModel>) app.get(org.kie.kogito.process.Processes.class).processById("screening").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, ScreeningModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("person", "person", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_07F9C411-A3C2-4F9F-B357-74D47022595D_personInputX", "person", "Object", null), null, null));
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.metaData("UniqueId", "_07F9C411-A3C2-4F9F-B357-74D47022595D");
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.metaData("elementname", "Screening process");
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.metaData("x", 1162);
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.metaData("width", 153);
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.metaData("y", 162);
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.metaData("height", 101);
        subProcessNode_07F9C411_A3C2_4F9F_B357_74D47022595D.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C2356A6-1288-4C79-B44D-90E07B8EB24B"));
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.name("End");
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.terminate(false);
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.metaData("UniqueId", "_0C2356A6-1288-4C79-B44D-90E07B8EB24B");
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.metaData("x", 1412);
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.metaData("width", 56);
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.metaData("y", 187);
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.metaData("height", 56);
        endNode_0C2356A6_1288_4C79_B44D_90E07B8EB24B.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B283FD0C-07B7-499F-8ACB-3FEA90363129"));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.name("Officer Feedback");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.workParameter("ActorId", "jdoe");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.workParameter("Comment", "Post Classification Feedback");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.workParameter("NodeName", "Officer Feedback");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.workParameter("Skippable", "false");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.workParameter("TaskName", "Officer_Feedback_Post_Classification");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("4cbe4aaa-8228-4696-9984-d1b43d26091e", "EXPRESSION (Officer_Feedback_Post_Classification)", "java.lang.Object", "Officer_Feedback_Post_Classification"), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_nameInputX", "name", "String", null), null, null));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_outputInputX", "output", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("8272d1e0-9f03-42af-850f-7130bdbef711", "EXPRESSION (This is a post-classification feedback form.)", "java.lang.Object", "This is a post-classification feedback form."), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_outputInputX", "output", "String", null))), null));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("p_type", "p_type", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_p_typeInputX", "p_type", "String", null), null, null));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("4544827f-e7a3-4007-8ff4-af34604e8e95", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_CommentInputX", "Comment", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("1e27f01b-24f3-4521-87ad-c2d472053d3f", "EXPRESSION (Post Classification Feedback)", "java.lang.Object", "Post Classification Feedback"), new org.jbpm.workflow.core.impl.DataDefinition("_B283FD0C-07B7-499F-8ACB-3FEA90363129_CommentInputX", "Comment", "Object", null))), null));
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.done();
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.metaData("UniqueId", "_B283FD0C-07B7-499F-8ACB-3FEA90363129");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.metaData("elementname", "Officer Feedback");
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.metaData("x", 911);
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.metaData("width", 154);
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.metaData("y", 162);
        humanTaskNode_B283FD0C_07B7_499F_8ACB_3FEA90363129.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_877415E7_1155_43AB_B8A5_345F5314D659 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_877415E7-1155-43AB-B8A5-345F5314D659"));
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.name("End");
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.terminate(false);
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.metaData("UniqueId", "_877415E7-1155-43AB-B8A5-345F5314D659");
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.metaData("x", 1145);
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.metaData("width", 56);
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.metaData("y", 404);
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.metaData("height", 56);
        endNode_877415E7_1155_43AB_B8A5_345F5314D659.done();
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741 = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F226354-54FD-4DAD-925D-609FC5229741"));
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.name("Screening process");
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.processId("screening");
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.processName("");
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.waitForCompletion(true);
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.independent(false);
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<ScreeningModel>() {

            public ScreeningModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                com.example.ScreeningModel model = new com.example.ScreeningModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<ScreeningModel> createInstance(ScreeningModel model) {
                return (org.kie.kogito.process.ProcessInstance<ScreeningModel>) app.get(org.kie.kogito.process.Processes.class).processById("screening").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, ScreeningModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.metaData("UniqueId", "_4F226354-54FD-4DAD-925D-609FC5229741");
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.metaData("elementname", "Screening process");
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.metaData("x", 912);
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.metaData("width", 153);
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.metaData("y", 382);
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.metaData("height", 101);
        subProcessNode_4F226354_54FD_4DAD_925D_609FC5229741.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C245FFA0-99BD-43B4-9018-1157DB9195AD"));
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.name("Exclusive");
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.type(2);
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("UniqueId", "_C245FFA0-99BD-43B4-9018-1157DB9195AD");
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("elementname", "Exclusive");
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("x", 709);
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("width", 56);
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("y", 404);
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("Default", "_D59FC408-0E9B-4741-A612-5874CC455C85");
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.metaData("height", 56);
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_966B2F33-875D-45B0-BFD0-4C0A6A15002B"), "_CBE28D2B-2587-420E-90EB-B9BA2916873E", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean reclass = (java.lang.Boolean) kcontext.getVariable("reclass");
            return reclass;
        }, 0, false);
        splitNode_C245FFA0_99BD_43B4_9018_1157DB9195AD.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8774F5F6-63D9-44FE-9F71-56D9DFE00F43"));
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.name("Task");
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("UniqueId", "_8774F5F6-63D9-44FE-9F71-56D9DFE00F43");
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("elementname", "Task");
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("NodeType", "ScriptTask");
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("x", 220);
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("width", 154);
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("y", 381);
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.metaData("height", 102);
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.action(kcontext -> {
            java.lang.Boolean reclass = (java.lang.Boolean) kcontext.getVariable("reclass");
            System.out.println("Starting the Full Process ...");
            kcontext.setVariable("reclass", false);
        });
        actionNode_8774F5F6_63D9_44FE_9F71_56D9DFE00F43.done();
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_966B2F33-875D-45B0-BFD0-4C0A6A15002B"));
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.name("Post Classification process");
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.processId("postClassification");
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.processName("");
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.waitForCompletion(true);
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.independent(false);
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<PostClassificationModel>() {

            public PostClassificationModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                com.example.PostClassificationModel model = new com.example.PostClassificationModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<PostClassificationModel> createInstance(PostClassificationModel model) {
                return (org.kie.kogito.process.ProcessInstance<PostClassificationModel>) app.get(org.kie.kogito.process.Processes.class).processById("postClassification").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, PostClassificationModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                outputs.put("p_type", model.getP_type());
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("person", "person", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_966B2F33-875D-45B0-BFD0-4C0A6A15002B_personInputX", "person", "Object", null), null, null));
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("reclass", "reclass", "java.lang.Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("_966B2F33-875D-45B0-BFD0-4C0A6A15002B_reclassInputX", "reclass", "Boolean", null), null, null));
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_966B2F33-875D-45B0-BFD0-4C0A6A15002B_nameInputX", "name", "String", null), null, null));
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_966B2F33-875D-45B0-BFD0-4C0A6A15002B_p_typeOutputX", "p_type", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("p_type", "p_type", "java.lang.String", null), null, null));
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.metaData("UniqueId", "_966B2F33-875D-45B0-BFD0-4C0A6A15002B");
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.metaData("elementname", "Post Classification process");
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.metaData("x", 660);
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.metaData("width", 153);
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.metaData("y", 164);
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.metaData("height", 101);
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.done();
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.onActionScript("onEntry", "java", "System.out.println(\"Entering Post-Classification Process ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Entering Post-Classification Process ...");
        });
        subProcessNode_966B2F33_875D_45B0_BFD0_4C0A6A15002B.onActionScript("onExit", "java", "System.out.println(\"Exit Post-Classification Process ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Exit Post-Classification Process ...");
        });
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1 = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BC291733-09A1-4C94-9EEC-7C3083E185C1"));
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.name("Classification process");
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.processId("classification");
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.processName("");
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.waitForCompletion(true);
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.independent(false);
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<ClassificationModel>() {

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
                outputs.put("reclass", model.getReclass());
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("person", "person", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BC291733-09A1-4C94-9EEC-7C3083E185C1_personInputX", "person", "Object", null), null, null));
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BC291733-09A1-4C94-9EEC-7C3083E185C1_nameInputX", "name", "String", null), null, null));
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_BC291733-09A1-4C94-9EEC-7C3083E185C1_reclassOutputX", "reclass", "Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("reclass", "reclass", "java.lang.Boolean", null), null, null));
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.metaData("UniqueId", "_BC291733-09A1-4C94-9EEC-7C3083E185C1");
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.metaData("elementname", "Classification process");
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.metaData("x", 464);
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.metaData("width", 153);
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.metaData("y", 381);
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.metaData("height", 101);
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.done();
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.onActionScript("onEntry", "java", "System.out.println(\"Entering Classification Process ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Entering Classification Process ...");
        });
        subProcessNode_BC291733_09A1_4C94_9EEC_7C3083E185C1.onActionScript("onExit", "java", "System.out.println(\"Exit Classification Process ...\");", (org.kie.kogito.internal.process.runtime.KogitoProcessContext kcontext) -> {
            System.out.println("Exit Classification Process ...");
        });
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8A93A718-C38F-40C7-A128-B01DE4CFF384"));
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.name("Start");
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.interrupting(true);
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.metaData("UniqueId", "_8A93A718-C38F-40C7-A128-B01DE4CFF384");
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.metaData("x", 98);
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.metaData("width", 56);
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.metaData("y", 404);
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.metaData("height", 56);
        startNode_8A93A718_C38F_40C7_A128_B01DE4CFF384.done();
        org.jbpm.ruleflow.core.factory.EventSubProcessNodeFactory<?> eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8 = factory.eventSubProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_16547CE6-DEE4-49B3-A2D0-58AEBBC183C8"));
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.name("Error Handling");
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.metaData("UniqueId", "_16547CE6-DEE4-49B3-A2D0-58AEBBC183C8");
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.metaData("elementname", "Error Handling");
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.metaData("x", 440);
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.metaData("width", 653);
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.metaData("y", 669);
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.metaData("height", 253);
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.variable("person", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("person", "person", "ItemSubjectRef", "_personItem"));
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.keepActive(true);
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.event("Error-jang.lang.Throwable");
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.autoComplete(true);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325 = eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_54B0EA34-10CC-48B5-8248-7519E0DA3325"));
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.name("End");
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.terminate(false);
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.metaData("UniqueId", "_54B0EA34-10CC-48B5-8248-7519E0DA3325");
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.metaData("x", 462);
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.metaData("width", 56);
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.metaData("y", 104);
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.metaData("height", 56);
        endNode_54B0EA34_10CC_48B5_8248_7519E0DA3325.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146 = eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BF8FDAA2-D32D-429F-B6D4-1AFB7F185146"));
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.name("Task");
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("UniqueId", "_BF8FDAA2-D32D-429F-B6D4-1AFB7F185146");
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("elementname", "Task");
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("NodeType", "ScriptTask");
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("x", 228);
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("width", 154);
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("y", 81);
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.metaData("height", 102);
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.action(kcontext -> {
            java.lang.Object person = (java.lang.Object) kcontext.getVariable("person");
            System.out.println("Error Handling (Full Process) ...");
            System.out.println(person);
        });
        actionNode_BF8FDAA2_D32D_429F_B6D4_1AFB7F185146.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6 = eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_577ED5CA-A0F6-4348-9731-8DBC41AC64B6"));
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.name("Start");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.interrupting(true);
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_577ED5CA-A0F6-4348-9731-8DBC41AC64B6_personOutputX", "person", "Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("person", "person", "java.lang.Object", null), null, null));
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("TriggerMapping", "person");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("FaultCode", "jang.lang.Throwable");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("UniqueId", "_577ED5CA-A0F6-4348-9731-8DBC41AC64B6");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("TriggerType", "Signal");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("TriggerRef", "jang.lang.Throwable");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("x", 92);
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("width", 56);
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("y", 104);
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("MappingVariable", "person");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("TriggerMappingInput", "person");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("MessageType", "jang.lang.Throwable");
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.metaData("height", 56);
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.done();
        startNode_577ED5CA_A0F6_4348_9731_8DBC41AC64B6.trigger("jang.lang.Throwable", java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_577ED5CA-A0F6-4348-9731-8DBC41AC64B6_personOutputX", "person", "Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("person", "person", "java.lang.Object", null), null, null)));
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BF8FDAA2-D32D-429F-B6D4-1AFB7F185146"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_54B0EA34-10CC-48B5-8248-7519E0DA3325"), "_0AFB1D3C-B24A-4C9B-9CA3-0EE1C7586F13");
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_577ED5CA-A0F6-4348-9731-8DBC41AC64B6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BF8FDAA2-D32D-429F-B6D4-1AFB7F185146"), "_0F45CD74-9972-477E-8A35-103CC370CEF0");
        eventSubProcessNode_16547CE6_DEE4_49B3_A2D0_58AEBBC183C8.done();
        factory.errorExceptionHandler("Error-jang.lang.Throwable", "jang.lang.Throwable", "person");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B283FD0C-07B7-499F-8ACB-3FEA90363129"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_07F9C411-A3C2-4F9F-B357-74D47022595D"), "_A6EE4885-524F-43BD-BE79-DC5B69E2A908");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_07F9C411-A3C2-4F9F-B357-74D47022595D"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C2356A6-1288-4C79-B44D-90E07B8EB24B"), "_6CB3A87B-4830-4095-9192-D6F02BF5D908");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_966B2F33-875D-45B0-BFD0-4C0A6A15002B"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B283FD0C-07B7-499F-8ACB-3FEA90363129"), "_E8DB5ADD-D209-4C15-987C-466019D13D20");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F226354-54FD-4DAD-925D-609FC5229741"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_877415E7-1155-43AB-B8A5-345F5314D659"), "_6A2CAEAC-B041-4D59-B94A-4052CF5D2FB9");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C245FFA0-99BD-43B4-9018-1157DB9195AD"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4F226354-54FD-4DAD-925D-609FC5229741"), "_D59FC408-0E9B-4741-A612-5874CC455C85");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BC291733-09A1-4C94-9EEC-7C3083E185C1"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C245FFA0-99BD-43B4-9018-1157DB9195AD"), "_55B3213A-90BC-4842-9ACB-8D77F4DC57F4");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8A93A718-C38F-40C7-A128-B01DE4CFF384"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8774F5F6-63D9-44FE-9F71-56D9DFE00F43"), "_1E3CC44B-AECA-4DAA-9555-AC593D680F49");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C245FFA0-99BD-43B4-9018-1157DB9195AD"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_966B2F33-875D-45B0-BFD0-4C0A6A15002B"), "_CBE28D2B-2587-420E-90EB-B9BA2916873E");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8774F5F6-63D9-44FE-9F71-56D9DFE00F43"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BC291733-09A1-4C94-9EEC-7C3083E185C1"), "_78066F17-8FFD-4D24-8FA5-5A2E6192D939");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("screening", completionEventListener);
        services.getSignalManager().addEventListener("postClassification", completionEventListener);
        services.getSignalManager().addEventListener("classification", completionEventListener);
    }
}
