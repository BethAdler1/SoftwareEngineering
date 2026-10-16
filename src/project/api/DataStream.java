package project.api;
import java.util.List;
import java.util.Collections;
//wrapper for reading integer data from source 
public interface DataStream {
    default List<Integer> getData(){
        return Collections.emptyList();
    }
}
