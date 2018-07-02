//package knapsack;

import java.io.*;

import java.util.*;

public class assignmentP3 extends ArrayList<String>{
	
	public static long startT = 0;
	public static long endT=0;
	public static long total=0;
	
	
	
	public static void main(String args[]) throws IOException
	{
		
		startT = System.currentTimeMillis()/1000;

		String filename="";
                filename=(args.length==0)? "input.txt" :args[0];
                BufferedWriter bw=new BufferedWriter(new FileWriter(new File(args[1])));

		FileReader fr = new FileReader(filename);
		BufferedReader br =new BufferedReader(fr);
		assignmentP3 list=new assignmentP3();
		String line=null;
			
		
		while ((line=br.readLine())!=null)
		{
			list.add(line);
			
		}
		int count=0;
		int i=0;
		
		try {
				while(!list.isEmpty())
			{
					
					
					int siz=0;
					int weight=0;
					String sizet[]=list.get(0).split("\\s+");
					siz=Integer.parseInt(sizet[0]);
					weight=Integer.parseInt(sizet[1]);
					
					int knapsack[][]=new int [siz+1][3];
					int endm[][]=new int[siz+1][weight+1];
					
					int w[]=new int[siz+1];
					int p[]=new int[siz+1];
				
				for(i=1;i<=siz;i++)
				{
					
					for(int j=1;j<2;j++)
					{
						
						String sizt[]=list.get(i).split("\\s+");
						
						knapsack[i][j]=Integer.parseInt(sizt[0]);
						knapsack[i][j+1]=Integer.parseInt(sizt[1]);
						w[i]=knapsack[i][j];
						p[i]=knapsack[i][j+1];
						
						
					}
				}
					
				 count=count+1;
				
				
				endm=calculateknapsack(knapsack,weight,siz,w,p);
				int maxprofit=0;
				
				
				int x=siz;
				int y=weight;
				maxprofit=endm[x][y];
				
				String weights[]=new String[siz+1];
				String profit[]=new String[siz+1];
				
				
				int cm=1;
				
				while((x>0)&&(y>0))
				{
					
					if(endm[x][y]!=endm[x-1][y])
					{
						weights[cm]=Integer.toString(knapsack[x][1]);
						profit[cm]=Integer.toString(knapsack[x][2]);
						y=y-w[x];
						x=x-1;
						cm++;
					}
					else
					{
						x=x-1;
					}
					
					
				}
				
				
				
				list.removeRange(0,i);
				
				
				endT = System.currentTimeMillis()/1000;
				
				
				total=endT-startT;
				bw.write("SIZE:"+siz+" MAXPROFIT:"+maxprofit+" TIME:"+total+"\n");
				bw.write("ITEMS IN THE KNAPSACK"+"\n");
				for(int xx=1;xx<cm;xx++)
				{
					bw.write("Weight"+xx+":"+weights[xx]+" Profit"+xx+":"+profit[xx]+"\n");
					//bw.write("\n");
					
				}
			}
			
			bw.close();
						
			}
						
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
	
	
	
	public static int[][] calculateknapsack(int ks[][],int w,int s,int y[],int bk[])
	{
		int b[][]=new int[s+1][w+1];
		
		
		
		for(int k=0;k<=w;k++)
		{
			b[0][k]=0;
		}
		
		for(int r=1;r<=s;r++)
		{
			b[r][0]=0;
		
		
		for(int x=1;x<=w;x++)
		{
			if((y[r]<=x)&&((b[r-1][x-y[r]]+bk[r])>b[r-1][x]))
			{
				b[r][x]=b[r-1][x-y[r]] + bk[r];
				
			}
			else
			{
				b[r][x]=b[r-1][x];
				
			}
			
			
		}
		
		
		}

		
		return b;
				
	}
	

}
