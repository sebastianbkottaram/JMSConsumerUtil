//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Vinayak
 * @since 07/29/2019
 */

public class TraceOrgLogger
{
    String MOTADATA_DIR = "motadata";

    static short LOG_LEVEL_TRACE = 0;

    static short LOG_LEVEL_DEBUG = 1;

    static short LOG_LEVEL_INFO = 2;

    static short LOG_LEVEL_WARNING = 3;

    static short LOG_LEVEL_ERROR = 4;

    private static int m_logLevel = LOG_LEVEL_INFO;

    private static final String LOG_DIRECTORY = "BBNL-log-consumer";

    private static final String INFO_FILE = "$$$-BBNL-INFO.log";

    private static final String FATAL_FILE = "$$$-BBNL-FATAL.log";

    private static final String WARNING_FILE = "$$$-BBNL-WARNING.log";

    private static final String TRACE_FILE = "$$$-BBNL-TRACE.log";

    private static final String DEBUG_FILE = "$$$-BBNL-DEBUG.log";

    private static final String ERROR_FILE = "$$$-BBNL-ERROR.log";

    private static final String INVALID_QUERY_FILE = "$$$-BBNL-INVALID_QUERY.log";

    private final String m_class;

    private final String m_component;

    String NEW_LINE = System.lineSeparator();

    public TraceOrgLogger(Class clazz, String component)
    {
        this.m_class = clazz.getName();

        this.m_component = component;
    }

    public void error(Exception exception)
    {
        try
        {
            if (errorEnabled())
            {
                String logFile = MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

                File logDir = new File(logFile);

                if (!logDir.exists())
                {
                    logDir.mkdirs();
                }

                Date date = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

                String currentDate = simpleDateFormat.format(date);

                logFile = logFile +"/" + ERROR_FILE;

                logFile = logFile.replace("$$$", currentDate);

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                String currentTime = simpleTimeFormat.format(date);

                bufferedWriter.write(currentDate + " " + currentTime + " ERROR [" + this.m_component + "][" + this.m_class + "]:" + exception.getMessage() + NEW_LINE + getStackTrace(exception.getStackTrace()) + NEW_LINE);

                bufferedWriter.flush();

                bufferedWriter.close();

            }

        }
        catch (Exception ignored)
        {

        }
    }

    private String getStackTrace(StackTraceElement[] stackTraceElements)
    {

        StringBuilder stackTrace = new StringBuilder();

        try
        {
            if (stackTraceElements != null)
            {
                for (StackTraceElement stackTraceElement : stackTraceElements)
                {


                    stackTrace.append("\tat ").append(stackTraceElement).append(NEW_LINE);
                }

            }

        }

        catch (Exception ignored)
        {

        }

        return stackTrace.toString();
    }

    public void info(Object message)
    {
        try
        {
            if (infoEnabled())
            {
                String logFile = MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

                File logDir = new File(logFile);

                if (!logDir.exists())
                {
                   logDir.mkdirs();
                }

                Date date = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

                String currentDate = simpleDateFormat.format(date);

                logFile = logFile +"/" + INFO_FILE;

                logFile = logFile.replace("$$$", currentDate);

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                String currentTime = simpleTimeFormat.format(date);

                bufferedWriter.write(currentDate + " " + currentTime + " INFO " + "[" + this.m_component + "]:" + message + NEW_LINE);

                System.out.println(message);

                bufferedWriter.flush();

                bufferedWriter.close();


            }
        }
        catch (Exception ignored)
        {

        }
    }

    public void warn(Object message)
    {
        try
        {
            if (warningEnabled())
            {
                System.out.println(message);

                String logFile = MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

                File logDir = new File(logFile);

                if (!logDir.exists())
                {
                    logDir.mkdirs();
                }

                Date date = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

                String currentDate = simpleDateFormat.format(date);

                logFile = logFile +"/" + WARNING_FILE;

                logFile = logFile.replace("$$$", currentDate);

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                String currentTime = simpleTimeFormat.format(date);

                bufferedWriter.write(currentDate + " " + currentTime + " WARN " + "[" + this.m_component + "]:" + message + NEW_LINE);

                bufferedWriter.flush();

                bufferedWriter.close();


            }
        }
        catch (Exception ignored)
        {

        }
    }

    public void debug(Object message)
    {
        try
        {
            if (debugEnabled())
            {

                String logFile = MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

                File logDir = new File(logFile);

                if (!logDir.exists())
                {
                    logDir.mkdirs();
                }

                Date date = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

                String currentDate = simpleDateFormat.format(date);

                logFile = logFile +"/" + DEBUG_FILE;

                logFile = logFile.replace("$$$", currentDate);

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                String currentTime = simpleTimeFormat.format(date);

                bufferedWriter.write(currentDate + " " + currentTime + " DEBUG " + "[" + this.m_component + "]:" + message + NEW_LINE);

                bufferedWriter.flush();

                bufferedWriter.close();


            }
        }
        catch (Exception ignored)
        {

        }
    }


    public void fatal(Object message)
    {

        try
        {

            System.out.println(message);

            String logFile = MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

            File logDir = new File(logFile);

            if (!logDir.exists())
            {
                logDir.mkdirs();
            }

            Date date = new Date();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

            String currentDate = simpleDateFormat.format(date);

            logFile = logFile +"/" + FATAL_FILE;

            logFile = logFile.replace("$$$", currentDate);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

            SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

            String currentTime = simpleTimeFormat.format(date);

            bufferedWriter.write(currentDate + " " + currentTime + " FATAL [" + this.m_component + "][" + this.m_class + "]:" + message + NEW_LINE);

            bufferedWriter.flush();

            bufferedWriter.close();


        }

        catch (Exception ignored)
        {

        }
    }

    public void trace(Object message)
    {
        try
        {
            if (traceEnabled())
            {

                String logFile = MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

                File logDir = new File(logFile);

                if (!logDir.exists())
                {
                    logDir.mkdirs();
                }

                Date date = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

                String currentDate = simpleDateFormat.format(date);

                logFile = logFile +"/" + TRACE_FILE;

                logFile = logFile.replace("$$$", currentDate);

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                String currentTime = simpleTimeFormat.format(date);

                bufferedWriter.write(currentDate + " " + currentTime + " TRACE " + "[" + this.m_component + "]:" + message + NEW_LINE);

                bufferedWriter.flush();

                bufferedWriter.close();


            }
        }
        catch (Exception ignored)
        {

        }
    }

    public void invalidQuery(Object message)
    {
        try
        {
            if (infoEnabled())
            {

                String logFile =MOTADATA_DIR +"/" + "BBNL" +"/" + LOG_DIRECTORY;

                File logDir = new File(logFile);

                if (!logDir.exists())
                {
                    logDir.mkdirs();
                }

                Date date = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

                String currentDate = simpleDateFormat.format(date);

                logFile = logFile +"/" + INVALID_QUERY_FILE;

                logFile = logFile.replace("$$$", currentDate);

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                String currentTime = simpleTimeFormat.format(date);

                bufferedWriter.write(currentDate + " " + currentTime + " QUERY " + "[" + this.m_component + "]:" + message + NEW_LINE);

                bufferedWriter.flush();

                bufferedWriter.close();


            }
        }
        catch (Exception ignored)
        {

        }
    }

    public static boolean debugEnabled()
    {

        return LOG_LEVEL_DEBUG >= m_logLevel;
    }

    public static boolean warningEnabled()
    {

        return LOG_LEVEL_WARNING >= m_logLevel;
    }

    public static boolean infoEnabled()
    {

        return LOG_LEVEL_INFO >= m_logLevel;
    }

    public static boolean errorEnabled()
    {

        return LOG_LEVEL_ERROR >= m_logLevel;
    }

    public static boolean traceEnabled()
    {

        return LOG_LEVEL_TRACE >= m_logLevel;
    }

    public static void setLogLevel(short logLevel)
    {

        m_logLevel = logLevel;
    }
}
