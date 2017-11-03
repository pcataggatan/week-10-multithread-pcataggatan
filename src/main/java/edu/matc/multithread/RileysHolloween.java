package edu.matc.multithread;

public class RileysHolloween {

    public static void main(String a[])
    {
        House house = new House();

        Riley riley = new Riley(house);
        TrickTreaterGenerator ttg = new TrickTreaterGenerator(house);

        Thread thriley = new Thread(riley);
        Thread thttg = new Thread(ttg);

        thttg.start();
        thriley.start();

    }
}

