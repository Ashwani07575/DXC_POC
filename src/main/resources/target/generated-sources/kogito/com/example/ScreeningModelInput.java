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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "screening", name = "Screening", hidden = true)
@ProcessInput(processName = "screening")
public class ScreeningModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<ScreeningModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "resultS2")
    @jakarta.validation.Valid()
    private java.lang.Object resultS2;

    public java.lang.Object getResultS2() {
        return resultS2;
    }

    public void setResultS2(java.lang.Object resultS2) {
        this.resultS2 = resultS2;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "src")
    @jakarta.validation.Valid()
    private java.lang.String src;

    public java.lang.String getSrc() {
        return src;
    }

    public void setSrc(java.lang.String src) {
        this.src = src;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "person")
    @jakarta.validation.Valid()
    private java.lang.Object person;

    public java.lang.Object getPerson() {
        return person;
    }

    public void setPerson(java.lang.Object person) {
        this.person = person;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "resultS1")
    @jakarta.validation.Valid()
    private java.lang.Object resultS1;

    public java.lang.Object getResultS1() {
        return resultS1;
    }

    public void setResultS1(java.lang.Object resultS1) {
        this.resultS1 = resultS1;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "overall")
    @jakarta.validation.Valid()
    private java.lang.String overall;

    public java.lang.String getOverall() {
        return overall;
    }

    public void setOverall(java.lang.String overall) {
        this.overall = overall;
    }

    @Override()
    public ScreeningModel toModel() {
        ScreeningModel result = new ScreeningModel();
        result.setResultS2(getResultS2());
        result.setSrc(getSrc());
        result.setPerson(getPerson());
        result.setResultS1(getResultS1());
        result.setOverall(getOverall());
        return result;
    }
}
