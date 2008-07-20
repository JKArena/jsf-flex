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
package com.googlecode.jsfFlex.component.attributes;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "dropShadowEnabled"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Boolean property that specifies whether the component has a visible drop shadow."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "shadowDirection"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Direction of the drop shadow."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "shadowDistance"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Distance of the drop shadow."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIShadowAttributes {
	
	/**
	 * Boolean property that specifies whether the component has a visible drop shadow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Boolean property that specifies whether the component has a visible drop shadow."
	 */
	String getDropShadowEnabled();

	/**
	 * Direction of the drop shadow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Direction of the drop shadow."
	 */
	String getShadowDirection();

	/**
	 * Distance of the drop shadow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Distance of the drop shadow."
	 */
	String getShadowDistance();
	
}
