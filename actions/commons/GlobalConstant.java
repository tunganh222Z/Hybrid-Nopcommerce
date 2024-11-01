package commons;

import java.io.File;

public class GlobalConstant {
    public static final long LONG_TIMEOUT = 30;
    public static final long SHORT_TIMEOUT = 5;

    public static final String ADMIN_ID = "automationtunganh";
    public static final String ADMIN_PASSWORD = "Automationtunganh123@";
    public static final String RELATIVE_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FILE_PATH = RELATIVE_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String OS_NAME = System.getProperty("os.name");
}
