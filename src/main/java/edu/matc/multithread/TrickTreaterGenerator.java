package edu.matc.multithread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TrickTreaterGenerator implements Runnable
{
    House house;

    public TrickTreaterGenerator(House house)
    {
        this.house = house;
    }

    public void run()
    {
        while(true)
        {
            TrickTreater trickTreater = new TrickTreater(house);
            trickTreater.setInTime(new Date());
            Thread thTrickTreater = new Thread(trickTreater);
            trickTreater.setName("Kid " + thTrickTreater.getId());
            thTrickTreater.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}
