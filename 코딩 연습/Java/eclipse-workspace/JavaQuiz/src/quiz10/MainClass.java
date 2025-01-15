package quiz10;

public class MainClass {
	public static void main(String[] args) {
		Computer cp = new Computer();
		
		KeyBoard keyBoard = new KeyBoard();
		Mouse mousse = new Mouse();
		Monitor monitor = new Monitor();
		
		cp.setKeyBoard(keyBoard);
		cp.setMonitor(monitor);
		cp.setMouse(mousse);
		
		cp.getMonitor().info();
		
		////////
		String dartResult="1S2D*3T";
		int answer = 0;
        int[] score = new int[3];
        String[] str = new String[3];
        int[] index_find=new int[3];
        int count=0;
        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i)>='0'&&dartResult.charAt(i)<='9'){
                index_find[count]=i;
                count++;
            } 
        }
        str[0]=dartResult.substring(index_find[0],index_find[1]);
        str[1]=dartResult.substring(index_find[1],index_find[2]);
        str[2]=dartResult.substring(index_find[2],dartResult.length());
        
        System.out.println(str[2]);
        System.out.println(-Integer.parseInt("12"));
	}
}
