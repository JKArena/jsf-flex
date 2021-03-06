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
package com.googlecode.jsfFlex.shared.adapter;

import java.util.Map;

import org.json.JSONObject;

import com.googlecode.jsfFlex.renderkit.annotationDocletParser.AbstractAnnotationDocletParser;

/**
 * @author Ji Hoon Kim
 */
public interface IFlexContract {
	
	Map<String, Object> getAttributes();
	
	AbstractAnnotationDocletParser getAnnotationDocletParserInstance();
	
	String getAbsolutePathToPreMxmlFile();
	void setAbsolutePathToPreMxmlFile(String absolutePathToPreMxmlFile);
	
	int getMajorLevel();
	void setMajorLevel(int majorLevel);
	
	int getMinorLevel();
	void setMinorLevel(int minorLevel);
	
	String getParentPreMxmlIdentifier();
	void setParentPreMxmlIdentifier(String parentPreMxmlIdentifier);
	
	String getPreMxmlIdentifier();
	void setPreMxmlIdentifier(String preMxmlIdentifier);
	
	JSONObject getComponentInitValues();
	
    String getNameSpaceOverride();
    
}
