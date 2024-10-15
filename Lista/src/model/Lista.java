package model;

public class Lista <T>
{
	No<T> primeiro;
	
	public No<T> particao(No low, No high) 
	{
        T pivot = (T) high.dado;
        No i = low;

        for (No j = low; j != high; j = j.proximo) {
            if ((int) j.dado < (int)pivot) {
                int temp = (int) i.dado;
                i.dado = j.dado;
                j.dado = temp;
                i = i.proximo;
            }
        }

        int temp = (int) i.dado;
        i.dado = high.dado;
        high.dado = temp;
        return i;
    }

	void quickSort(No low, No high) {
	    if (low == null || high == null || low == high || low == high.proximo) {
	        return;
	    }

	    No p = particao(low, high);
	    
	    // Find the node before p
	    No temp = low;
	    while (temp != null && temp.proximo != p) {
	        temp = temp.proximo;
	    }

	    if (temp != null) {
	        quickSort(low, temp);
	    }

	    quickSort(p.proximo, high);
	}
    No lastNode(No no) {
        if (no == null) {
            return null;
        }
        while (no.proximo != null) {
            no = no.proximo;
        }
        return no;
    }

    void sort(No no) {
        No headNo = lastNode(no);
        quickSort(no, headNo);
	
}
	public Lista()
	{
		primeiro = null;
	}
	public boolean isEmpty() {
		if(primeiro == null)
		{
			return true;
		}
		return false;
	}
	
	public void clear()
	{
		primeiro = null;
	}
	
	public int size()
	{
		int cont = 0;
		if(!isEmpty())
		{
			No <T> auxiliar = primeiro;
			while(auxiliar != null)
			{
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	private No<T> getNo(int pos) throws Exception
	{
		if (isEmpty())
		{
			throw new Exception("Posição invalida");
			
		}
		No<T> auxiliar = primeiro;
		int cont = 0;
		while(cont < pos)
		{
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}

	
	
	
	public void addFirst(T valor)
	{
		No <T >elemento = new No<T>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
		
		
		
		
	}
	
	
	
	public void addLast(T valor) throws Exception
	{
		int tamanho = size();
		
		if(isEmpty())
		{
			throw new Exception("Lista Vazia");
			
		}
		
		No<T> elemento = new No<T>();
		elemento.dado = valor;
		elemento.proximo = null;
		
		No<T> ultimo = getNo(tamanho -1);
		ultimo.proximo = elemento;
		
		
		
		
		
	}
	
	
	
	public void add(T valor, int posicao) throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Lista Vazia");
		}
			int tamanho = size();
			if (posicao < 0 || posicao > tamanho)
			{
				throw new Exception("Posicao invalida");
			}
			
			if (posicao == 0)
			{
				addFirst(valor);
	        }
			else if(posicao == tamanho)
			{
				addLast(valor);
				
			}
			
			else
			{
				No<T> elemento = new No<T>();
				elemento.dado = valor;
				No<T> anterior = getNo(posicao -1);
				anterior.proximo = elemento;
				
				
			}
			
	}
	
	
	public void removeFirst() throws Exception
	{
		if (isEmpty())
		{
			
		
		throw new Exception("Lista Vazia");
		
		
		}
	
		primeiro = primeiro.proximo;
		
		
	}
	
	
	
	
	public void removeLast() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Lista Vazia");
			
		}
		
		int tamanho = size();
		
		
		if(tamanho == 1)
		{
			removeFirst();
		}
		
		
		else
		{
			No<T> penultimo = getNo(tamanho -2);
			penultimo.proximo = null;
			
		}
		
	}
	
	
	public void remove(int pos) throws Exception
	{
		int tamanho = size();
		
		if (pos < 0  || pos > tamanho -1)
		{
			throw new Exception("Lista Vazia");
		
		}
		if(isEmpty())
		{
			throw new Exception("Lista Vazia");
		}
	
	
		if(pos == 0)
		{
			removeFirst();
		}
		else if(pos == tamanho -1)
		{
			removeLast();
		}
		else
		{
			No<T> anterior = getNo(pos - 1);
			No<T> atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	
		}
		public T get(int pos) throws Exception
		{
			if(isEmpty())
			{
				throw new Exception("Lista Vazia");
			}
			int tamanho = size();
			if(pos < 0 || pos > tamanho - 1)
			{
				throw new Exception("Posição Invalida");
			
			}
		
			No<T> auxiliar = primeiro;
			int cont = 0;
			while(cont < pos)
			{
				auxiliar = auxiliar.proximo;
				cont++;
			}
		T valor = auxiliar.dado;
		return valor;
		
	}
		
	
}