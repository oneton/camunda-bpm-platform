/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl.repository;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.CalledProcessDefinition;

public class CalledProcessDefinitionImpl implements CalledProcessDefinition {
  private final String id;
  private final String key;
  private final String category;
  private final String description;
  private final String name;
  private final int version;
  private final String deploymentId;
  private final boolean suspended;
  private final String tenantId;
  private final String versionTag;
  private final Integer historyTimeToLive;
  private final boolean isStartableInTasklist;
  private final boolean hasStartFormKey;
  private final String diagramResourceName;
  private final String resourceName;

  protected List<String> callActivityIds;
  protected String callingProcessDefinitionId;


  public CalledProcessDefinitionImpl(ProcessDefinition definition, String callingProcessDefinitionId) {
    this.callActivityIds = new ArrayList<>();
    this.callingProcessDefinitionId = callingProcessDefinitionId;

    this.id = definition.getId();
    this.key = definition.getKey();
    this.category = definition.getCategory();
    this.description = definition.getDescription();
    this.name = definition.getName();
    this.version = definition.getVersion();
    this.deploymentId = definition.getDeploymentId();
    this.suspended = definition.isSuspended();
    this.tenantId = definition.getTenantId();
    this.versionTag = definition.getVersionTag();
    this.historyTimeToLive = definition.getHistoryTimeToLive();
    this.isStartableInTasklist = definition.isStartableInTasklist();
    this.hasStartFormKey = definition.hasStartFormKey();
    this.diagramResourceName = definition.getDiagramResourceName();
    this.resourceName = definition.getResourceName();
  }


  @Override
  public String getCallingProcessDefinitionId() {
    return this.callingProcessDefinitionId;
  }

  @Override
  public List<String> getCallingCallActivityIds() {
    return this.callActivityIds;
  }

  public void addCallingCallActivity(String activityId) {
    this.callActivityIds.add(activityId);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getKey() {
    return key;
  }

  @Override
  public String getCategory() {
    return category;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean hasStartFormKey() {
    return hasStartFormKey;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getVersion() {
    return version;
  }

  @Override
  public String getResourceName() {
    return resourceName;
  }

  @Override
  public String getDeploymentId() {
    return deploymentId;
  }

  @Override
  public String getDiagramResourceName() {
    return diagramResourceName;
  }

  @Override
  public boolean isSuspended() {
    return suspended;
  }

  @Override
  public String getTenantId() {
    return tenantId;
  }

  @Override
  public String getVersionTag() {
    return versionTag;
  }

  @Override
  public Integer getHistoryTimeToLive() {
    return historyTimeToLive;
  }

  @Override
  public boolean isStartableInTasklist() {
    return isStartableInTasklist;
  }
}
