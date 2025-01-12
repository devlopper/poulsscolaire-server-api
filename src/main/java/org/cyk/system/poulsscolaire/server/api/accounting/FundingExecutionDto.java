package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une exécution de {@link FundingExecutionDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FundingExecutionDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_FUNDING_IDENTIFIER)
  private String fundingIdentifier;

  @JsonbProperty(JSON_FUNDING_AS_STRING)
  private String fundingAsString;

  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;
  
  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String JSON_THIS_IDENTIFIER = "idExecutionFinancement";

  public static final String JSON_THIS_AS_STRING = "executionFinancementChaine";
  
  public static final String JSON_FUNDING_IDENTIFIER = FundingDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_FUNDING_AS_STRING = FundingDto.JSON_THIS_AS_STRING;

  public static final String JSON_AMOUNT = "montant";
  
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  
  public static final String NAME = "exécution de financement";

  public static final String PLURAL_NAME = "exécutions des financements";
}
