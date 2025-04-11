package trieoperation;
import java.util.*;
class Trie
{
	Trie ch[];
	int wc;
	boolean ended;
	Trie()
	{
		ch=new Trie[26];
		wc=0;
		ended=false;
	}
}
public class trieoperation {

	public static void main(String[] args) {
		Scanner o=new Scanner(System.in);
		int n=o.nextInt();
		Trie root=new Trie();
		while(n--!=0)
		{
			int ops=o.nextInt();
			switch(ops) {
			case 1:
			{
				String s=o.next();
				insert(root,s);
				break;
			}
			case 2:
			{
				List<String>li=new ArrayList<>();
				String te="";
				getAllWords(root,li,te);
				System.out.println("The words are:");
				for(int j=0;j<li.size();j++)
				{
					System.out.println(li.get(j));
				}
				break;
			}
			case 3:
			{
				String s=o.next();
				System.out.println(doesExist(root,s));
				break;
			}
			case 4:
			{
				String s=o.next();
				List<String>li=new ArrayList<>();
				getAllWordsWithPrefix(root,li,s);
				System.out.println("The words with prefix "+s+" are:");
				for(int j=0;j<li.size();j++)
				{
					System.out.println(li.get(j));
				}
				break;
			}
			}
		}

	}
	static void insert(Trie root,String s)
	{
		Trie te=root;
		for(char ci:s.toCharArray())
		{
			int ind=ci-'a';
			if(te.ch[ind]==null)
				te.ch[ind]=new Trie();
			te=te.ch[ind];
			te.wc++;
		}
		te.ended=true;
	}
	static void getAllWords(Trie root,List<String>li,String te)
	{
		if(root.ended)li.add(te);
		for(int i=0;i<26;i++)
		{
			if(root.ch[i]!=null)
			{
				Character c=(char)(i+'a');
				getAllWords(root.ch[i],li,te+c);
			}
		}
	}
	static boolean doesExist(Trie root,String s)
	{
		Trie te=root;
		for(char ci:s.toCharArray())
		{
			int ind=ci-'a';
			if(te.ch[ind]==null)
				return false;
			te=te.ch[ind];
		}
		return te.ended;
	}
	static void getAllWordsWithPrefix(Trie root,List<String>li,String ps)
	{
		Trie te=root;
		for(char ci:ps.toCharArray())
		{
			int ind=ci-'a';
			if(te.ch[ind]==null)
				return;
			te=te.ch[ind];
		}
		getAllWords(te,li,ps);
	}

}