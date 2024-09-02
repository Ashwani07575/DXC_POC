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
package com.example.travels.quarkus;

import java.util.List;

public class Traveler {
	
    private String name;
    private String passport_number;
    private String nationality;
    private String dob;
    private List<String> passport;
    // private String result;
	// private List<String> src;

    public Traveler() {
    }

    public Traveler(String name, String passport_number, String nationality, String dob) {
        this.name = name;
        this.passport_number = passport_number;
        this.nationality = nationality;
        this.dob = dob;
        // this.src = src;
		// this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passport_number;
    }

    public void setPassportNumber(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    // public List<String> getPassport() {
    //     return passport;
    // }

    // public void setPassport(List<String> passport) {
    //     this.passport = passport;
    // }

    // public List<String> getSrc() {
    //     return src;
    // }

    // public void setSrc(List<String> src) {
    //     this.src = src;
    // }
}