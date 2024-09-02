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

import java.util.Map;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Officer_Feedback_Not_Matched_Screening", processName = "screening")
public class Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskInput {

    public static Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskInput fromMap(Map<String, Object> params) {
        Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskInput item = new Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskInput();
        item.output = (java.lang.String) params.get("output");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String output;

    public java.lang.String getOutput() {
        return output;
    }

    public void setOutput(java.lang.String output) {
        this.output = output;
    }
}
//Task input for user task 'Officer Feedback Not Matched' in process 'screening'
