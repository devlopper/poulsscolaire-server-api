package org.cyk.system.poulsscolaire.server.api.configuration;

/**
 * Cette interface représente une classe avec une notion d'identifiant de classe.
 *
 * @Christian
 */
public interface HasStockDistributionIdentifierDto extends HasStockDistributionIdentifier {

  /**
   * Identifiant json d'identifiant de classe.
   */
  String JSON_STOCK_DISTRIBUTION_IDENTIFIER = "idDistributionStock";
}