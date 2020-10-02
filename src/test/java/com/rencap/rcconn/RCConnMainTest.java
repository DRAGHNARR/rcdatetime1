package com.rencap.rcconn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RCConnMainTest {
    @Test
    public void exec() {
        String svcMurex = RCConnMain.exec("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://michelangelo", "svcMurex", "E2-86-F5-81-4F", "select 1 as test");
        Assert.assertEquals("<root><item><test>1</test></item></root>", svcMurex);
    }
}

