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
package com.googlecode.jsfFlex.component.attributes.compBase;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFJspProperties;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFJspProperty;

/**
 * @author Ji Hoon Kim
 */
@JSFJspProperties(
        properties={
                @JSFJspProperty(name="add", returnType="java.lang.String", longDesc="Dispatched when the component is added to a container as a content child by using the addChild() or addChildAt() method."),
                @JSFJspProperty(name="currentStateChange", returnType="java.lang.String", longDesc="Dispatched after the view state has changed."),
                @JSFJspProperty(name="currentStateChanging", returnType="java.lang.String", longDesc="Dispatched after the currentState property changes, but before the view state changes."),
                @JSFJspProperty(name="effectEnd", returnType="java.lang.String", longDesc="Dispatched after an effect ends."),
                @JSFJspProperty(name="effectStart", returnType="java.lang.String", longDesc="Dispatched just before an effect starts."),
                @JSFJspProperty(name="enterState", returnType="java.lang.String", longDesc="Dispatched after the component has returned to the root view state."),
                @JSFJspProperty(name="exitState", returnType="java.lang.String", longDesc="Dispatched before the component exits from the root view state."),
                @JSFJspProperty(name="hide", returnType="java.lang.String", longDesc="Dispatched when an object's state changes from visible to invisible."),
                @JSFJspProperty(name="initialize", returnType="java.lang.String", longDesc="Dispatched when the component has finished its construction and has all initialization properties set."),
                @JSFJspProperty(name="invalid", returnType="java.lang.String", longDesc="Dispatched when a component is monitored by a Validator and the validation failed."),
                @JSFJspProperty(name="mouseDownOutside", returnType="java.lang.String", longDesc="Dispatched from a component opened using the PopUpManager when the user clicks outside it."),
                @JSFJspProperty(name="mouseWheelOutside", returnType="java.lang.String", longDesc="Dispatched from a component opened using the PopUpManager when the user scrolls the mouse wheel outside it."),
                @JSFJspProperty(name="move", returnType="java.lang.String", longDesc="Dispatched when the object has moved."),
                @JSFJspProperty(name="preinitialize", returnType="java.lang.String", longDesc="Dispatched at the beginning of the component initialization sequence."),
                @JSFJspProperty(name="record", returnType="java.lang.String", longDesc="Record."),
                @JSFJspProperty(name="remove", returnType="java.lang.String", longDesc="Dispatched when the component is removed from a container as a content child by using the removeChild() or removeChildAt() method."),
                @JSFJspProperty(name="show", returnType="java.lang.String", longDesc="Dispatched when an object's state changes from invisible to visible."),
                @JSFJspProperty(name="resize", returnType="java.lang.String", longDesc="Dispatched when the component is resized."),
                @JSFJspProperty(name="toolTipCreate", returnType="java.lang.String", longDesc="Dispatched by the component when it is time to create a ToolTip."),
                @JSFJspProperty(name="toolTipEnd", returnType="java.lang.String", longDesc="Dispatched by the component when its ToolTip has been hidden and will be discarded soon."),
                @JSFJspProperty(name="toolTipHide", returnType="java.lang.String", longDesc="Dispatched by the component when its ToolTip is about to be hidden."),
                @JSFJspProperty(name="toolTipShow", returnType="java.lang.String", longDesc="Dispatched by the component when its ToolTip is about to be shown."),
                @JSFJspProperty(name="toolTipShown", returnType="java.lang.String", longDesc="Dispatched by the component when its ToolTip has been shown."),
                @JSFJspProperty(name="toolTipStart", returnType="java.lang.String", longDesc="Dispatched by a component whose toolTip property is set, as soon as the user moves the mouse over it."),
                @JSFJspProperty(name="updateComplete", returnType="java.lang.String", longDesc="Dispatched when an object has had its commitProperties(), measure(), and updateDisplayList() methods called (if needed)."),
                @JSFJspProperty(name="valid", returnType="java.lang.String", longDesc="Dispatched when a component is monitored by a Validator and the validation succeeded."),
                @JSFJspProperty(name="valueCommit", returnType="java.lang.String", longDesc="Dispatched when values are changed programmatically or by user interaction.")
        }
)
@JSFComponent
public interface _MXMLUIBaseEventsAttributes {
	
}
