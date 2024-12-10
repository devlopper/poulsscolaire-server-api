package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;

/**
 * Cette classe représente un stock.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class StockDto extends AbstractIdentifiableCodableNamableAuditableDto {

  @JsonbProperty(JSON_FEE_CATEGORY_IDENTIFIER)
  private String feeCategoryIdentifier;

  @JsonbProperty(JSON_FEE_CATEGORY_AS_STRING)
  private String feeCategoryAsString;

  @JsonbProperty(JSON_QUANTITY_AS_STRING)
  private String quantityAsString;

  public static final String JSON_THIS_IDENTIFIER = "idStock";

  public static final String JSON_THIS_AS_STRING = "stockChaine";

  public static final String JSON_FEE_CATEGORY_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_FEE_CATEGORY_AS_STRING = SchoolDto.JSON_THIS_AS_STRING;

  public static final String JSON_QUANTITY_AS_STRING = "quantiteChaine";

  public static final String NAME = "stock";

  public static final String PLURAL_NAME = NAME + "s";
}
