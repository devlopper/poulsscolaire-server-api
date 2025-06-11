package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.core.segregation.HasField;

/**
 * Cette interface représente une entité avec une notion de représentation en chaine de caractères
 * de la classe.
 *
 * @Christian
 */
public interface HasBranchInstanceAsString extends HasField {

  /**
   * Cette méthode permet d'obtenir la représentation en chaine de caractères de la classe.
   *
   * @return représentation en chaine de caractères de la classe
   */
  String getBranchInstanceAsString();

  /**
   * Cette méthode permet d'assigner la représentation en chaine de caractères de la classe.
   *
   * @param branchInstanceAsString représentation en chaine de caractères de la classe
   */
  void setBranchInstanceAsString(String branchInstanceAsString);

  /**
   * Identifiant java de la représentation en chaine de caractères de la classe.
   */
  String FIELD_BRANCH_INSTANCE_AS_STRING = "branchInstanceAsString";
}
