
import java.util.List;

public interface Measurable
{
    /**
     Computes the measure of the object.
     @return the measure
     */
    float getMeasure();

    static <T extends Measurable> float average(List<T> objects){
        float sum = 0;
        for(T m: objects){
            sum += m.getMeasure();
        }

        return sum/objects.size();
    }
}