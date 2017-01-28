package js224eh_assign1.ferrySystem;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-28.
 */
public class Bicycle extends Vehicle
{
    public Bicycle()
    {
        System.out.println("Instantiated a new BICYCLE ..");
    }

    @Override
    public int getVehicleFee()
    {
        return 40;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 0;
    }

    @Override
    public int getSpaceRequired()
    {
        return 1;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 1;
    }
}
