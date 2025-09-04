package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.core.segregation.HasDateAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasDateDto;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingDto;

/**
 * Cette classe représente une décision de subvention.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubsidyDecisionDto extends AbstractIdentifiableCodableAuditableDto
    implements HasDateDto, HasDateAsStringDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
  private String schoolingIdentifier;

  @JsonbProperty(JSON_SCHOOLING_AS_STRING)
  private String schoolingAsString;

  @JsonbProperty(JSON_AMOUNT)
  private Integer amount;

  @JsonbProperty(JSON_AMOUNT_AS_STRING)
  private String amountAsString;

  @JsonbProperty(JSON_DATE)
  private LocalDateTime date;

  @JsonbProperty(JSON_DATE_AS_STRING)
  private String dateAsString;

  @JsonbProperty(JSON_REGISTRATION_COUNT_AS_STRING)
  private String registrationCountAsString;

  @JsonbProperty(JSON_PAYMENT_COUNT_AS_STRING)
  private String paymentCountAsString;

  @JsonbProperty(JSON_PAID_AMOUNT_AS_STRING)
  private String paidAmountAsString;

  @JsonbProperty(JSON_REMAINING_AMOUNT_TO_PAY_AS_STRING)
  private String remainingAmountToPayAsString;

  public static final String JSON_THIS_IDENTIFIER = "idDecisionSubvention";

  public static final String JSON_THIS_AS_STRING = "decisionSubventionChaine";

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_SCHOOLING_IDENTIFIER = SchoolingDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_SCHOOLING_AS_STRING = SchoolingDto.JSON_THIS_AS_STRING;
  public static final String JSON_AMOUNT = "montant";
  public static final String JSON_AMOUNT_AS_STRING = "montantChaine";
  public static final String JSON_REGISTRATION_COUNT_AS_STRING = "nombreInscriptionChaine";
  public static final String JSON_PAYMENT_COUNT_AS_STRING = "nombrePaiementChaine";
  public static final String JSON_PAID_AMOUNT_AS_STRING = "montantPayeChaine";
  public static final String JSON_REMAINING_AMOUNT_TO_PAY_AS_STRING = "restePayeChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "décision de subvention";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "décisions de subvention";
}
