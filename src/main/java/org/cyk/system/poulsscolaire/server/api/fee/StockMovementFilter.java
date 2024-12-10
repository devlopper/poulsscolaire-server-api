package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link StockMovementDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class StockMovementFilter extends AbstractIdentifiableFilter {

  String stockIdentifier;

  public StockMovementFilter(FilterDto dto) {
    super(dto);
  }

  public StockMovementFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    stockIdentifier = getStockIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setStockIdentifier(filter, stockIdentifier);
  }

  public static void setStockIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_STOCK_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getStockIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_STOCK_IDENTIFIER));
  }

  public static final String JSON_STOCK_IDENTIFIER = StockMovementDto.JSON_STOCK_IDENTIFIER;
}
