package model;
import model.*;

public class main {

	public static void main(String args[]) throws Exception
	{
	
	
		Lista l = new Lista();
		int vet[] = {10, 5, 8, 1, 9, 2, 4, 7, 3, 6};
		int tamanho = vet.length;
		int verificador = 0;
		
		l.addFirst(vet[0]);
		
		while(l.size() < tamanho)
		{

			l.add(vet[l.size()], l.size());
			
		}
		
		l.sort(l.primeiro);
		
		for(int i = 0; i < tamanho; i++)
		{
			System.out.println(l.get(i));
		}
		
	}
}
