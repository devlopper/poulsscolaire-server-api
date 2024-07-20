package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une échéance de montant.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AmountDeadlineDto extends AbstractIdentifiableAuditableDto {
  
  @JsonbProperty(JSON_AMOUNT_IDENTIFIER)
  private String amountIdentifier;
  
  @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
  private String adjustedFeeIdentifier;
  
  @JsonbProperty(JSON_ADJUSTED_FEE_AS_STRING)
  private String adjustedFeeAsString;
  
  @JsonbProperty(JSON_FEE_IDENTIFIER)
  private String feeIdentifier;
  
  @JsonbProperty(JSON_FEE_CATEGORY_AS_STRING)
  private String feeCategoryAsString;
  
  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  private String registrationIdentifier;
  
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_STUDENT_AS_STRING)
  private String studentAsString;
  
  @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
  private String deadlineIdentifier;
  
  @JsonbProperty(JSON_DEADLINE_AS_STRING)
  private String deadlineAsString;
  
  @JsonbProperty(JSON_PAYMENT)
  private Integer payment;
  
  @JsonbProperty(JSON_PAYMENT_AS_STRING)
  private String paymentAsString;
  
  public static final String JSON_AMOUNT_IDENTIFIER = "idMontant";
  
  /* From Fee */
  
  /* From Adjusted Fee */
  
  public static final String JSON_ADJUSTED_FEE_IDENTIFIER = "idFraisAjuste";
  public static final String JSON_ADJUSTED_FEE_AS_STRING = "fraisAjusteChaine";
  public static final String JSON_FEE_IDENTIFIER = "idFrais";
  public static final String JSON_FEE_CATEGORY_AS_STRING = "rubriqueChaine";
  public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_STUDENT_AS_STRING = "eleveChaine";
  
  public static final String JSON_DEADLINE_IDENTIFIER = "idEcheance";
  public static final String JSON_DEADLINE_AS_STRING = "echeanceChaine";
  
  public static final String JSON_PAYMENT = "paiement";
  public static final String JSON_PAYMENT_AS_STRING = "paiementChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "échéance de montant";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "échéances de montant";
}
