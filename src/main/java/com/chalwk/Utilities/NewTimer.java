package com.chalwk.Utilities;

import com.chalwk.Logger;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import static com.chalwk.Main.getSettings;

public class NewTimer {

    static JSONObject settings = getSettings();
    static int update_interval = settings.getInt("update_interval");

    public static void loggerTimer() {
        Timer timer = new Timer();
        TimerTask task = new Logger.Task();
        timer.schedule(task, 0, update_interval * 1000L);
    }
}
