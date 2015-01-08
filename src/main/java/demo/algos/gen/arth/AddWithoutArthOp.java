package demo.algos.gen.arth;

public class AddWithoutArthOp {

	public static void main(String[] args) {
		AddWithoutArthOp arthOp=new AddWithoutArthOp();
		arthOp.add(3, 2);
		arthOp.add(3, -5);
		arthOp.addrec(3, 2);
		arthOp.addrec(3, -5);
	}

	private void add(int num1, int num2) {

		while (num2 != 0) {
			int carry = num1 & num2;

			num1 = num1 ^ num2;

			num2 = carry << 1;
		}
		
		System.out.println(num1);

	}
	
	
	private void addrec(int num1, int num2) {

		if(num2 ==0){
			System.out.println(num1);
		}else{
			addrec((num1 ^ num2),((num1 & num2)<<1));
		}		
		

	}


}
