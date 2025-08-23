package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionUpdateSubsidiesRequestDto.SubsidyDto;

/**
 * Cette classe représente {@link RegistrationDto} de {@link SubsidyDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubsidyDecisionRegistrationDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_SUBSIDY_DECISION_IDENTIFIER)
  private String subsidyDecisionIdentifier;

  @JsonbProperty(JSON_SUBSIDY_DECISION_AS_STRING)
  private String subsidyDecisionAsString;

  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  private String registrationIdentifier;

  @JsonbProperty(JSON_REGISTRATION_AS_STRING)
  private String registrationAsString;

  @JsonbProperty(JSON_ACCEPTED)
  private Boolean accepeted;

  @JsonbProperty(JSON_ACCEPTED_AS_STRING)
  private String accepetedAsString;

  public static final String JSON_SUBSIDY_DECISION_IDENTIFIER = "idPaiement";
  public static final String JSON_SUBSIDY_DECISION_AS_STRING = "paiementChaine";
  public static final String JSON_REGISTRATION_IDENTIFIER = RegistrationDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_REGISTRATION_AS_STRING = RegistrationDto.JSON_THIS_AS_STRING;
  public static final String JSON_ACCEPTED = "accepte";
  public static final String JSON_ACCEPTED_AS_STRING = "accepteChaine";

  public static final String NAME = "inscription de décision de subvention";

  public static final String PLURAL_NAME = "inscriptions de décision de subvention";
}
