package org.cyk.system.poulsscolaire.server.api.configuration;

/**
 * Cette interface représente une classe avec une notion d'identifiant de la classe.
 *
 * @Christian
 */
public interface HasBranchInstanceIdentifierDto extends HasBranchInstanceIdentifier {

  /**
   * Identifiant json de l'identifiant de la classe.
   */
  String JSON_BRANCH_INSTANCE_IDENTIFIER = "idClasse";
}
