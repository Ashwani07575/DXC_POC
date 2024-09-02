package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    com.example.travels.services.ExternalApiService service;

    public ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler() {
        this(new com.example.travels.services.ExternalApiService());
    }

    @jakarta.inject.Inject()
    public ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler(com.example.travels.services.ExternalApiService service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.fetchS1Data();
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("resultS1", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "com.example.travels.services.ExternalApiService_fetchS1Data__942FF689_8903_41A7_9D5E_B2FB76B19348_Handler";
    }
}
