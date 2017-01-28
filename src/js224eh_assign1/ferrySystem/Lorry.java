package js224eh_assign1.ferrySystem;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-28.
 */
public class Lorry extends Vehicle
{
    public Lorry()
    {
        System.out.println("Created a new LORRY ..");
    }

    @Override
    public int getVehicleFee()
    {
        return 300;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 15;
    }

    @Override
    public int getSpaceRequired()
    {
        return 40;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 2;
    }
}
