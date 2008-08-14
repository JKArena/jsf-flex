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
package com.googlecode.jsfFlex.framework.tasks.task.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Move;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task._Task;

/**
 * @author Ji Hoon Kim
 */
public class RenameTask extends Ant_BaseTask implements _Task {
	
	private static final String RENAME_TARGET = "rename";
	
	private Move _renameTask;
	private Target _renameTarget;
	
	private String _sourceFile;
	private String _destFile;
	private boolean _overwrite;
	
	public RenameTask(){
		super();
	}
	
	public RenameTask(String sourceFile, String destFile, boolean overwrite){
		super();
		_sourceFile = sourceFile;
		_destFile = destFile;
		_overwrite = overwrite;
	}
	
	{
		_renameTarget = new Target();
		_renameTarget.setName(RENAME_TARGET);
		_renameTarget.setProject(_taskProject);
		_taskProject.addTarget(_renameTarget);
		
		_renameTask = new Move();
		_renameTask.setOwningTarget(_renameTarget);
		_renameTask.setProject(_taskProject);
		
		_renameTarget.addTask(_renameTask);
	}
	
	
	public void performTask() throws ComponentBuildException {
		
		_renameTask.setFile(new File(getSourceFile()));
		_renameTask.setTofile(new File(getDestFile()));
		_renameTask.setOverwrite(isOverwrite());
		
		_renameTask.maybeConfigure();
		
		try {
			
			buildProject(RENAME_TARGET);
			
		} catch (BuildException buildException) {
			_taskProject.fireBuildFinished(buildException);
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in Rename's performTask with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), buildException);
		}
		
	}
	
	public String toString() {
		StringBuffer content = new StringBuffer();
		content.append("sourceFile [ ");
		content.append(_sourceFile);
		content.append(" ] ");
		content.append("destFile [ ");
		content.append(_destFile);
		content.append(" ] ");
		content.append("overwrite [ ");
		content.append(_overwrite);
		content.append(" ] ");
		
		return content.toString();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof RenameTask)){
			return false;
		}
		
		RenameTask renameTaskInstance = (RenameTask) obj;
		return (this.getDestFile().equals(renameTaskInstance.getDestFile())) && (this.getSourceFile() == renameTaskInstance.getSourceFile());
	}
	
	public int hashCode() {
		
		return (getDestFile() + getSourceFile()).hashCode();
	}

	public String getDestFile() {
		return _destFile;
	}
	public void setDestFile(String destFile) {
		_destFile = destFile;
	}
	public boolean isOverwrite() {
		return _overwrite;
	}
	public void setOverwrite(boolean overwrite) {
		_overwrite = overwrite;
	}
	public String getSourceFile() {
		return _sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		_sourceFile = sourceFile;
	}
	
}