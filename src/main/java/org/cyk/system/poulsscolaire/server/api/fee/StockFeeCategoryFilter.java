package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link StockFeeCategoryDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class StockFeeCategoryFilter extends AbstractIdentifiableFilter {

  String stockIdentifier;
  
  String feeCategoryIdentifier;

  /**
   * Cette méthode permet de construire.
   *
   * @param dto {@link FilterDto}
   */
  public StockFeeCategoryFilter(FilterDto dto) {
    super(dto);
  }

  /**
   * Cette méthode permet de construire.
   */
  public StockFeeCategoryFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    feeCategoryIdentifier = getFeeCategoryIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setFeeCategoryIdentifier(filter, feeCategoryIdentifier);
  }

  public static void setFeeCategoryIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_FEE_CATEGORY_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getFeeCategoryIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FEE_CATEGORY_IDENTIFIER));
  }

  public static final String JSON_FEE_CATEGORY_IDENTIFIER =
      StockFeeCategoryDto.JSON_FEE_CATEGORY_IDENTIFIER;
}
