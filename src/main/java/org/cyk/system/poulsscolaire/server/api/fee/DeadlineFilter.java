package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.registration.StudentDto;

/**
 * Cette classe représente le filtre de {@link DeadlineDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class DeadlineFilter extends AbstractIdentifiableFilter {
  
  String schoolIdentifier;

  public DeadlineFilter(FilterDto dto) {
    super(dto);
  }

  public DeadlineFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = StudentDto.JSON_SCHOOL_IDENTIFIER;
}
