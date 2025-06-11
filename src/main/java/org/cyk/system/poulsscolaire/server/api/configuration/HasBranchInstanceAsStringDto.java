package org.cyk.system.poulsscolaire.server.api.configuration;

/**
 * Cette interface représente une entité avec une notion de représentation en chaine de caractères
 * de la classe.
 *
 * @Christian
 */
public interface HasBranchInstanceAsStringDto extends HasBranchInstanceAsString {

  /**
   * Identifiant json de la représentation en chaine de caractères de la classe.
   */
  String JSON_BRANCH_INSTANCE_AS_STRING = "branchInstanceAsString";
}
