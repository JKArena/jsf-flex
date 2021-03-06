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
package com.googlecode.jsfFlex.phaseListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Ji Hoon Kim
 */
public class JsfFlexHttpServicePhaseListener implements PhaseListener {
	
	private static final long serialVersionUID = -3131829162091907227L;
	
    private final static Log _log = LogFactory.getLog(JsfFlexHttpServicePhaseListener.class);
    
	private static final String JSF_FLEX_HTTP_SERVICE_REQUEST_LISTENER_URL = "/jsfFlexHttpServiceRequestListener/";
	private static final Pattern JSF_FLEX_HTTP_SERVICE_REQUEST_LISTENER_URL_PATTERN = Pattern.compile(JSF_FLEX_HTTP_SERVICE_REQUEST_LISTENER_URL);
	
	private static final String COMPONENT_ID = "componentId";
	private static final String METHOD_TO_INVOKE = "methodToInvoke";
	private static final String SERVLET_RETURN_METHOD = "servletReturnMethod";
	
    private static final String SERVLET_ARRAY_RESULT_FORMAT = "array";
	private static final String SERVLET_NAME_VALUE_RESULT_FORMAT = "nameValue";
    private static final String SERVLET_OBJECT_RESULT_FORMAT = "object";
	private static final String SERVLET_RAW_RESULT_FORMAT = "raw";
	private static final String SERVLET_XML_RESULT_FORMAT = "xml";
	
    private static final AbstractServiceRequestDataRetrieverFlusher ARRAY_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new ArrayServiceRequestDataRetrieverFlusher();
	private static final AbstractServiceRequestDataRetrieverFlusher NAME_VALUE_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new NameValueServiceRequestDataRetrieverFlusher();
    private static final AbstractServiceRequestDataRetrieverFlusher OBJECT_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new ObjectServiceRequestDataRetrieverFlusher();
	private static final AbstractServiceRequestDataRetrieverFlusher RAW_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new RawServiceRequestDataRetrieverFlusher();
	private static final AbstractServiceRequestDataRetrieverFlusher XML_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new XMLServiceRequestDataRetrieverFlusher();
	
    public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		HttpServletRequest request = HttpServletRequest.class.cast( context.getExternalContext().getRequest() );
		String urlPath = request.getRequestURI();
		
		Matcher jsfFlexHttpServiceRequestListenerUrlMatcher = JSF_FLEX_HTTP_SERVICE_REQUEST_LISTENER_URL_PATTERN.matcher( urlPath );
		boolean matchFound = jsfFlexHttpServiceRequestListenerUrlMatcher.find();
		if(matchFound){
			processServiceRequest(context);
		}
		
	}
	
	private void processServiceRequest(FacesContext context){
		
		String componentId = context.getExternalContext().getRequestParameterMap().get(COMPONENT_ID);
		String methodToInvoke = context.getExternalContext().getRequestParameterMap().get(METHOD_TO_INVOKE);
		String servletReturnMethod = context.getExternalContext().getRequestParameterMap().get(SERVLET_RETURN_METHOD);
		
        StringBuilder logMessage = new StringBuilder(getClass().getSimpleName());
        logMessage.append(" => processServiceRequest :  componentId, methodToInvoke, servletReturnMethod [ ");
        logMessage.append(componentId);
        logMessage.append(", ");
        logMessage.append(methodToInvoke);
        logMessage.append(", ");
        logMessage.append(servletReturnMethod);
        logMessage.append(" ] ");
        _log.info(logMessage.toString());
		AbstractServiceRequestDataRetrieverFlusher serviceRequestDataRetrieverFlusher = null;
		
        if(servletReturnMethod.equals(SERVLET_ARRAY_RESULT_FORMAT)){
            serviceRequestDataRetrieverFlusher = ARRAY_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
        }else if(servletReturnMethod.equals(SERVLET_NAME_VALUE_RESULT_FORMAT)){
			serviceRequestDataRetrieverFlusher = NAME_VALUE_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
		}else if(servletReturnMethod.equals(SERVLET_OBJECT_RESULT_FORMAT)){
            serviceRequestDataRetrieverFlusher = OBJECT_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
        }else if(servletReturnMethod.equals(SERVLET_RAW_RESULT_FORMAT)){
			serviceRequestDataRetrieverFlusher = RAW_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
		}else if(servletReturnMethod.equals(SERVLET_XML_RESULT_FORMAT)){
			serviceRequestDataRetrieverFlusher = XML_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
		}
		
		try{
			serviceRequestDataRetrieverFlusher.retrieveFlushData(context, componentId, methodToInvoke);
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			context.responseComplete();
		}
		
	}
	
	public void beforePhase(PhaseEvent event) {
		
	}
	
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
