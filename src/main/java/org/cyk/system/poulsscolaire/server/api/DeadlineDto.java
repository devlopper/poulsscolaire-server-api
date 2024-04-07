package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une échéance.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DeadlineDto extends AbstractIdentifiableCodableNamableAuditableDto {
  
  @JsonbProperty(JSON_GROUP_IDENTIFIER)
  private String groupIdentifier;
  
  @JsonbProperty(JSON_GROUP_AS_STRING)
  private String groupAsString;
  
  @JsonbProperty(JSON_DATE)
  private LocalDateTime date;
  
  @JsonbProperty(JSON_DATE_AS_STRING)
  private String dateAsString;
  
  public static final String FIELD_GROUP_IDENTIFIER = "groupIdentifier";
  public static final String FIELD_GROUP_AS_STRING = "groupAsString";
  public static final String FIELD_DATE = "date";
  public static final String FIELD_DATE_AS_STRING = "dateAsString";
  
  public static final String JSON_GROUP_IDENTIFIER = "idGroupe";
  public static final String JSON_GROUP_AS_STRING = "groupeChaine";
  public static final String JSON_DATE = "date";
  public static final String JSON_DATE_AS_STRING = "dateChaine";
}
