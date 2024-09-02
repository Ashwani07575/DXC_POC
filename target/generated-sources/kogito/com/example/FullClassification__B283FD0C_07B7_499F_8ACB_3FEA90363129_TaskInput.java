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

@UserTask(taskName = "Officer_Feedback_Post_Classification", processName = "fullClassification")
public class FullClassification__B283FD0C_07B7_499F_8ACB_3FEA90363129_TaskInput {

    public static FullClassification__B283FD0C_07B7_499F_8ACB_3FEA90363129_TaskInput fromMap(Map<String, Object> params) {
        FullClassification__B283FD0C_07B7_499F_8ACB_3FEA90363129_TaskInput item = new FullClassification__B283FD0C_07B7_499F_8ACB_3FEA90363129_TaskInput();
        item.output = (java.lang.String) params.get("output");
        item.name = (java.lang.String) params.get("name");
        item.p_type = (java.lang.String) params.get("p_type");
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

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String name;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String p_type;

    public java.lang.String getP_type() {
        return p_type;
    }

    public void setP_type(java.lang.String p_type) {
        this.p_type = p_type;
    }
}
//Task input for user task 'Officer Feedback' in process 'fullClassification'
