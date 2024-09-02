package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    com.example.travels.services.ExternalApiService service;

    public ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler() {
        this(new com.example.travels.services.ExternalApiService());
    }

    @jakarta.inject.Inject()
    public ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler(com.example.travels.services.ExternalApiService service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.fetchS2Data();
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("resultS2", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "com.example.travels.services.ExternalApiService_fetchS2Data__D494041A_E608_498F_AFAE_0EB082E7FEB7_Handler";
    }
}
