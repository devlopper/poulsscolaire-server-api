package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link StockDistributionRegistrationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class StockDistributionRegistrationFilter extends AbstractIdentifiableFilter {

  public StockDistributionRegistrationFilter(FilterDto dto) {
    super(dto);
  }

  public StockDistributionRegistrationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
  }
}
