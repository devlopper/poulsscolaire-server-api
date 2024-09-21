package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une opération comptable.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AccountingOperationDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_ACCOUNT_IDENTIFIER)
  private String accountIdentifier;

  @JsonbProperty(JSON_ACCOUNT_AS_STRING)
  private String accountsAsString;

  public static final String JSON_ACCOUNT_IDENTIFIER = "idCompte";

  public static final String JSON_ACCOUNT_AS_STRING = "compteChaine";

  public static final String NAME = "opération comptable";

  public static final String PLURAL_NAME = "opérations comptables";
}
