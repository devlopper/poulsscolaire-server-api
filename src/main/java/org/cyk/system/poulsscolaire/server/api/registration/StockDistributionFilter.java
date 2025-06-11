package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link StockDistributionDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class StockDistributionFilter extends AbstractIdentifiableFilter {

  public StockDistributionFilter(FilterDto dto) {
    super(dto);
  }

  public StockDistributionFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
  }
}
