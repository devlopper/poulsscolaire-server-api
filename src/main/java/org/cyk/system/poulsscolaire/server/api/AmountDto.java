package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un montant.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AmountDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_VALUE)
  private Long value;

  @JsonbProperty(JSON_VALUE_AS_STRING)
  private String valueAsString;

  @JsonbProperty(JSON_REGISTRATION_VALUE_PART)
  private Long registrationValuePart;

  @JsonbProperty(JSON_REGISTRATION_VALUE_PART_AS_STRING)
  private String registrationValuePartAsString;

  @JsonbProperty(JSON_OPTIONAL)
  private Boolean optional;

  @JsonbProperty(JSON_OPTIONAL_AS_STRING)
  private String optionalAsString;

  @JsonbProperty(JSON_PAYMENT_ORDER_NUMBER)
  private Integer paymentOrderNumber;

  @JsonbProperty(JSON_PAYMENT_ORDER_NUMBER_AS_STRING)
  private Boolean paymentOrderNumberAsString;

  @JsonbProperty(JSON_RENEWABLE)
  private Boolean renewable;

  @JsonbProperty(JSON_RENEWABLE_AS_STRING)
  private String renewableAsString;

  @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
  private String deadlineIdentifier;
  
  @JsonbProperty(JSON_DEADLINE_AS_STRING)
  private String deadlineAsString;
  
  public static final String FIELD_VALUE = "value";
  public static final String FIELD_VALUE_AS_STRING = "valueAsString";
  public static final String FIELD_REGISTRATION_VALUE_PART = "registrationValuePart";
  public static final String FIELD_REGISTRATION_VALUE_PART_AS_STRING =
      "registrationValuePartAsString";
  public static final String FIELD_OPTIONAL = "optional";
  public static final String FIELD_OPTIONAL_AS_STRING = "optionalAsString";
  public static final String FIELD_PAYMENT_ORDER_NUMBER = "paymentOrderNumber";
  public static final String FIELD_PAYMENT_ORDER_NUMBER_AS_STRING = "paymentOrderNumberAsString";
  public static final String FIELD_RENEWABLE = "renewable";
  public static final String FIELD_RENEWABLE_AS_STRING = "renewableAsString";
  public static final String FIELD_DEADLINE_IDENTIFIER = "deadline";
  public static final String FIELD_DEADLINE_AS_STRING = "deadlineAsString";
  
  public static final String JSON_VALUE = "matricule";
  public static final String JSON_VALUE_AS_STRING = "nom";
  public static final String JSON_REGISTRATION_VALUE_PART = "prenoms";
  public static final String JSON_REGISTRATION_VALUE_PART_AS_STRING = "adresseEmail";
  public static final String JSON_OPTIONAL = "numeroTelephone";
  public static final String JSON_OPTIONAL_AS_STRING = "idGenre";
  public static final String JSON_PAYMENT_ORDER_NUMBER = "genreChaine";
  public static final String JSON_PAYMENT_ORDER_NUMBER_AS_STRING = "estMasculin";
  public static final String JSON_RENEWABLE = "pereChaine";
  public static final String JSON_RENEWABLE_AS_STRING = "mereChaine";
  public static final String JSON_DEADLINE_IDENTIFIER = "idEcheance";
  public static final String JSON_DEADLINE_AS_STRING = "echeanceChaine";
}
