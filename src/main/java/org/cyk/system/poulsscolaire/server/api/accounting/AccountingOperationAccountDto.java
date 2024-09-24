package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une opération de compte comptable.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AccountingOperationAccountDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_OPERATION_IDENTIFIER)
  private String operationIdentifier;

  @JsonbProperty(JSON_OPERATION_AS_STRING)
  private String operationAsString;

  @JsonbProperty(JSON_ACCOUNT_IDENTIFIER)
  private String accountIdentifier;

  @JsonbProperty(JSON_ACCOUNT_AS_STRING)
  private String accountAsString;

  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;

  public static final String JSON_OPERATION_IDENTIFIER = "idOperation";

  public static final String JSON_OPERATION_AS_STRING = "operationChaine";

  public static final String JSON_ACCOUNT_IDENTIFIER = "idCompte";

  public static final String JSON_ACCOUNT_AS_STRING = "compteChaine";

  public static final String JSON_AMOUNT = "montant";

  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";

  public static final String NAME = "opération de compte comptable";

  public static final String PLURAL_NAME = "opérations de comptes comptables";
}
