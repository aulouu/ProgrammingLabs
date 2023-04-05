public class lab1_proga {
    public static void main(String[] args) {
		int p=19;
		int [] c = new int [15];
		for (int i=0; i<15; i++) {
			c[i]=p;
			p=p-1;
		    System.out.print (c[i] + " ");
		}




	    float x [] = new float [17];
		for (int i=0; i<17; i++) {
		    float k = (float)Math.random()*19 - 13;
			x[i]=k;
			System.out.println (x[i]);
		}
	



    
	    float [][] a = new float [15][17];
		for (int i=0; i<15; i++) {
		    for (int j=0; j<17; j++) {
			    if (c[i]==16)
				a[i][j] = (float)Math.log(Math.pow(Math.tan(Math.atan(Math.cos(x[j]))),2));
				else if (c[i]==6 || c[i]==9 || c[i]==11 || c[i]==12 || c[i]==13 || c[i]==17 || c[i]==18)
				a[i][j] = (float)Math.sin(Math.sin(x[j]+1)/3);
				else
				a[i][j] = (float)Math.cos(Math.pow(Math.pow(Math.PI + x[j],1.0/3),Math.sin(x[j])*((Math.pow(Math.cos(x[j]),(Math.pow(x[j]/3,3)+1)/2)-1/4))));
				System.out.printf ("%.4f   ", a[i][j]);
			}
		System.out.println ();
		}
	}
}
	

	     