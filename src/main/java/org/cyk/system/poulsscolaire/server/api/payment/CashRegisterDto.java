package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une caisse enregistreuse.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CashRegisterDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;
  
  public static final String FIELD_SCHOOL_IDENTIFIER = "schoolIdentifier";
  public static final String FIELD_SCHOOL_AS_STRING = "schoolAsString";
  public static final String FIELD_AMOUNT_AS_STRING = "amountAsString";
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
}
