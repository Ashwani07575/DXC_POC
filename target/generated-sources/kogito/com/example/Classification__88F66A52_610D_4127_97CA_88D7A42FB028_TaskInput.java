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

@UserTask(taskName = "Officer_Feedback_Classification", processName = "classification")
public class Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskInput {

    public static Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskInput fromMap(Map<String, Object> params) {
        Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskInput item = new Classification__88F66A52_610D_4127_97CA_88D7A42FB028_TaskInput();
        item.Screening = (java.lang.String) params.get("Screening");
        item.Classify = (java.lang.String) params.get("Classify");
        item.name = (java.lang.String) params.get("name");
        item.p_type = (java.lang.String) params.get("p_type");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Screening;

    public java.lang.String getScreening() {
        return Screening;
    }

    public void setScreening(java.lang.String Screening) {
        this.Screening = Screening;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Classify;

    public java.lang.String getClassify() {
        return Classify;
    }

    public void setClassify(java.lang.String Classify) {
        this.Classify = Classify;
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
//Task input for user task 'Officer Feedback' in process 'classification'
