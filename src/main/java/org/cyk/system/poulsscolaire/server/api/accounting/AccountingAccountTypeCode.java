package org.cyk.system.poulsscolaire.server.api.accounting;

/**
 * Cette classe représente les codes de {@link AccountingAccountType}.
 *
 * @author Christian
 *
 */
public class AccountingAccountTypeCode {

  private AccountingAccountTypeCode() {

  }

  /**
   * Terme qui recouvre tous les types de dépenses engagées par une organisation, que ce soit à
   * court ou à long terme.
   */
  public static final String EXPENDITURE = "DEPENSE";

  /**
   * Terme strictement financier qui désigne les gains monétaires ou les revenus générés par une
   * entreprise ou un individu, après avoir pris en compte toutes les dépenses. Il se réfère à une
   * catégorie spécifique de ressources financières.
   */
  public static final String INCOME = "REVENU";
}

