/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example;

import org.kie.kogito.process.workitem.TaskModel;

public class Classification_TaskModelFactory {

    public static TaskModel from(org.kie.kogito.process.WorkItem workItem) {
        switch(workItem.getNodeId().toExternalFormat()) {
            case "_88F66A52-610D-4127-97CA-88D7A42FB028":
                return Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskModel.from(workItem);
            case "_7C253F1B-C1ED-49A9-8B5A-271A7D8A813A":
                return Classification__7C253F1B_C1ED_49A9_8B5A_271A7D8A813A_TaskModel.from(workItem);
            default:
                throw new IllegalArgumentException("Invalid task name for work item " + workItem);
        }
    }
}
