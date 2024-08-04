package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link PeriodDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class PeriodFilter extends AbstractIdentifiableFilter {
  
  String schoolIdentifier;
  Boolean opened;
  
  public PeriodFilter(FilterDto dto) {
    super(dto);
  }

  public PeriodFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    opened = getOpened(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setOpened(filter, opened);
  }
  
  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setOpened(FilterDto filter, Boolean value) {
    set(filter, JSON_OPENED, f -> f.getValueAsString(), f -> f.setValueAsBoolean(value));
  }

  public static Boolean getOpened(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_OPENED));
  }

  public static final String JSON_OPENED = PeriodDto.JSON_OPENED;
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
}
