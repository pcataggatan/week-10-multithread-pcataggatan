package edu.matc.multithread;

public class Riley implements Runnable
{
    House house;

    public Riley(House house)
    {
        this.house = house;
    }
    public void run()
    {
        /*try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        */

        System.out.println("Riley's Holloween started...");

        while(true)
        {
            house.handCandy();
        }
    }
}
