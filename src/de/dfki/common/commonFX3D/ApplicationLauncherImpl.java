package de.dfki.common.commonFX3D;

import de.dfki.common.interfaces.ApplicationLauncher;
import de.dfki.common.interfaces.AgentStage;

public abstract class ApplicationLauncherImpl implements ApplicationLauncher
{

    private static boolean isRunning = false;

    @Override
    public void waitForApplicationToStart()
    {
        while (!isRunning)
        { //New class for running
            try
            {
                Thread.sleep(200);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Thread getLaunchStickmanThread(final AgentStage fx)
    {
        return new Thread()
        {
            public void run()
            {
                fx.launcher();
            }

        };
    }

    public static boolean isRunning()
    {
        return isRunning;
    }

    public static synchronized void setIsRunning()
    {
        isRunning = true;
    }
}
