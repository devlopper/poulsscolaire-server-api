package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;

/**
 * Cette classe représente une source de financement.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FundingSourceDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;

  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;

  public static final String JSON_THIS_IDENTIFIER = "idSourceFinancement";

  public static final String JSON_THIS_AS_STRING = "sourceFinancementChaine";

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_SCHOOL_AS_STRING = SchoolDto.JSON_THIS_AS_STRING;

  public static final String NAME = "source de financement";

  public static final String PLURAL_NAME = "sources de financement";
}
