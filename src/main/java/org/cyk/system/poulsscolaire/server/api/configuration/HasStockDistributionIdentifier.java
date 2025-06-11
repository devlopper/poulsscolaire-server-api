package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.core.segregation.HasField;

/**
 * Cette interface représente une classe avec une notion d'identifiant de classe.
 *
 * @Christian
 */
public interface HasStockDistributionIdentifier extends HasField {

  /**
   * Cette méthode permet d'obtenir l'identifiant de classe.
   *
   * @return identifiant de classe
   */
  String getStockDistributionIdentifier();

  /**
   * Cette méthode permet d'assigner l'identifiant de classe.
   *
   * @param branchInstanceIdentifier identifiant de classe
   */
  void setStockDistributionIdentifier(String branchInstanceIdentifier);

  /**
   * Identifiant java de l'identifiant de la classe.
   */
  String FIELD_STOCK_DISTRIBUTION_IDENTIFIER = "stockDistributionIdentifier";
}
