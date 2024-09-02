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

public class Screening_TaskModelFactory {

    public static TaskModel from(org.kie.kogito.process.WorkItem workItem) {
        switch(workItem.getNodeId().toExternalFormat()) {
            case "_7DA9EC8B-B79D-42C1-B84C-22F0DD1BB053":
                return Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskModel.from(workItem);
            case "_8224575C-D745-4BE5-AAE4-80FD71B8D5CF":
                return Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskModel.from(workItem);
            default:
                throw new IllegalArgumentException("Invalid task name for work item " + workItem);
        }
    }
}
