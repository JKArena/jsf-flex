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
package com.googlecode.jsfFlex.renderkit.component.ext.service.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFRenderer;

import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.component.AbstractFlexComponentBaseRenderer;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;

/**
 * @author Ji Hoon Kim
 */
@JSFRenderer(
		renderKitId="FLEX_BASIC",
		family="javax.faces.FlexSimple",
		type="com.googlecode.jsfFlex.FlexHTTPService"
)
@IJsfFlexAttributeProperties(
		componentName="HTTPService",
		componentNodeAttributes={},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="concurrency"),
				@IJsfFlexAttribute(attribute="contentType"),
				@IJsfFlexAttribute(attribute="destination"),
				@IJsfFlexAttribute(attribute="id", byMethod=true),
				@IJsfFlexAttribute(attribute="method"),
				@IJsfFlexAttribute(attribute="resultFormat"),
				@IJsfFlexAttribute(attribute="showBusyCursor"),
				@IJsfFlexAttribute(attribute="makeObjectsBindable"),
				@IJsfFlexAttribute(attribute="url"),
				@IJsfFlexAttribute(attribute="useProxy"),
				@IJsfFlexAttribute(attribute="xmlEncode"),
				@IJsfFlexAttribute(attribute="xmlDecode"),
				@IJsfFlexAttribute(attribute="fault"),
				@IJsfFlexAttribute(attribute="result")
		}
)
public final class FlexHTTPServiceRenderer extends AbstractFlexComponentBaseRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
        IFlexContract componentFlex = IFlexContract.class.cast( componentObj );
        
        AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(FlexHTTPServiceRenderer.class, componentObj, null);
		writer.createPreMxml(componentFlex, FlexHTTPServiceRenderer.class.getAnnotation(IJsfFlexAttributeProperties.class), 
				null);
		
	}
	
}
