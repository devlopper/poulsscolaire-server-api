package org.cyk.system.poulsscolaire.server.api.configuration;

/**
 * Cette interface représente une classe avec une notion de représentation en chaine de caractères
 * de distribution de stock.
 *
 * @Christian
 */
public interface HasStockDistributionAsStringDto extends HasStockDistributionAsString {

  /**
   * Identifiant json de la représentation en chaine de caractères de la distribution de stock.
   */
  String JSON_STOCK_DISTRIBUTION_AS_STRING = "distributionStockChaine";
}
