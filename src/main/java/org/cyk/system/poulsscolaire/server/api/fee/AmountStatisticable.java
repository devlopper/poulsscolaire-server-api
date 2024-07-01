package org.cyk.system.poulsscolaire.server.api.fee;

/**
 * Cette interface représente un objet avec les propriétés de statistics de maontant.
 *
 * @author Christian
 *
 */
public interface AmountStatisticable {

  String getTotalAmountAsString();

  String getPaidAmountAsString();

  String getPayableAmountAsString();

  /*
   * Registration
   */

  String getTotalRegistrationAmountAsString();

  String getPaidRegistrationAmountAsString();

  String getPayableRegistrationAmountAsString();

}
