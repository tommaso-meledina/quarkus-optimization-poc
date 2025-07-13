package com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response;

import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.Dummy;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP"}))
@AllArgsConstructor(onConstructor_ = @SuppressFBWarnings({"EI_EXPOSE_REP2"}))
public class GetDummyResponse extends BaseResponse {
  private final List<Dummy> dummies;
}
