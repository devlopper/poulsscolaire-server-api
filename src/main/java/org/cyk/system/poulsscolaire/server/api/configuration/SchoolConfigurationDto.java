package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingSourceDto;

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

  @JsonbProperty(JSON_PAYMENT_DEPARTMENT_IDENTIFIER)
  private String paymentDepartmentIdentifier;

  @JsonbProperty(JSON_PAYMENT_DEPARTMENT_AS_STRING)
  private String paymentDepartmentAsString;
  
  @JsonbProperty(JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER)
  private String paymentAccountingAccountIdentifier;

  @JsonbProperty(JSON_PAYMENT_ACCOUNTING_ACCOUNT_AS_STRING)
  private String paymentAccountingAccountAsString;

  @JsonbProperty(JSON_PAYMENT_FUNDING_SOURCE_IDENTIFIER)
  private String paymentFundingSourceIdentifier;

  @JsonbProperty(JSON_PAYMENT_FUNDING_SOURCE_AS_STRING)
  private String paymentFundingSourceAsString;

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_SCHOOL_AS_STRING = SchoolDto.JSON_THIS_AS_STRING;

  public static final String JSON_PAYMENT_DEPARTMENT_IDENTIFIER =
      DepartmentDto.JSON_THIS_IDENTIFIER + "Paiement";

  public static final String JSON_PAYMENT_DEPARTMENT_AS_STRING =
      "departementPaiementChaine";
  
  public static final String JSON_PAYMENT_ACCOUNTING_ACCOUNT_IDENTIFIER =
      AccountingAccountDto.JSON_THIS_IDENTIFIER + "Paiement";

  public static final String JSON_PAYMENT_ACCOUNTING_ACCOUNT_AS_STRING =
      "compteComptablePaiementChaine";

  public static final String JSON_PAYMENT_FUNDING_SOURCE_IDENTIFIER =
      FundingSourceDto.JSON_THIS_IDENTIFIER + "Paiement";

  public static final String JSON_PAYMENT_FUNDING_SOURCE_AS_STRING =
      "sourceFinancementPaiementChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "configuration";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
