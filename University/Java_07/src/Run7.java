import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import javax.swing.SwingUtilities;

public class Run7 {
//	Lista<Odpowiedz> listaOdpowiedzi = new ArrayList<>(5);
//	Collections.shuffle.listaOdpowiedzi;
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try
				{
					new Okno();
				}
				catch(IOException ioe)
				{
					System.out.println(ioe.toString());
				}
				catch(NoGoodAnswerException ngae)
				{
					System.out.println(ngae.toString());
				}
				catch(TooManyAnswersException tmae)
				{
					System.out.println(tmae.toString());
				}
			}
		});
		
//	Test test=new Test();
//	String s;
//	s=test.read();
//	String[] sl;
//	sl=s.split("\n\n");
//	for(int i=0;i<sl.length;i++)
//	{
//		if(sl[i].startsWith("MCQ"))
//		{
//			sl[i]=sl[i].replace("MCQ\t","");
//			System.out.println(sl[i]);
//			String[] lines = sl[i].split("\n");
//			for(int j=1;j<lines.length;j++)
//			{
//				String valstr[] = lines[j].split("\t");
//				int num=Integer.parseInt(valstr[0]);
//				String strr=valstr[1];
//				System.out.println(num+", "+strr);
//			}
//		}
//		if(sl[i].startsWith("SCQ"))
//		{
//			sl[i]=sl[i].replace("SCQ\t","");
//			System.out.println(sl[i]);
//		}
//		if(sl[i].startsWith("CAL"))
//		{
//			sl[i]=sl[i].replace("CAL\t","");
//			System.out.println(sl[i]);
//		}
//		
//	}
//	      FileInputStream in = null;
//	      FileOutputStream out = null;
//
//	      try {
//	         in = new FileInputStream("input.txt");
//	         out = new FileOutputStream("output.txt");
//	         
//	         int c;
//	         while ((c = in.read()) != -1) {
//	            out.write(c);
//	         }
//	      }finally {
//	         if (in != null) {
//	            in.close();
//	         }
//	         if (out != null) {
//	            out.close();
//	         }
//	      }
	}
}
