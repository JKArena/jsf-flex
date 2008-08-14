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
package com.googlecode.jsfFlex.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public class MXMLJsfUtil {
	
	private final static String WINDOWS_LINE_FEED = "\r\n";
	private final static String UNIX_LINE_FEED = "\n";
	
	private final static String LINE_FEED_ESCAPER = "LINE_FEED";
	
	private final static String ENCODING = "UTF-8";
	
	public static void setComponentProperties(UIComponent component, FacesContext context){
    	//set the major level, minor level, and absolutePathToPreMxmlFile
    	UIComponent parent = component.getParent();
    	_MXMLContract currMXMLComp = (_MXMLContract) component;
    	
    	if(parent == null){
    		//this should never happen
    		throw new NullPointerException("Component " + component.getClass().getName() + 
    											" lacks parent component");
    	}
    	//set the name for absolutePathToPreMxmlFile
    	MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
    	
    	String _idCheck = component.getId();
    	if(component.getAttributes().get("id") == null){
    		//sanity check for replaceMapping
    		component.getAttributes().put("id", _idCheck);
    	}
    	
    	if(!(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication) && currMXMLComp.getComponentValues() != null){
	    	Map applicationIdValueMap = mxmlContext.getApplicationIdValueMap();
	    	applicationIdValueMap.put(_idCheck, currMXMLComp.getComponentValues());
    	}
    	
    	if(mxmlContext.isProductionEnv() || mxmlContext.isSimplySWF()){
    		//do not need to create preMXML files
    		return;
    	}
    	
    	if(parent instanceof _MXMLContract && !(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication)){
    		_MXMLContract mxmlInstance = (_MXMLContract) parent;
    		int tempInt = mxmlInstance.getMajorLevel();
    		currMXMLComp.setMajorLevel(++tempInt);
    		
			//now set the minor level
        	List childrenList = parent.getChildren();
        	Iterator iterate = childrenList.iterator();
        	UIComponent currComp;
        	int counter = 0;
        	
        	while(iterate.hasNext()){
        		//get the component's position within structure
        		currComp = (UIComponent) iterate.next();
        		if(currComp.equals(component)){
        			//got the component's position
        			break;
        		}
        		if(currComp instanceof _MXMLContract){
        			counter++;
        		}
        	}
        	
        	currMXMLComp.setMinorLevel(counter);
        	setPreMxmlIdentifiers(mxmlInstance, currMXMLComp);
    		
    	}else if(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication){
    		//means that it is not of MXML component, so set the major and minor level to 0
    		currMXMLComp.setMajorLevel(0);
    		currMXMLComp.setMinorLevel(0);
    		setPreMxmlIdentifiers(null, currMXMLComp);
    		
    	}else{
    		throw new ComponentBuildException("Failed to meet the condition of either being a top component of " +
    												"MXMLUIApplication or having a parent as implementation of " +
    												"MXMLContract");
    	}
    	
    	setAbsolutePathToPreMxmlFile(mxmlContext.getCurrMxml(), currMXMLComp, mxmlContext.getPreMxmlPath());
    	
    }
	
	private static void setPreMxmlIdentifiers(_MXMLContract parentInstance, _MXMLContract currInstance){
		//TODO : implement this whole process better later
		StringBuffer parentPreMxmlIdentifier = new StringBuffer();
		StringBuffer preMxmlIdentifier = new StringBuffer();
		
		if(parentInstance != null){
			parentPreMxmlIdentifier.append(parentInstance.getPreMxmlIdentifier());
			
			preMxmlIdentifier.append(parentInstance.getPreMxmlIdentifier());
			preMxmlIdentifier.append(currInstance.getMajorLevel());
			preMxmlIdentifier.append(currInstance.getMinorLevel());
		}else{
			//currInstance is an instance of MXMLUIApplication
			preMxmlIdentifier.append(currInstance.getMajorLevel());
			preMxmlIdentifier.append(currInstance.getMinorLevel());
		}
		
		currInstance.setParentPreMxmlIdentifier(parentPreMxmlIdentifier.toString());
		currInstance.setPreMxmlIdentifier(preMxmlIdentifier.toString());
	}
	
	private static void setAbsolutePathToPreMxmlFile(String mxmlPackageName, _MXMLContract currInstance, String preMxmlPath){
		StringBuffer toReturn = new StringBuffer(preMxmlPath);
		toReturn.append(mxmlPackageName);
		toReturn.append("_");
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(MXMLConstants.PRE_MXML_FILE_EXT);
		
		currInstance.setAbsolutePathToPreMxmlFile(toReturn.toString());
		
	}
	
	public static String escapeCharacters(String toEscape){
		if(toEscape == null){
			return null;
		}
		//TODO : implement this better
		try{
			/*
			 * special case for line feeds, since otherwise it is replaced with two
			 * line feeds on the flash side
			 */
			toEscape = toEscape.replaceAll(WINDOWS_LINE_FEED, LINE_FEED_ESCAPER);
			toEscape = toEscape.replaceAll(UNIX_LINE_FEED, LINE_FEED_ESCAPER);
			return java.net.URLEncoder.encode(toEscape, ENCODING);
		}catch(java.io.UnsupportedEncodingException unsupportedEncodingExcept){
			throw new ComponentBuildException("UnsupportedEncoding of " + ENCODING + ", in another words this " +
												"shouldn't happen", unsupportedEncodingExcept);
		}
		
	}
	
}