package edu.matc.multithread;

import java.util.Date;

public class TrickTreater implements Runnable
{
    String name;
    Date inTime;

    House house;

    public TrickTreater(House house)
    {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        goForHairCut();
    }
    private synchronized void goForHairCut()
    {
        house.add(this);
    }
}

