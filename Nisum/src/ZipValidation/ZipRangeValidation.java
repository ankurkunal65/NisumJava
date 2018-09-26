package ZipValidation;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ZipRangeValidation {
	
	private static ArrayList<Range> rangeList = new ArrayList<Range>();
	
	public static void main(String[] args) {
		
		Range a = new Range(94133,94133);
		Range b = new Range(94200,94299);
		Range c = new Range(94226,94399);
		
		ZipRangeValidation.AddRange(a);
		ZipRangeValidation.AddRange(b);
		ZipRangeValidation.AddRange(c);
		
		showRange() ;
		
	}

	public static void AddRange(Range toAdd) {
		if(rangeList.size()==0)
			rangeList.add(toAdd);
		else {
			ListIterator<Range> iter = rangeList.listIterator();
			boolean add = true;
			while( iter.hasNext()) {
				Range range = iter.next();	
				if(range.getLower()<=toAdd.getLower() && range.getUpper()>=toAdd.getUpper()) {
					add = false;
				}
				else if(range.getLower()>toAdd.getUpper() || range.getUpper()<toAdd.getLower()) {
					add = true;
				}
				else {
					if(range.getLower()<toAdd.getLower())
						toAdd.setLower(range.getLower());
					if(range.getUpper()>toAdd.getUpper())
						toAdd.setUpper(range.getUpper());
					iter.remove();
					add = true;
				}
			}
			if(add)
				rangeList.add(toAdd);
		}
		
   }
	
   public static void showRange() {
	   if(rangeList.size()>0) {
		   for(Range range :rangeList) {
			   System.out.println(range.toString());
		   }
	   }
	   
   }
   
   public static int size() {
	   return rangeList.size();
   }
   
   public static List<Range> getZipRanges() {
	   return rangeList;
   }
   
   
   public static void clear() {
	   rangeList.clear();
   }

}
