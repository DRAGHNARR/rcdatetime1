package com.rencap.rcscript;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

public class RCScriptMain {
    public static String exec(String jsCode) throws IOException, InterruptedException { //throws InterruptedException, IOException
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        try {
            String eval = (String) engine.eval(jsCode);
            return eval;
        } catch (final ScriptException se) { se.printStackTrace(); }
        return null;
    }
}