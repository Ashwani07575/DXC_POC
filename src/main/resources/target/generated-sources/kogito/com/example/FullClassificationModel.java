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

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "fullClassification", name = "FullClassification", hidden = false)
public class FullClassificationModel implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<FullClassificationModelOutput> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "reclass")
    @jakarta.validation.Valid()
    private java.lang.Boolean reclass;

    public java.lang.Boolean getReclass() {
        return reclass;
    }

    public void setReclass(java.lang.Boolean reclass) {
        this.reclass = reclass;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "name")
    @jakarta.validation.Valid()
    private java.lang.String name;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "p_type")
    @jakarta.validation.Valid()
    private java.lang.String p_type;

    public java.lang.String getP_type() {
        return p_type;
    }

    public void setP_type(java.lang.String p_type) {
        this.p_type = p_type;
    }

    @Override()
    public FullClassificationModelOutput toModel() {
        FullClassificationModelOutput result = new FullClassificationModelOutput();
        result.setId(getId());
        result.setReclass(getReclass());
        result.setName(getName());
        result.setP_type(getP_type());
        return result;
    }
}
