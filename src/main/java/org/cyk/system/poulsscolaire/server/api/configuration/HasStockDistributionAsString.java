package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.core.segregation.HasField;

/**
 * Cette interface représente une classe avec une notion de représentation en chaine de caractères
 * de distribution de stock.
 *
 * @Christian
 */
public interface HasStockDistributionAsString extends HasField {

  /**
   * Cette méthode permet d'obtenir la représentation en chaine de caractères de distribution de
   * stock.
   *
   * @return représentation en chaine de caractères de distribution de stock
   */
  String getStockDistributionAsString();

  /**
   * Cette méthode permet d'assigner la représentation en chaine de caractères de distribution de
   * stock.
   *
   * @param stockDistributionAsString représentation en chaine de caractères de distribution de
   *        stock
   */
  void setStockDistributionAsString(String stockDistributionAsString);

  /**
   * Identifiant java de la représentation en chaine de caractères de la distribution de stock.
   */
  String FIELD_STOCK_DISTRIBUTION_AS_STRING = "stockDistributionAsString";
}
