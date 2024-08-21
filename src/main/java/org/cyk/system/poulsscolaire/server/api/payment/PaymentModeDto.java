package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;

/**
 * Cette classe représente un mode paiement.
 *
 * @author Christian
 *
 */
public class PaymentModeDto extends AbstractIdentifiableCodableNamableAuditableDto {

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "mode de paiement";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "modes de paiement";
}
