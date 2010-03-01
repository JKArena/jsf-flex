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
 
/**
 * TODO : implement it better later
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.event
{
	import flash.events.Event;
	import flash.external.ExternalInterface;
	import mx.core.UIComponent;
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory;
	
	public class DataUpdateEventHandler extends AbstractEventHandler {
		
		private static var _log:ILogger;
		
		private var _srcId:String;
		private var _tgtId:String;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataUpdateEventHandler);
		}
		
		public function DataUpdateEventHandler(srcId:String, tgtId:String, eventName:String, refApp:UIComponent) {
			super(refApp[srcId], eventName);
			
			/*
			 * srcId would be of the submit element and tgtId would be of the HTML form element
			 */
			_srcId = srcId;
			_tgtId = tgtId;
			activateListener();
		}
		
		override public function handleEvent(event:Event):void {
			_log.info("Executing a data update value request for component " + _tgtId);
			
		}
		
	}
	
}