package js224eh_assign1.ferrySystem;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-28.
 */
public class Bus extends Vehicle
{
    @Override
    public int getVehicleFee()
    {
        return 200;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 10;
    }

    @Override
    public int getSpaceRequired()
    {
        return 20;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 20;
    }
}
