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
package com.googlecode.jsfFlex.framework.component;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @JsfFlexAttributes
 * 	dataProvider=true
 * 	editable=true
 * 	imeMode=true
 * 	restrict=true
 * 	selectedIndex=true
 * 	selectedItem=true
 * 	disabledSkin=true
 * 	downSkin=true
 * 	editableDisabledSkin=true
 * 	editableDownSkin=true
 * 	editableOverSkin=true
 * 	editableUpSkin=true
 * 	overSkin=true
 * 	upSkin
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLComboBaseTemplate extends MXMLComponentBase {
	
	private static final String MXML_COMBO_BASE_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLComboBaseTemplate.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_COMBO_BASE_TEMPLATE_REPLACE_MAPPING = packageName + 
													"/replaceMapping/MXMLComboBaseTemplateReplaceMapping.xml";
	}
	
	public MXMLComboBaseTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLComboBaseTemplate.class, componentObj, MXML_COMBO_BASE_TEMPLATE_REPLACE_MAPPING);
		
	}
	
}