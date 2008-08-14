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
package com.googlecode.jsfFlex.renderkit;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import com.googlecode.jsfFlex.framework.MXMLComponentBuilder;
import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public class MXMLRendererBase extends Renderer{
	
	protected MXMLComponentBuilder _mxmlCompBuilder;
	
	private static Comparator _majorKeyComparator = new Comparator(){
														public int compare(Object obj1, Object obj2){
															_MXMLContract actObj1 = (_MXMLContract) obj1;
															_MXMLContract actObj2 = (_MXMLContract) obj2;
															double actObj1Double = Double.valueOf(actObj1.getPreMxmlIdentifier()).doubleValue();
															double actObj2Double = Double.valueOf(actObj2.getPreMxmlIdentifier()).doubleValue();
															return actObj1Double == actObj2Double ? 0 : actObj1Double < actObj2Double ? -1 : 1;
														}
													};
	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		super.encodeBegin(context, component);
		
		_MXMLContract mxmlUIComp = (_MXMLContract) component;
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		if(mxmlContext.isProductionEnv() || mxmlContext.isSimplySWF()){
			return;
		}
		
		if(!(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication)){
			/*
			 * Ignore the addition of MXMLUIApplication, because MXMLApplication is responsible
			 * for traversing through the Set and creating the mxml and swf files.
			 */
			Map preMxmlCompMap = mxmlContext.getPreMxmlCompMap();
			
			Integer majorKey = new Integer(mxmlUIComp.getMajorLevel());
			Object majorKeyEntry = preMxmlCompMap.get(majorKey);

			Set majorKeySet;
			if(majorKeyEntry != null){
				majorKeySet = (Set) majorKeyEntry;

			}else{
				
				majorKeySet = new TreeSet( _majorKeyComparator );
				preMxmlCompMap.put(majorKey, majorKeySet);

			}
			
			majorKeySet.add(mxmlUIComp);
			
		}
		
		_mxmlCompBuilder = new MXMLComponentBuilder(component, mxmlUIComp.getFamily(), mxmlUIComp.getMXMLComponentRenderer());
		
		_mxmlCompBuilder.loadClass();
		_mxmlCompBuilder.buildComponentBegin();
		_mxmlCompBuilder.buildComponentInterlude();
		
	}
	
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		super.encodeChildren(context, component);
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		if(mxmlContext.isProductionEnv() || mxmlContext.isSimplySWF()){
			return;
		}
		
		_mxmlCompBuilder.buildComponentChildren();
		
	}
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		super.encodeEnd(context, component);
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		
		if(mxmlContext.isProductionEnv()){
			return;
		}
		
		if(mxmlContext.isSimplySWF()){
			
			if(!(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication)){
				return;
			}
			
			_MXMLContract mxmlUIComp = (_MXMLContract) component;
			_mxmlCompBuilder = new MXMLComponentBuilder(component, mxmlUIComp.getFamily(), mxmlUIComp.getMXMLComponentRenderer());
			
			_mxmlCompBuilder.loadClass();
			
		}
		_mxmlCompBuilder.buildComponentEnd();
	}
	
}