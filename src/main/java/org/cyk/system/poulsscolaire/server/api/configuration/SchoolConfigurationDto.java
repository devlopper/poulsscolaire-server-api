package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une configuration de {@link SchoolConfigurationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SchoolConfigurationDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  @JsonbProperty(JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER)
  private String paymentAccountingAccountIdentifier;

  @JsonbProperty(JSON_PAYMENT_ACCOUNTING_ACCOUNT_AS_STRING)
  private String paymentAccountingAccountAsString;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";

  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";

  public static final String JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER =
      "idCompteComptablePaiement";

  public static final String JSON_PAYMENT_ACCOUNTING_ACCOUNT_AS_STRING =
      "compteComptablePaiementChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "configuration";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
