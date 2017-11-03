package edu.matc.multithread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class House
{
    int kidsInLine;
    List<TrickTreater> trickTreaters;

    public House()
    {
        kidsInLine = 10;
        trickTreaters = new LinkedList<TrickTreater>();
    }

    public void handCandy()
    {
        TrickTreater trickTreater;
        //System.out.println("Riley waiting for lock.");
        synchronized (trickTreaters)
        {

            while(trickTreaters.size()==0)
            {
                System.out.println("Riley is watching a movie.");
                try
                {
                    trickTreaters.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Riley opens the door.");
            trickTreater = (TrickTreater)((LinkedList<?>)trickTreaters).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Riley handing candy to " + trickTreater.getName());
            duration = (long)(Math.random()*30);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley done handing candy to a kid : "+ trickTreater.getName() + " in "+duration+ " seconds.");
    }

    public void add(TrickTreater trickTreater)
    {
        //System.out.println(trickTreater.getName()+ " got in line at "+ trickTreater.getInTime());

        synchronized (trickTreaters)
        {
            if(trickTreaters.size() == kidsInLine)
            {
                System.out.println("Line is full for "+trickTreater.getName());
                System.out.println(trickTreater.getName()+"bypasses Riley's house.");
                return ;
            }

            ((LinkedList<TrickTreater>)trickTreaters).offer(trickTreater);
            //System.out.println(trickTreater.getName()+ " got in line.");
            System.out.println(trickTreater.getName()+ " got in line at "+ trickTreater.getInTime());

            if(trickTreaters.size()==1)
                trickTreaters.notify();
        }
    }
}

