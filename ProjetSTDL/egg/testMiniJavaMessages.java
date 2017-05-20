package egg;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class testMiniJavaMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "testMiniJava";
  private testMiniJavaMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, egg.testMiniJavaMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String Undefined_ident;
  public static  String DECL_not_an_object;
  public static  String GENERICITE_already_defined;
  public static  String testMiniJava_expected_token;
  public static  String TYPE_not_an_interface;
  public static  String HERITAGE_already_defined;
  public static  String testMiniJava_expected_eof;
  public static  String PARAMETRE_already_defined;
  public static  String TYPE_already_defined;
  public static  String testMiniJava_unexpected_token;
  public static  String TYPE_unknown;
  }
