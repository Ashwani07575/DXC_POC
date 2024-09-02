package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    com.example.travels.services.ExternalApiService service;

    public ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler() {
        this(new com.example.travels.services.ExternalApiService());
    }

    @jakarta.inject.Inject()
    public ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler(com.example.travels.services.ExternalApiService service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.fetchR1Data();
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("resultR1", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "com.example.travels.services.ExternalApiService_fetchR1Data__EF0E37D3_169D_4590_8E85_F10E2E775A4A_Handler";
    }
}
