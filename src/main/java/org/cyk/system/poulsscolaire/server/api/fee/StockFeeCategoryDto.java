package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.core.segregation.HasFeeCategoryAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasFeeCategoryIdentifierDto;
import ci.gouv.dgbf.extension.core.segregation.HasStockAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasStockIdentifierDto;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un stock de catégorie de frais.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class StockFeeCategoryDto extends AbstractIdentifiableCodableNamableAuditableDto
    implements HasStockIdentifierDto, HasStockAsStringDto, HasFeeCategoryIdentifierDto,
    HasFeeCategoryAsStringDto {

  @JsonbProperty(JSON_STOCK_IDENTIFIER)
  private String stockIdentifier;

  @JsonbProperty(JSON_STOCK_AS_STRING)
  private String stockAsString;
  
  @JsonbProperty(JSON_FEE_CATEGORY_IDENTIFIER)
  private String feeCategoryIdentifier;

  @JsonbProperty(JSON_FEE_CATEGORY_AS_STRING)
  private String feeCategoryAsString;

  public static final String JSON_THIS_IDENTIFIER = "idStockCategorieFrais";

  public static final String JSON_THIS_AS_STRING = "stockCategorieFraisChaine";

  public static final String NAME = "stock de catégorie de frais";

  public static final String PLURAL_NAME = "stocks de catégorie de frais";
}
