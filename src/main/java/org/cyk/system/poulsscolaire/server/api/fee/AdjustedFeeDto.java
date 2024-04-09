package org.cyk.system.poulsscolaire.server.api.fee;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un frais ajusté.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdjustedFeeDto extends AbstractAmountContainerDto {

  @JsonbProperty(JSON_FEE_IDENTIFIER)
  private String feeIdentifier;
  
  @JsonbProperty(JSON_FEE_AS_STRING)
  private String feeAsString;
  
  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  private String registrationIdentifier;
  
  @JsonbProperty(JSON_REGISTRATION_AS_STRING)
  private String registrationAsString;
  
  public static final String FIELD_FEE_IDENTIFIER = "feeIdentifier";
  public static final String FIELD_FEE_AS_STRING = "feeAsString";
  public static final String FIELD_REGISTRATION_IDENTIFIER = "registrationIdentifier";
  public static final String FIELD_REGISTRATION_AS_STRING = "registrationAsString";
  
  public static final String JSON_FEE_IDENTIFIER = "idFrais";
  public static final String JSON_FEE_AS_STRING = "fraisChaine";
  public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
  public static final String JSON_REGISTRATION_AS_STRING = "inscriptionChaine";
}
