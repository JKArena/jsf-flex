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
package com.googlecode.jsfFlexPlugIn.inspector;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ji Hoon Kim
 */
public abstract class _JsfFlexInspectorBase {
	
	private String _dirPath;
	private List<_JsfFlexInspectListener> _jsfFlexInspectListeners;
	
	public _JsfFlexInspectorBase(){
		super();
	}
	
	public _JsfFlexInspectorBase(String dirPath){
		super();
		_dirPath = dirPath;
	}
	
	{
		_jsfFlexInspectListeners = new LinkedList<_JsfFlexInspectListener>();
	}
	
	protected String getDirPath(){
		return _dirPath;
	}
	
	public synchronized void addInspectListener(_JsfFlexInspectListener _callBack){
		_jsfFlexInspectListeners.add(_callBack);
	}
	
	protected synchronized void inspectFileFinished(Map _inspectedMap, String _inspectedFileName, String _inspectedPackage){
		_JsfFlexInspectListener _inspectedCallBack;
		for(Iterator _jsfFlexQdoxInspectIterator = _jsfFlexInspectListeners.iterator(); _jsfFlexQdoxInspectIterator.hasNext();){
			_inspectedCallBack = (_JsfFlexInspectListener) _jsfFlexQdoxInspectIterator.next();
			_inspectedCallBack.inspectFileFinished(_inspectedMap, _inspectedFileName, _inspectedPackage);
		}
	}
	
	protected synchronized void inspectionCompleted(String _pattern, List<String> _parameters){
		_JsfFlexInspectListener _inspectedCallBack;
		for(Iterator _jsfFlexQdoxInspectIterator = _jsfFlexInspectListeners.iterator(); _jsfFlexQdoxInspectIterator.hasNext();){
			_inspectedCallBack = (_JsfFlexInspectListener) _jsfFlexQdoxInspectIterator.next();
			_inspectedCallBack.inspectionCompleted(_pattern, _parameters);
		}
	}
	
	public abstract void inspectFiles(String _pattern, List<String> _parameters);
	
}