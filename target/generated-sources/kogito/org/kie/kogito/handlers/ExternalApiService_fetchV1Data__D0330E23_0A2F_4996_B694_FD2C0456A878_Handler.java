package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    com.example.travels.services.ExternalApiService service;

    public ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler() {
        this(new com.example.travels.services.ExternalApiService());
    }

    @jakarta.inject.Inject()
    public ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler(com.example.travels.services.ExternalApiService service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.fetchV1Data();
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("resultV1", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "com.example.travels.services.ExternalApiService_fetchV1Data__D0330E23_0A2F_4996_B694_FD2C0456A878_Handler";
    }
}
