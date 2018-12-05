import sun.rmi.runtime.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry implements Comparable<LogEntry>{
    private EntryType type;
    private Date time;
    private long guardId = -1;
    private static SimpleDateFormat parser = new SimpleDateFormat("[yyyy-MM-dd HH:mm");

    public LogEntry(String input) throws ParseException {
        this.time = parser.parse(input.split("] ")[0]);
        switch (input.split(" ")[2]){
            case "Guard":
                this.type = EntryType.SHIFT;
                break;
            case "wakes":
                this.type = EntryType.WAKE_UP;
                break;
            case "falls":
                this.type = EntryType.FALL_ASLEEP;
                break;
        }
        if (type == EntryType.SHIFT) {
            this.guardId = Long.parseLong(input.split(" ")[3].substring(1));
        }
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getGuardId() {
        return guardId;
    }

    public void setGuardId(long guardId) {
        this.guardId = guardId;
    }

    @Override
    public String toString() {
        return time.toString() + ", " + type + (guardId != -1 ? ", GuardId: " + guardId : "");
    }

    @Override
    public int compareTo(LogEntry o) {
        return this.time.compareTo(o.getTime());
    }
}
