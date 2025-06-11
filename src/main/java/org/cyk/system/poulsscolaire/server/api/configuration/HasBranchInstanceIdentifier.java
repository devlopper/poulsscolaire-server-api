package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.core.segregation.HasField;

/**
 * Cette interface représente une classe avec une notion d'identifiant de la classe.
 *
 * @Christian
 */
public interface HasBranchInstanceIdentifier extends HasField {

  /**
   * Cette méthode permet d'obtenir l'identifiant de la classe.
   *
   * @return identifiant de classe
   */
  String getBranchInstanceIdentifier();

  /**
   * Cette méthode permet d'assigner l'identifiant de la classe.
   *
   * @param branchInstanceIdentifier identifiant de la classe
   */
  void setBranchInstanceIdentifier(String branchInstanceIdentifier);

  /**
   * Identifiant java de l'identifiant de la classe.
   */
  String FIELD_BRANCH_INSTANCE_IDENTIFIER = "branchInstanceIdentifier";
}
