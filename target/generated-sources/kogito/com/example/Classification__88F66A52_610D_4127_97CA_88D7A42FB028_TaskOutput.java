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

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Officer_Feedback_Classification", processName = "classification")
public class Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("reclass", this.reclass);
        return params;
    }

    public static Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskOutput fromMap(Map<String, Object> params) {
        com.example.Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskOutput result = new Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskOutput();
        result.reclass = (java.lang.Boolean) params.get("reclass");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private java.lang.Boolean reclass;

    public java.lang.Boolean getReclass() {
        return reclass;
    }

    public void setReclass(java.lang.Boolean reclass) {
        this.reclass = reclass;
    }
}
//Task output for user task 'Officer Feedback' in process 'classification'
