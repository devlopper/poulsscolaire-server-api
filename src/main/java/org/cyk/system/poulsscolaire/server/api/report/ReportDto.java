package org.cyk.system.poulsscolaire.server.api.report;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un rapport.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ReportDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_OUTPUT_FILE_TYPE)
  private String outputFileType;
  
  public static final String FIELD_PARAMETERS = "parameters";
  public static final String FIELD_OUTPUT_FILE_TYPE = "outputFileType";
  
  public static final String JSON_PARAMETERS = "parametres";
  public static final String JSON_OUTPUT_FILE_TYPE = "typeFichierSortie";
}
