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
package com.googlecode.jsfFlex.framework.component.ext;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexComponentNodeAttribute;
import com.googlecode.jsfFlex.framework.component.MXMLComboBaseTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="DateField",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLDateField",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLDateField",
		mxmlComponentPackage="mx.controls",
		mxmlComponentName="DateField",
		componentNodeAttributes={
				@JsfFlexComponentNodeAttribute(
						htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						valueAttributeValue="text",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_text")
		},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="dayNames", byMethod=false),
				@JsfFlexAttribute(attribute="disabledDays", byMethod=false),
				@JsfFlexAttribute(attribute="disabledRanges", byMethod=false),
				@JsfFlexAttribute(attribute="displayedMonth", byMethod=false),
				@JsfFlexAttribute(attribute="displayedYear", byMethod=false),
				@JsfFlexAttribute(attribute="firstDayOfWeek", byMethod=false),
				@JsfFlexAttribute(attribute="formatString", byMethod=false),
				@JsfFlexAttribute(attribute="labelFunction", byMethod=false),
				@JsfFlexAttribute(attribute="maxYear", byMethod=false),
				@JsfFlexAttribute(attribute="minYear", byMethod=false),
				@JsfFlexAttribute(attribute="monthNames", byMethod=false),
				@JsfFlexAttribute(attribute="monthSymbol", byMethod=false),
				@JsfFlexAttribute(attribute="parseFunction", byMethod=false),
				@JsfFlexAttribute(attribute="selectableRange", byMethod=false),
				@JsfFlexAttribute(attribute="selectedDate", byMethod=false),
				@JsfFlexAttribute(attribute="showToday", byMethod=false),
				@JsfFlexAttribute(attribute="yearNavigationEnabled", byMethod=false),
				@JsfFlexAttribute(attribute="yearSymbol", byMethod=false),
				@JsfFlexAttribute(attribute="borderColor", byMethod=false),
				@JsfFlexAttribute(attribute="borderThickness", byMethod=false),
				@JsfFlexAttribute(attribute="color", byMethod=false),
				@JsfFlexAttribute(attribute="cornerRadius", byMethod=false),
				@JsfFlexAttribute(attribute="dateChooserStyleName", byMethod=false),
				@JsfFlexAttribute(attribute="disabledColor", byMethod=false),
				@JsfFlexAttribute(attribute="fillAlphas", byMethod=false),
				@JsfFlexAttribute(attribute="fillColors", byMethod=false),
				@JsfFlexAttribute(attribute="focusAlpha", byMethod=false),
				@JsfFlexAttribute(attribute="focusRoundedCorners", byMethod=false),
				@JsfFlexAttribute(attribute="fontAntiAliasType", byMethod=false),
				@JsfFlexAttribute(attribute="fontFamily", byMethod=false),
				@JsfFlexAttribute(attribute="fontGridFitType", byMethod=false),
				@JsfFlexAttribute(attribute="fontSharpness", byMethod=false),
				@JsfFlexAttribute(attribute="fontSize", byMethod=false),
				@JsfFlexAttribute(attribute="fontStyle", byMethod=false),
				@JsfFlexAttribute(attribute="fontThickness", byMethod=false),
				@JsfFlexAttribute(attribute="fontWeight", byMethod=false),
				@JsfFlexAttribute(attribute="headerColors", byMethod=false),
				@JsfFlexAttribute(attribute="headerStyleName", byMethod=false),
				@JsfFlexAttribute(attribute="highlightAlphas", byMethod=false),
				@JsfFlexAttribute(attribute="leading", byMethod=false),
				@JsfFlexAttribute(attribute="paddingLeft", byMethod=false),
				@JsfFlexAttribute(attribute="paddingRight", byMethod=false),
				@JsfFlexAttribute(attribute="rollOverColor", byMethod=false),
				@JsfFlexAttribute(attribute="selectionColor", byMethod=false),
				@JsfFlexAttribute(attribute="textAlign", byMethod=false),
				@JsfFlexAttribute(attribute="textDecoration", byMethod=false),
				@JsfFlexAttribute(attribute="textIndent", byMethod=false),
				@JsfFlexAttribute(attribute="todayColor", byMethod=false),
				@JsfFlexAttribute(attribute="todayStyleName", byMethod=false),
				@JsfFlexAttribute(attribute="weekDayStyleName", byMethod=false),
				@JsfFlexAttribute(attribute="change", byMethod=false),
				@JsfFlexAttribute(attribute="close", byMethod=false),
				@JsfFlexAttribute(attribute="dataChange", byMethod=false),
				@JsfFlexAttribute(attribute="open", byMethod=false),
				@JsfFlexAttribute(attribute="scroll", byMethod=false)
		}
)
public final class MXMLDateField extends MXMLComboBaseTemplate {
	
	public MXMLDateField(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLDateField.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		createPreMxml(componentMXML, MXMLDateField.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);

	}

}
