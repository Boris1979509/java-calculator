import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SplitString {
    static List split(String str)
    {
        List<String> myList = new ArrayList<>(Arrays.asList(str.split(" ")));
        if(myList.size() != 3)
            throw new ArrayIndexOutOfBoundsException("Invalid input data: " + str);
        return myList;
    }
}