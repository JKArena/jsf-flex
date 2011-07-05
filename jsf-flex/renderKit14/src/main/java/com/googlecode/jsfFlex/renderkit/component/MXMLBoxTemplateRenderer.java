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
package com.googlecode.jsfFlex.renderkit.component;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.renderkit.mxml.AbstractMXMLResponseWriter;

/**
 * @JsfFlexAttributes
 * 	direction=false
 * 	horizontalAlign=false
 * 	horizontalGap=false
 * 	verticalAlign=false
 * 	verticalGap=false
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLBoxTemplateRenderer extends MXMLContainerTemplateRenderer {
	
	private static final String MXML_BOX_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLBoxTemplateRenderer.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_BOX_TEMPLATE_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLBoxTemplateRendererReplaceMapping.xml";
	}
	
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractMXMLResponseWriter writer = (AbstractMXMLResponseWriter) context.getResponseWriter();
		writer.mapFields(MXMLBoxTemplateRenderer.class, componentObj, MXML_BOX_TEMPLATE_REPLACE_MAPPING);
		
	}
	
}
