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
package com.googlecode.jsfFlex.validator.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes._MXMLUIAllowNegativeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDecimalPointCountErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDecimalSeparatorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDomainAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIExceedsMaxErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIntegerErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIInvalidCharErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIInvalidFormatCharsErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILowerThanMinErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIMaxValueAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIMinValueAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUINegativeErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPrecisionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPrecisionErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISeparationErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIThousandsSeparatorAttribute;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;

/**
 * One thing to note about MXML Formatter and Validator is that they are not actually converters or validators<br>
 * respectively but actually are components. This is so because they perform the formatting and validation<br>
 * as Flex components on the client side and not on the server side.<br>
 * 
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlNumberValidator",
        clazz               =   "com.googlecode.jsfFlex.validator.ext.MXMLUINumberValidator",
        type                =   "com.googlecode.jsfFlex.MXMLUINumberValidator",
        tagClass            =   "com.googlecode.jsfFlex.taglib.validator.ext.MXMLUINumberValidatorTag",
        family              =   "javax.faces.MXMLSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLNumberValidator"
)
public abstract class AbstractMXMLUINumberValidator 
						extends MXMLUISimpleBase 
						implements _MXMLUIValidatorAttributes, _MXMLUIAllowNegativeAttribute, _MXMLUIDecimalPointCountErrorAttribute, 
                        _MXMLUIDecimalSeparatorAttribute, _MXMLUIDomainAttribute, _MXMLUIExceedsMaxErrorAttribute, 
                        _MXMLUIIntegerErrorAttribute, _MXMLUIInvalidCharErrorAttribute, _MXMLUIInvalidFormatCharsErrorAttribute, 
                        _MXMLUILowerThanMinErrorAttribute, _MXMLUIMaxValueAttribute, _MXMLUIMinValueAttribute, 
                        _MXMLUINegativeErrorAttribute, _MXMLUIPrecisionAttribute, _MXMLUIPrecisionErrorAttribute, 
                        _MXMLUISeparationErrorAttribute, _MXMLUIThousandsSeparatorAttribute {
	
}
