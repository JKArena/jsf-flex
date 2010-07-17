<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jsf-flex.googlecode.com" prefix="jf"%>

<html>

<!--
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
//-->
<head>
<style type="text/css">
#descriptionStyle{
    color:#708090;
    font-family:verdana;
    font-size:11px;
    font-weight:700;
}

.errorStyle{
    color:#ff6666;
    font-family:verdana;
    font-size:11px;
    font-weight:700;
}
</style>
</head>
<body>

<f:view renderKitId="FLEX_BASIC">
	
	<h:form>
		<div>
    	The button on the right is to test out the decode process and make sure that the information is mapped correctly.
    	<h:commandButton value="DecodeTester" action="success" /> <br/>
    	Also there exists a button  and a linkButton within flexApplication that will also perform a submission.
    	</div>
    	
        <div id="descriptionStyle">
            Note that the client validation for the component with id textInputRef [namely flexNumberValidator] is not a child tag
            of the flexTextInput tag. <br/>However the regular validation tag [validateLongRange] is a child tag which performs the validation
            on the server side.
            <br />
            <h:message for="textAreaRef" errorClass="errorStyle" />
        </div>
        <br />
        
	    <jf:flexApplication mxmlPackageName="flexOverallExample" errorColor="#B80000" errorFontSize="13">
	    	<jf:flexAttributeNode name="height" value="780"/>
    		<jf:flexAttributeNode name="width" value="90%"/>
    		
	    	<jf:flexLabel>
	    		<jf:flexAttributeNode name="text" value="Following label contains korean text to demonstrate locale [if browser's language is set to korean]"/>
	    		<jf:flexAttributeNode name="color" value="#FFFFFF"/>
	    		<jf:flexAttributeNode name="fontWeight" value="bold"/>
	    	</jf:flexLabel>
	    	
	    	<jf:flexLabel>
	    		<jf:flexAttributeNode name="text" value="@Resource(bundle='LocaleExample', key='greeting')"/>
	    		<jf:flexAttributeNode name="color" value="#FFFFFF"/>
	    		<jf:flexAttributeNode name="fontWeight" value="bold"/>
	    		<jf:flexAttributeNode name="fontSize" value="14"/>
	    	</jf:flexLabel>
	    	
	        <jf:flexScript>
	        	import flash.events.Event;
	        	
		    	import mx.collections.XMLListCollection;
		    	import mx.controls.Alert;
		    	import mx.controls.Menu;
		    	import mx.controls.PopUpButton;
		    	import mx.events.MenuEvent;
		    	
		    	private function alertMe():void {
		    		Alert.show("Uhm, I have been alerted");
		    	}
		    	
		    	private var myMenu:Menu;
		    	private var popUpButton:PopUpButton;
				
				private function initMenu(event:Event):void {
	                myMenu = new Menu();
	                var dp:Object = [{label: "New Folder"}, {label: "Sent Items"}, {label: "Inbox"}];        
	                myMenu.dataProvider = dp;
	                myMenu.selectedIndex = 0;
	                myMenu.addEventListener("itemClick", itemClickHandler);
	                popUpButton = event.target as PopUpButton;
	                popUpButton.popUp = myMenu;
	                popUpButton.label = "Put in: " + myMenu.dataProvider[myMenu.selectedIndex].label;
	            }
	            
	            private function itemClickHandler(event:MenuEvent):void {
	                var label:String = event.item.label;        
	                popUpButton.label = "Put in: " + label;
	                popUpButton.close();
	                myMenu.selectedIndex = event.index;
	            }
		    	
		    	[Bindable]
				public var reallySimpleArray:Array = ["First", "Second", "Third"];
				
				public var complexStruct:XMLList = <root>
														<menuitem label="Menu1">
									                        <menuitem label="MenuItem 1-A" data="1A"/>
									                        <menuitem label="MenuItem 1-B" data="1B"/>
									                    </menuitem>
									                    <menuitem label="Menu2">
									                        <menuitem label="MenuItem 2-A" type="check"  data="2A"/>
									                        <menuitem type="separator" />
									                        <menuitem label="MenuItem 2-B" >
									                            <menuitem label="SubMenuItem 3-A" type="radio"
									                                groupName="one" data="3A"/>
									                            <menuitem label="SubMenuItem 3-B" type="radio"
									                                groupName="one" data="3B"/>
									                        </menuitem>
									                    </menuitem>
													</root>.menuitem;
				[Bindable]
				public var complexStructCollection:XMLListCollection = new XMLListCollection(complexStruct);
				
				private function increaseProgressBar():void{
					progressBarRef.setProgress((progressBarRef.value + 10) % 110, 100);
				}
				
				private function decreaseProgressBar():void{
					progressBarRef.setProgress(progressBarRef.value == 0 ? 0 : progressBarRef.value - 10, 100);
				}
				
		    </jf:flexScript>
		    <!-- Validation on the client side -->
		    <jf:flexNumberValidator>
		    	<jf:flexAttributeNode name="exceedsMaxError" value="The number provided exceeds max value [60]."/>
	    		<jf:flexAttributeNode name="property" value="text"/>
	    		<jf:flexAttributeNode name="domain" value="int"/>
	    		<jf:flexAttributeNode name="integerError" value="Must be an integer value."/>
	    		<jf:flexAttributeNode name="lowerThanMinError" value="The number provided is lower than min value [10]."/>
	    		<jf:flexAttributeNode name="maxValue" value="60"/>
	    		<jf:flexAttributeNode name="minValue" value="10"/>
	    		<jf:flexAttributeNode name="required" value="true"/>
	    		<jf:flexAttributeNode name="source" value="{textInputRef}"/>
			</jf:flexNumberValidator>
			
			<jf:flexAccordion selectedIndex="#{flexOverallBean.accordionSelectedIndex}">
			    <jf:flexAttributeNode name="width" value="100%"/>
	    		<jf:flexAttributeNode name="height" value="100%"/>
	    		
				<jf:flexTabNavigator selectedIndex="#{flexOverallBean.tabNavigatorSelectedIndex}">
					<jf:flexAttributeNode name="width" value="100%"/>
		    		<jf:flexAttributeNode name="height" value="100%"/>
					
		    		<jf:flexPanel nameSpaceOverride="mx">
		    			<jf:flexAttributeNode name="width" value="100%"/>
			    		<jf:flexAttributeNode name="height" value="100%"/>
		    			<jf:flexAttributeNode name="label" value="First Tab"/>
		    			
		    			<jf:flexDividedBox>
		    				<jf:flexAttributeNode name="width" value="100%"/>
				    		<jf:flexAttributeNode name="height" value="100%"/>
			    			<jf:flexAttributeNode name="direction" value="horizontal"/>
		    				
			    			<jf:flexBox>
			    				<jf:flexAttributeNode name="width" value="30%"/>
				    			<jf:flexAttributeNode name="height" value="100%"/>
				    			
				    			<jf:flexTextInput id="textInputRef" text="#{flexOverallBean.textInputText}" />
				    			<jf:flexRichTextEditor textBinding="htmlText" htmlText="#{flexOverallBean.richTextEditorHtmlText}" />
						    	
						    	<jf:flexDateField text="#{flexOverallBean.dateFieldText}">
						    		<jf:flexAttributeNode name="width" value="100"/>
						    	</jf:flexDateField>
						    	
						    	<jf:flexColorPicker selectedColor="#{flexOverallBean.colorPickerSelectedColor}">
						       		<jf:flexAttributeNode name="labelField" value="ColorPicker am I"/>
						       	</jf:flexColorPicker>
						       	<jf:flexDateChooser selectedDate="#{flexFaceletOverallBean.selectedDate}">
						       		<jf:flexAttributeNode name="width" value="300"/>
						       	</jf:flexDateChooser>
					    	</jf:flexBox>
					    	
					    	<jf:flexBox>
					    		<jf:flexAttributeNode name="width" value="70%"/>
					    		<jf:flexAttributeNode name="height" value="100%"/>
					    		
					    		<jf:flexDataGrid bindingBeanList="#{flexOverallBean.wisePeopleEntries}" rowCount="4" editable="true">
					    			<jf:flexAttributeNode name="width" value="100%"/>
						    		<jf:flexAttributeNode name="resizableColumns" value="true"/>
					    			
							    	<jf:flexColumns>
							    		<jf:flexDataGridColumn dataField="name">
							    			<jf:flexAttributeNode name="headerText" value="Name"/>
							    		</jf:flexDataGridColumn>
							    		<jf:flexDataGridColumn dataField="quote">
							    			<jf:flexAttributeNode name="wordWrap" value="true"/>
							    			<jf:flexAttributeNode name="headerText" value="Quote"/>
							    			<jf:flexAttributeNode name="minWidth" value="170"/>
							    		</jf:flexDataGridColumn>
							    		<jf:flexDataGridColumn dataField="email">
							    			<jf:flexAttributeNode name="headerText" value="Email"/>
							    		</jf:flexDataGridColumn>
							    	</jf:flexColumns>
							    </jf:flexDataGrid>
						   </jf:flexBox>
				    	
				    	</jf:flexDividedBox>
				    </jf:flexPanel>
		    			
		    		<jf:flexPanel>
		    			<jf:flexAttributeNode name="width" value="100%"/>
			    		<jf:flexAttributeNode name="height" value="100%"/>
		    			<jf:flexAttributeNode name="label" value="Second Tab"/>
		    			
		    			<jf:flexGroup>
					    	<jf:flexComboBox text="#{flexOverallBean.comboBoxText}" selectedIndex="#{flexOverallBean.comboBoxSelectedIndex}" 
					    							dataProviderCollection="#{flexOverallBean.comboBoxDisplayEntries}" />
					    	<jf:flexRadioButton groupName="radioTest" value="First" 
					    							selectedValue="#{flexOverallBean.radioButtonSelectedValue}" selected="#{flexOverallBean.radioButtonFirstSelected}">
								<jf:flexAttributeNode name="label" value="First"/>
							</jf:flexRadioButton>
					       	<jf:flexRadioButton groupName="radioTest" value="Second" selected="#{flexOverallBean.radioButtonSecondSelected}">
								<jf:flexAttributeNode name="label" value="Second"/>
					       	</jf:flexRadioButton>
					       	
					       	<jf:flexNumericStepper value="#{flexOverallBean.numericStepperValue}">
					       		<jf:flexAttributeNode name="minimum" value="0"/>
					       		<jf:flexAttributeNode name="maximum" value="10"/>
					       	</jf:flexNumericStepper>
					       	
					       	<jf:flexCheckBox selected="#{flexOverallBean.checkBoxSelected}">
								<jf:flexAttributeNode name="label" value="CheckBox am I [\^$.|?*+(){}"/>
							</jf:flexCheckBox>
							
							<jf:flexTextArea id="textAreaRef" text="#{flexOverallBean.textAreaText}" >
								
								<f:validateLongRange minimum="10" maximum="60" />
							</jf:flexTextArea>
						</jf:flexGroup>
		    		</jf:flexPanel>
					
			    </jf:flexTabNavigator>
			            	
	    	   	<jf:flexPanel nameSpaceOverride="mx">
					<jf:flexAttributeNode name="width" value="100%"/>
	    			<jf:flexAttributeNode name="height" value="100%"/>
					
				    <jf:flexDividedBox>
				    	<jf:flexAttributeNode name="width" value="100%"/>
		    			<jf:flexAttributeNode name="height" value="100%"/>
						<jf:flexAttributeNode name="direction" value="horizontal"/>
						
						<jf:flexBox>
							<jf:flexAttributeNode name="width" value="50%"/>
				    		<jf:flexAttributeNode name="height" value="100%"/>
				    		
		    				<jf:flexLinkButton action="success">
		    					<jf:flexAttributeNode name="label" value="To Submit"/>
		    				</jf:flexLinkButton>
			    			
							<jf:flexButton>
								<jf:flexAttributeNode name="label" value="Click Me for a nice message"/>
								<jf:flexAttributeNode name="buttonDown" value="alertMe();"/>
							</jf:flexButton>
							
							<jf:flexButton action="#{flexOverallBean.buttonAction}">
								<jf:flexAttributeNode name="label" value="Will submit the form"/>
							</jf:flexButton>
							
					        <jf:flexLabel>
				    	    	<jf:flexAttributeNode name="text" value="Simple List"/>
				        	</jf:flexLabel>
					        
					        <jf:flexList selectedIndex="#{flexOverallBean.listSelectedIndex}">
					        	<jf:flexAttributeNode name="width" value="100"/>
					        	<jf:flexAttributeNode name="dataProvider" value="{reallySimpleArray}"/>
					        </jf:flexList>
				    	    
				        	<jf:flexTree selectedIndex="#{flexOverallBean.treeSelectedIndex}">
					        	<jf:flexAttributeNode name="width" value="100"/>
					        	<jf:flexAttributeNode name="dataProvider" value="{complexStructCollection}"/>
					        	<jf:flexAttributeNode name="labelField" value="@label"/>
					        </jf:flexTree>
						</jf:flexBox>
						
				        <jf:flexBox>
				        	<jf:flexAttributeNode name="width" value="50%"/>
				        	<jf:flexAttributeNode name="height" value="100%"/>
				        	
							<jf:flexLabel>
								<jf:flexAttributeNode name="text" value="Simple ButtonBar"/>
							</jf:flexLabel>
							<jf:flexButtonBar>
					        	<jf:flexDataProvider>
	        	                	<jf:flexObject>
	            	                	<jf:flexObjectStaticProperty staticPropertyName="label" staticPropertyValue="First Nesting" />
	                	            </jf:flexObject>
	                    	        <jf:flexObject>
	                        	        <jf:flexObjectStaticProperty staticPropertyName="label" staticPropertyValue="Second Nesting" />
		                            </jf:flexObject>
								</jf:flexDataProvider>
							</jf:flexButtonBar>
					        <jf:flexLabel>
					        	<jf:flexAttributeNode name="text" value="Simple ToggleButtonBar"/>
				    	    </jf:flexLabel>
					        <jf:flexToggleButtonBar>
					        	<jf:flexAttributeNode name="dataProvider" value="{reallySimpleArray}"/>
					        </jf:flexToggleButtonBar>
							
					        <jf:flexLabel>
				    	    	<jf:flexAttributeNode name="text" value="Simple TabBar"/>
					        </jf:flexLabel>
							<jf:flexTabBar>
								<jf:flexAttributeNode name="dataProvider" value="{reallySimpleArray}"/>
							</jf:flexTabBar>
					        <jf:flexLabel>
				    	    	<jf:flexAttributeNode name="text" value="Simple LinkBar"/>
				        	</jf:flexLabel>
					        <jf:flexLinkBar>
					        	<jf:flexAttributeNode name="dataProvider" value="{reallySimpleArray}"/>
					        </jf:flexLinkBar>
						</jf:flexBox>
						
					</jf:flexDividedBox>
					
				</jf:flexPanel>
				
				<jf:flexBox>
					<jf:flexAttributeNode name="width" value="100%"/>
	        		<jf:flexAttributeNode name="height" value="100%"/>
	        		
					<jf:flexBox>
						<jf:flexAttributeNode name="width" value="100%"/>
	    	    		<jf:flexAttributeNode name="height" value="40%"/>
	        			
						<jf:flexLabel>
							<jf:flexAttributeNode name="text" value="Simple VScrollBar"/>
						</jf:flexLabel>
						
						<jf:flexVScrollBar />
						<jf:flexSpacer>
							<jf:flexAttributeNode name="height" value="10"/>
						</jf:flexSpacer>
						
						<jf:flexLabel>
							<jf:flexAttributeNode name="text" value="Simple HScrollBar"/>
						</jf:flexLabel>
						
						<jf:flexHScrollBar />
						
						<jf:flexSpacer>
							<jf:flexAttributeNode name="height" value="20"/>
						</jf:flexSpacer>
						<jf:flexHRule>
							<jf:flexAttributeNode name="width" value="100%"/>
						</jf:flexHRule>
						<jf:flexSpacer>
							<jf:flexAttributeNode name="height" value="20"/>
						</jf:flexSpacer>
						
						<jf:flexLabel>
							<jf:flexAttributeNode name="text" value="Simple HSlider"/>
						</jf:flexLabel>
						<jf:flexHSlider value="#{flexOverallBean.horizontalSliderValue}" />
						<jf:flexSpacer>
							<jf:flexAttributeNode name="height" value="10"/>
						</jf:flexSpacer>
						
						<jf:flexLabel>
							<jf:flexAttributeNode name="text" value="Simple VSlider"/>
						</jf:flexLabel>
						<jf:flexVSlider value="#{flexOverallBean.verticalSliderValue}" />
						
					</jf:flexBox>
					
					<jf:flexTitleWindow>
						<jf:flexAttributeNode name="title" value="Title Window"/>
						<jf:flexAttributeNode name="x" value="168"/>
						<jf:flexAttributeNode name="y" value="86"/>
						<jf:flexAttributeNode name="borderStyle" value="inset"/>
						
					    <jf:flexTile>
							<jf:flexButton>
								<jf:flexAttributeNode name="label" value="Increase Progress Bar"/>
								<jf:flexAttributeNode name="buttonDown" value="increaseProgressBar();"/>
							</jf:flexButton>
						    <jf:flexButton>
						    	<jf:flexAttributeNode name="label" value="Decrease Progress Bar"/>
								<jf:flexAttributeNode name="buttonDown" value="decreaseProgressBar();"/>
						    </jf:flexButton>
					    </jf:flexTile>
						
						<jf:flexProgressBar id="progressBarRef" value="#{flexOverallBean.progressBarValue}">
							
							<jf:flexAttributeNode name="mode" value="manual"/>
							<jf:flexAttributeNode name="minimum" value="0"/>
							<jf:flexAttributeNode name="maximum" value="100"/>
						</jf:flexProgressBar>
						
					</jf:flexTitleWindow>
					
				</jf:flexBox>
				
			</jf:flexAccordion>
			
			<jf:flexApplicationControlBar>
				<jf:flexAttributeNode name="dock" value="true"/>
				
				<jf:flexMenuBar>
					<jf:flexAttributeNode name="dataProvider" value="{complexStructCollection}"/>
					<jf:flexAttributeNode name="labelField" value="@label"/>
				</jf:flexMenuBar>
				<jf:flexPopUpButton>
					<jf:flexAttributeNode name="creationComplete" value="initMenu(event);"/>
					<jf:flexAttributeNode name="width" value="135"/>
				</jf:flexPopUpButton>
				<jf:flexPopUpMenuButton>
					<jf:flexAttributeNode name="dataProvider" value="{complexStructCollection}"/>
					<jf:flexAttributeNode name="labelField" value="@label"/>
				</jf:flexPopUpMenuButton>
			</jf:flexApplicationControlBar>
			
		</jf:flexApplication>
    
    </h:form>
</f:view>

</body>

</html>
