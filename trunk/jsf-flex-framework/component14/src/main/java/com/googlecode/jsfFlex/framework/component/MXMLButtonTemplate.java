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
 * 	autoRepeat=false
 * 	emphasized=false
 * 	label=false
 * 	labelPlacement=false
 * 	selectedField=false
 * 	stickyHighlighting=false
 * 	toggle=false
 * 	borderColor=false
 * 	color=false
 * 	cornerRadius=false
 * 	disabledColor=false
 * 	disabledIcon=false
 * 	disabledSkin=false
 * 	downIcon=false
 * 	downSkin=false
 * 	fillAlphas=false
 * 	fillColors=false
 * 	focusAlpha=false
 * 	focusRoundedCorners=false
 * 	fontAntiAliasType=false
 * 	fontFamily=false
 * 	fontGridFitType=false
 * 	fontSharpness=false
 * 	fontSize=false
 * 	fontStyle=false
 * 	fontThickness=false
 * 	fontWeight=false
 * 	highlightAlphas=false
 * 	horizontalGap=false
 * 	icon=false
 * 	leading=false
 * 	overIcon=false
 * 	overSkin=false
 * 	paddingBottom=false
 * 	paddingLeft=false
 * 	paddingRight=false
 * 	paddingTop=false
 * 	repeatDelay=false
 * 	repeatInterval=false
 * 	selectedDisabledIcon=false
 * 	selectedDisabledSkin=false
 * 	selectedDownIcon=false
 * 	selectedDownSkin=false
 * 	selectedOverIcon=false
 * 	selectedOverSkin=false
 * 	selectedUpIcon=false
 * 	selectedUpSkin=false
 * 	textAlign=false
 * 	textDecoration=false
 * 	textIndent=false
 * 	textRollOverColor=false
 * 	textSelectedColor=false
 * 	upIcon=false
 * 	upSkin=false
 * 	verticalGap=false
 * 	buttonDown=false
 * 	change=false
 * 	dataChange=false
 * 	
 * @author Ji Hoon Kim
 */
public abstract class MXMLButtonTemplate extends MXMLComponentBase {
	
	private static final String MXML_BUTTON_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLButtonTemplate.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_BUTTON_TEMPLATE_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLButtonTemplateReplaceMapping.xml";
	}
	
	public MXMLButtonTemplate(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLButtonTemplate.class, componentObj, MXML_BUTTON_TEMPLATE_REPLACE_MAPPING);
		
	}
	
}
