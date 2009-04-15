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
 * 	columns=false
 * 	draggableColumns=false
 * 	editable=false
 * 	editedItemPosition=false
 * 	horizontalScrollPosition=false
 * 	imeMode=false
 * 	itemEditorInstance=false
 * 	minColumnWidth=false
 * 	resizableColumns=false
 * 	sortableColumns=false
 * 	backgroundDisabledColor=false
 * 	columnDropIndicatorSkin=false
 * 	columnResizeSkin=false
 * 	headerColors=false
 * 	headerDragProxyStyleName=false
 * 	headerSeparatorSkin=false
 * 	headerStyleName=false
 * 	horizontalGridLineColor=false
 * 	horizontalGridLines=false
 * 	rollOverColor=false
 * 	selectionColor=false
 * 	sortArrowSkin=false
 * 	stretchCursor=false
 * 	verticalGridLineColor=false
 * 	verticalGridLines=false
 * 	columnStretch=false
 * 	headerRelease=false
 * 	headerShift=false
 * 	itemEditBegin=false
 * 	itemEditEnd=false
 * 	itemFocusIn=false
 * 	itemFocusOut=false
 * 	
 * @author Ji Hoon Kim
 */
public abstract class MXMLDataGridTemplateRenderer extends MXMLDataGridBaseTemplateRenderer {
	
	private static final String MXML_DATA_GRID_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLDataGridTemplateRenderer.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_DATA_GRID_TEMPLATE_REPLACE_MAPPING = packageName + 
													"/replaceMapping/MXMLDataGridTemplateRendererReplaceMapping.xml";
	}
	
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractMXMLResponseWriter writer = (AbstractMXMLResponseWriter) context.getResponseWriter();
		writer.mapFields(MXMLDataGridTemplateRenderer.class, componentObj, MXML_DATA_GRID_TEMPLATE_REPLACE_MAPPING);
		
	}
	
}
