public class Result extends Exam{
	float totalMark;
	
	public Result(String name,int rollNo,int maths,int science,int social) {
		this.name = name;
		this.rollNo = rollNo;
		this.maths = maths;
		this.science = science;
		this.social = social;
	}
	
	public float calculateTotalMark() {
		return this.maths+this.science+this.social;
	}
	
	
	public static void main(String[] args) {
		Result obj = new Result("Rubesh",21,90,93,95);
		
		System.out.println(obj.calculateTotalMark());
	}
	
}
