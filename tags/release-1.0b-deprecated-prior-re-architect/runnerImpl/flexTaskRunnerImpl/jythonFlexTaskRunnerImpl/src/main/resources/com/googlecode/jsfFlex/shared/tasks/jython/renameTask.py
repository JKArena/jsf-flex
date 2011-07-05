"""
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
 * A very simple implementation of renaming a file
 * TODO: Implement it better later
 *
 * @author Ji Hoon Kim
 */
"""

from com.googlecode.jsfFlex.shared.tasks.jython import _JythonTaskPerformer

import os
import os.path

class RenameTask(_JythonTaskPerformer):
	def __init__(self, sourceFile, destFile, overWrite):
		self.sourceFile = sourceFile
		self.destFile = destFile
		self.overWrite = overWrite
		
	def performTask(self):
		if self.overWrite:
			if os.path.exists(self.destFile) :
				os.remove(self.destFile)
		
		os.rename(self.sourceFile, self.destFile)
	
	def __str__(self):
		print self.sourceFile, self.destFile, self.overWrite
	def __retr__(self):
		self.__str__(self)