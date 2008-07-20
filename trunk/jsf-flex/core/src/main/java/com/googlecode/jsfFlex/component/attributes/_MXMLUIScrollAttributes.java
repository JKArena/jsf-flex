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
 * 							 name		= "verticalScrollPolicy"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether the vertical scroll bar is always present, always absent, or automatically added when needed."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "verticalScrollPosition"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The current position of the vertical scroll bar."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "horizontalScrollPolicy"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether the horizontal scroll bar is always present, always absent, or automatically added when needed."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIScrollAttributes {
	
	/**
	 * Specifies whether the vertical scroll bar is always present, always absent, or automatically added when needed.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies whether the vertical scroll bar is always present, always absent, or automatically added when needed."
	 */
	String getVerticalScrollPolicy();

	/**
	 * The current position of the vertical scroll bar.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The current position of the vertical scroll bar."
	 */
	String getVerticalScrollPosition();

	/**
	 * Specifies whether the horizontal scroll bar is always present,always absent, or automatically added when needed.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies whether the horizontal scroll bar is always present,always absent, or automatically added when needed."
	 */
	String getHorizontalScrollPolicy();
	
}
