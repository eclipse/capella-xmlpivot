/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.xmlpivot.common.skeleton;

import org.polarsys.capella.core.data.capellacommon.AbstractCapabilityPkg;
import org.polarsys.capella.core.data.capellacommon.CapellacommonFactory;
import org.polarsys.capella.core.data.capellacommon.Region;
import org.polarsys.capella.core.data.capellacommon.StateMachine;
import org.polarsys.capella.core.data.capellamodeller.CapellamodellerFactory;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.ctx.CtxFactory;
import org.polarsys.capella.core.data.ctx.MissionPkg;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.ctx.SystemComponentPkg;
import org.polarsys.capella.core.data.ctx.SystemFunction;
import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.epbs.ConfigurationItemPkg;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.epbs.EpbsFactory;
import org.polarsys.capella.core.data.fa.AbstractFunctionalArchitecture;
import org.polarsys.capella.core.data.fa.FunctionPkg;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.data.la.LaFactory;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.LogicalComponentPkg;
import org.polarsys.capella.core.data.la.LogicalFunction;
import org.polarsys.capella.core.data.oa.EntityPkg;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.data.oa.RolePkg;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentPkg;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
import org.polarsys.capella.core.model.helpers.naming.NamingConstants;

/**
 */
public class DefaultModelWalkerHelper implements ModelWalkerHelper {

  /**
   * {@inheritDoc}
   */
  @Override
  public ConfigurationItem getConfigurationItem() {
    return EpbsFactory.eINSTANCE.createConfigurationItem(NamingConstants.CreateEPBSArchCmd_configurationItem_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InterfacePkg getInterfacePkg() {
    return CsFactory.eINSTANCE.createInterfacePkg(NamingConstants.CreateCommonCmd_interfaces_pkg_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public DataPkg getDataPkg() {
    return InformationFactory.eINSTANCE.createDataPkg(NamingConstants.CreateCommonCmd_data_pkg_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LogicalComponent getLogicalComponent() {
    return LaFactory.eINSTANCE.createLogicalComponent(NamingConstants.CreateLogicalArchCmd_logicalComponent_name);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public LogicalComponentPkg getLogicalComponentPkg() {
    return LaFactory.eINSTANCE.createLogicalComponentPkg("Structure");
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public LogicalFunction getLogicalFunction() {
    return LaFactory.eINSTANCE.createLogicalFunction(NamingConstants.CreateLogicalArchCmd_logicalFunction_root_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OperationalActivity getOperationalActivity() {
    return OaFactory.eINSTANCE.createOperationalActivity(NamingConstants.CreateOpAnalysisCmd_operationalActivity_root_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RolePkg getRolePkg() {
    return OaFactory.eINSTANCE.createRolePkg(NamingConstants.CreateOpAnalysisCmd_roles_pkg_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public EntityPkg getEntityPkg() {
    return OaFactory.eINSTANCE.createEntityPkg(NamingConstants.CreateOpAnalysisCmd_operationalEntities_pkg_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AbstractCapabilityPkg getAbstractCapabilityPkg(BlockArchitecture arch_p) {
    if (arch_p instanceof OperationalAnalysis) {
      return OaFactory.eINSTANCE.createOperationalCapabilityPkg(NamingConstants.CreateOpAnalysisCmd_operationalCapabilities_pkg_name);
    } else if (arch_p instanceof SystemAnalysis) {
      return CtxFactory.eINSTANCE.createCapabilityPkg(NamingConstants.CreateSysAnalysisCmd_capabilities_pkg_name);
    } else if (arch_p instanceof LogicalArchitecture) {
      return LaFactory.eINSTANCE.createCapabilityRealizationPkg(NamingConstants.CreateCommonCmd_capability_realisation_pkg_name);
    } else if (arch_p instanceof PhysicalArchitecture) {
      return LaFactory.eINSTANCE.createCapabilityRealizationPkg(NamingConstants.CreateCommonCmd_capability_realisation_pkg_name);
    } else if (arch_p instanceof EPBSArchitecture) {
      return LaFactory.eINSTANCE.createCapabilityRealizationPkg(NamingConstants.CreateCommonCmd_capability_realisation_pkg_name);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public FunctionPkg getFunctionPkg(AbstractFunctionalArchitecture arch_p) {
    if (arch_p instanceof OperationalAnalysis) {
      return OaFactory.eINSTANCE.createOperationalActivityPkg(NamingConstants.CreateOpAnalysisCmd_operationalActivities_pkg_name);
    } else if (arch_p instanceof SystemAnalysis) {
      return CtxFactory.eINSTANCE.createSystemFunctionPkg(NamingConstants.CreateSysAnalysisCmd_system_functions_pkg_name);
    } else if (arch_p instanceof LogicalArchitecture) {
      return LaFactory.eINSTANCE.createLogicalFunctionPkg(NamingConstants.CreateLogicalArchCmd_logicalFunctions_pkg_name);
    } else if (arch_p instanceof PhysicalArchitecture) {
      return PaFactory.eINSTANCE.createPhysicalFunctionPkg(NamingConstants.CreatePhysicalArchCmd_physicalFunctions_pkg_name);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MissionPkg getMissionPkg() {
    return CtxFactory.eINSTANCE.createMissionPkg(NamingConstants.CreateSysAnalysisCmd_missions_pkg_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PhysicalComponent getPhysicalComponent() {
    return PaFactory.eINSTANCE.createPhysicalComponent(NamingConstants.CreatePhysicalArchCmd_physicalComponent_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PhysicalFunction getPhysicalFunction() {
    return PaFactory.eINSTANCE.createPhysicalFunction(NamingConstants.CreatePhysicalArchCmd_physicalFunction_root_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SystemEngineering getSystemEngineering() {
    return CapellamodellerFactory.eINSTANCE.createSystemEngineering();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Region getRegion() {
    return CapellacommonFactory.eINSTANCE.createRegion(NamingConstants.Region_DefaultRegion);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OperationalAnalysis getOperationalAnalysis() {
    return OaFactory.eINSTANCE.createOperationalAnalysis(NamingConstants.SkeletonServicesImpl_package_name_operationalAnalysis);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SystemAnalysis getSystemAnalysis() {
    return CtxFactory.eINSTANCE.createSystemAnalysis(NamingConstants.SkeletonServicesImpl_package_name_systemAnalysis);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LogicalArchitecture getLogicalArchitecture() {
    return LaFactory.eINSTANCE.createLogicalArchitecture(NamingConstants.SkeletonServicesImpl_package_name_logicalArchitecture);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PhysicalArchitecture getPhysicalArchitecture() {
    return PaFactory.eINSTANCE.createPhysicalArchitecture(NamingConstants.SkeletonServicesImpl_package_name_physicalArchitecture);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public EPBSArchitecture getEPBSArchitecture() {
    return EpbsFactory.eINSTANCE.createEPBSArchitecture(NamingConstants.SkeletonServicesImpl_package_name_epbsArchitecture);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SystemFunction getSystemFunction() {
    return CtxFactory.eINSTANCE.createSystemFunction(NamingConstants.CreateSysAnalysisCmd_system_function_root_name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StateMachine getStateMachine() {
    return CapellacommonFactory.eINSTANCE.createStateMachine(NamingConstants.CreateSysAnalysisCmd_system_statemachine_name);
  }

  @Override
  public SystemComponentPkg getSystemComponentPkg() {
    return CtxFactory.eINSTANCE.createSystemComponentPkg(NamingConstants.CreateSysAnalysisCmd_actors_pkg_name);
  }

  @Override
  public PhysicalComponentPkg getPhysicalComponentPkg() {
    return PaFactory.eINSTANCE.createPhysicalComponentPkg(NamingConstants.CreatePhysicalArchCmd_actors_pkg_name);
  }

  @Override
  public SystemComponent getSystemComponent() {
    return CtxFactory.eINSTANCE.createSystemComponent(NamingConstants.CreateSysAnalysisCmd_system_name);
  }

  @Override
  public ConfigurationItemPkg getConfigurationItemPkg() {
    return EpbsFactory.eINSTANCE.createConfigurationItemPkg(NamingConstants.CreateEPBSArchCmd_configurationItemPkg_name);
  }

}
