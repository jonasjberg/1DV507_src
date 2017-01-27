package js224eh_assign1.ferrySystem;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-27.
 */
public class Car extends Vehicle
{
    public Car()
    {
        System.out.println("Instantiated a new car ..");
    }

    @Override
    public int getVehicleFee()
    {
        return 100;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 15;
    }

    @Override
    public int getSpaceRequired()
    {
        return 1;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 4;
    }
}
