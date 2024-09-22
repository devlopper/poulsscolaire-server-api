package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableNamableAuditableDto;
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
public class AccountingAccountOperationDto extends AbstractIdentifiableNamableAuditableDto {

  @JsonbProperty(JSON_ACCOUNT_IDENTIFIER)
  private String accountIdentifier;

  @JsonbProperty(JSON_ACCOUNT_AS_STRING)
  private String accountsAsString;

  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String JSON_ACCOUNT_IDENTIFIER = "idCompte";

  public static final String JSON_ACCOUNT_AS_STRING = "compteChaine";
  
  public static final String JSON_AMOUNT = "montant";

  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";

  public static final String NAME = "opération de compte comptable";

  public static final String PLURAL_NAME = "opérations de comptes comptables";
}
