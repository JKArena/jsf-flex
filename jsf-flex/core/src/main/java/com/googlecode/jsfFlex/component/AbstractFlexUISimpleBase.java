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
package com.googlecode.jsfFlex.component;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.json.JSONObject;

import com.googlecode.jsfFlex.renderkit.annotationDocletParser.AbstractAnnotationDocletParser;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;
import com.googlecode.jsfFlex.shared.context.AbstractFlexContext;
import com.googlecode.jsfFlex.shared.tasks.AbstractRunnerFactory;
import com.googlecode.jsfFlex.shared.util.FlexConstants;

/**
 * This component should be used as the base action of the component if the component<br>
 * does not require any preservation of values during the post-back phase [i.e. AbstractFlexUIVideoDisplay].<br>
 * 
 * @author Ji Hoon Kim
 */
@JSFComponent(
        type    =   "com.googlecode.jsfFlex.FlexUISimpleBase",
        family  =   "javax.faces.FlexUISimpleBase",
        desc    =   "Base component for FlexSimple components"
)
@FacesComponent("com.googlecode.jsfFlex.FlexUISimpleBase")
public abstract class AbstractFlexUISimpleBase extends UIComponentBase implements IFlexContract {
	
	private AbstractAnnotationDocletParser _annotationDocletParserInstance;
	
	private String _absolutePathToPreMxmlFile;
	private String _preMxmlIdentifier;
	private String _parentPreMxmlIdentifier;
	/*
	 * below two variables dictate the depth and the height of this component
	 * in reference to the top component which should be of FlexApplication. 
	 */
	private int _majorLevel = -1;
	private int _minorLevel = -1;

	public AbstractFlexUISimpleBase(){
		super();
	}
	
	public JSONObject getComponentInitValues(){
    	return null;
    }
    
    public String getNameSpaceOverride(){
        return null;
    }

	public synchronized AbstractAnnotationDocletParser getAnnotationDocletParserInstance(){
		
		if(_annotationDocletParserInstance == null){
			AbstractFlexContext flexContext = AbstractFlexContext.getCurrentInstance();
			AbstractRunnerFactory runnerFactoryInstance = flexContext.getRunnerFactoryInstance();
			_annotationDocletParserInstance = runnerFactoryInstance.getAnnotationDocletParserImpl();
		}
		
		return _annotationDocletParserInstance;
	}
	
    @Override
	public void encodeBegin(FacesContext context) throws IOException {
		
		AbstractFlexContext flexContext = AbstractFlexContext.getCurrentInstance();
		if(flexContext.isProductionEnv()){
			//means no need to create preMxml files
			setRendered(false);
		}
		
		super.encodeBegin(context);
	}
	
    @Override
	public void processDecodes(FacesContext context) {
		String mode = context.getExternalContext().getInitParameter(FlexConstants.CONFIG_MODE_NAME);
		if(mode == null || mode.equals(FlexConstants.PRODUCTION_MODE)){
			//need to dataBind so set back to true
			setRendered(true);
		}
		
		super.processDecodes(context);
	}
	
	public String getAbsolutePathToPreMxmlFile() {
		return _absolutePathToPreMxmlFile;
	}
	public void setAbsolutePathToPreMxmlFile(String absolutePathToPreMxmlFile) {
		_absolutePathToPreMxmlFile = absolutePathToPreMxmlFile;
	}
	public int getMajorLevel() {
		return _majorLevel;
	}
	public void setMajorLevel(int majorLevel) {
		_majorLevel = majorLevel;
	}
	public int getMinorLevel() {
		return _minorLevel;
	}
	public void setMinorLevel(int minorLevel) {
		_minorLevel = minorLevel;
	}
	public String getParentPreMxmlIdentifier() {
		return _parentPreMxmlIdentifier;
	}
	public void setParentPreMxmlIdentifier(String parentPreMxmlIdentifier) {
		_parentPreMxmlIdentifier = parentPreMxmlIdentifier;
	}
	public String getPreMxmlIdentifier() {
		return _preMxmlIdentifier;
	}
	public void setPreMxmlIdentifier(String preMxmlIdentifier) {
		_preMxmlIdentifier = preMxmlIdentifier;
	}
	
}
