package ZipValidation;

public class Range {
	
	private int lower;
	private int upper;
	
	Range(int lower, int upper){
		if(lower <= upper) {
			this.lower = lower;
			this.upper = upper;
		} else {
			this.lower = upper;
			this.upper = lower;	
		}
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	public String toString() {
		return String.format("['%d','%d']", lower, upper );
	}
	
	public boolean equals(Object other){
		boolean result = false;
        if (other instanceof Range) {
            Range that = (Range) other;
            result = (this.getLower()==that.getLower() && this.getUpper() ==that.getUpper() );
        }
        return result;
	}
	
	
}
