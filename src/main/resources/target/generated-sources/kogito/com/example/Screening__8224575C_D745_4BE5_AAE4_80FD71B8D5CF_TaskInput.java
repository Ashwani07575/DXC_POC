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

@UserTask(taskName = "Officer_Feedback_Screening", processName = "screening")
public class Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskInput {

    public static Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskInput fromMap(Map<String, Object> params) {
        Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskInput item = new Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskInput();
        item.Overall = (java.lang.String) params.get("Overall");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Overall;

    public java.lang.String getOverall() {
        return Overall;
    }

    public void setOverall(java.lang.String Overall) {
        this.Overall = Overall;
    }
}
//Task input for user task 'Officer Feedback' in process 'screening'
