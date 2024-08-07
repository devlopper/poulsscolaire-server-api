package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une rubrique.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FeeCategoryDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;
  
  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;
  
  @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
  private String schoolingIdentifier;
  
  @JsonbProperty(JSON_SCHOOLING_AS_STRING)
  private String schoolingAsString;
  
  /*
   * Amount
   */
  @JsonbProperty(JSON_TOTAL_AMOUNT_AS_STRING)
  private String totalAmountAsString;

  @JsonbProperty(JSON_PAID_AMOUNT_AS_STRING)
  private String paidAmountAsString;

  @JsonbProperty(JSON_PAYABLE_AMOUNT_AS_STRING)
  private String payableAmountAsString;

  /*
   * Registration amount
   */
  @JsonbProperty(JSON_TOTAL_REGISTRATION_AMOUNT_AS_STRING)
  private String totalRegistrationAmountAsString;

  @JsonbProperty(JSON_PAID_REGISTRATION_AMOUNT_AS_STRING)
  private String paidRegistrationAmountAsString;

  @JsonbProperty(JSON_PAYABLE_REGISTRATION_AMOUNT_AS_STRING)
  private String payableRegistrationAmountAsString;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  public static final String JSON_SCHOOLING_AS_STRING = "scolariteChaine";
  public static final String JSON_TOTAL_AMOUNT_AS_STRING = "montantTotalChaine";
  public static final String JSON_PAID_AMOUNT_AS_STRING = "montantPayeChaine";
  public static final String JSON_PAYABLE_AMOUNT_AS_STRING = "montantPayableChaine";

  public static final String JSON_TOTAL_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionTotalChaine";
  public static final String JSON_PAID_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionPayeChaine";
  public static final String JSON_PAYABLE_REGISTRATION_AMOUNT_AS_STRING =
      "montantInscriptionPayableChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "rubrique";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}
