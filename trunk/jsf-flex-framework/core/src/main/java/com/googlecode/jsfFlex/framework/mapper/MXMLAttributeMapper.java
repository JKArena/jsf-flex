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
package com.googlecode.jsfFlex.framework.mapper;

import java.util.Map;

import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public class MXMLAttributeMapper implements _MXMLMapper {
	
	private static MXMLAttributeMapper _instance;
	
	private MXMLAttributeMapper(){
		super();
	}
	
	public static synchronized _MXMLMapper getInstance(){
		if(_instance == null){
			_instance = new MXMLAttributeMapper();
		}
		return _instance;
	}
	
	public TokenValue mapField(String tokenName, Object componentObj) {
		//this class must have Object passed in as a MXMLContract
		_MXMLContract comp = (_MXMLContract) componentObj;
		Map attributeMap = comp.getAttributes();
		Object obj;
		
		if(attributeMap != null && (obj = attributeMap.get(tokenName)) != null){
			return new TokenValue(tokenName, obj.toString());
		}
		
		return null;
	}
	
}