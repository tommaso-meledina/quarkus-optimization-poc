package com.ibm.it.meledina.tommaso.sample.quarkus.model.framework;

public class ApiPaths {

  private ApiPaths() {}

  public static class Common {

    public static final String EMPTY_PATH = "";

    private Common() {}
  }

  public static class DummyController {

    public static final String BASE_PATH = "/dummies";

    private DummyController() {}
  }

  public static class OptionController {

    public static final String BASE_PATH = "/options";

    public static final String REQUEST_CONTEXTS = "/request-contexts";
    public static final String REQUESTOR_TYPES = "/requestor-types";
    public static final String REQUEST_TOPICS = "/request-topics";

    private OptionController() {}
  }
}
