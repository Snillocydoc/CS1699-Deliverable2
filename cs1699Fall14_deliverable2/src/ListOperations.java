//import java.util.ArrayList;
import java.util.List;


public class ListOperations {

	public boolean check2StringListEqual(List<String> leftResult,List<String> rightResult){
	    if(leftResult.size()!=rightResult.size())
	        return false;
	    
	    for(int i=0; i< leftResult.size(); i++){
	        if(!leftResult.get(i).equals(rightResult.get(i)))
	            return false;
	    }
	    
	    return true;
	}
}
